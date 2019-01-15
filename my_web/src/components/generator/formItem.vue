<template>
    <div>
      <!--数字number-->
      <el-form-item  :prop="field.fieldName"  v-if="field.inputType==='1'">
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-input-number clearable v-model="data" :disabled="isUpdate(field)"  :min="0"  :size="size"> </el-input-number>
        </div>
      </el-form-item>

      <el-form-item  :prop="field.fieldName"  v-else-if="field.inputType==='2'">
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-date-picker v-model="data" clearable :size="size"  type="date" style="width:100%;" value-format="yyyy-MM-dd"  :placeholder="field.pageComment" format="yyyy-MM-dd">
          </el-date-picker>
        </div>
      </el-form-item>
      <!--时间datetime-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType==='3'">
        <div class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-date-picker v-model="data" clearable :disabled="isUpdate(field)" :size="size" value-format="yyyy-MM-dd HH:mm:ss"  format="yyyy-MM-dd HH:mm:ss" :placeholder="field.pageComment" type="datetime" style="width:100%;"  >
          </el-date-picker>
        </div>
      </el-form-item>
      <!--下拉选select-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='4'">
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-select v-model="data" clearable  :disabled="isUpdate(field)" :size="size" :filterable="true" :placeholder="field.pageComment" style="width:100%;">
            <el-option
              v-for="(itemss,itemssIndex) in getBusConfig(model+pathUrl,field.dictionaryIndex).list" :key="itemssIndex"
              :label="itemss.confName"
              :value="itemss.confVue">
            </el-option>
          </el-select>
        </div>
      </el-form-item>
      <!--复选框-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='5'">
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-select  clearable style="width:100%" :size="size"   :disabled="isUpdate(field)" v-model="data"  multiple  :filterable="true" default-first-option  :placeholder="field.pageComment">
            <el-option
              v-for="(itemss,itemssIndex) in getBusConfig(model+pathUrl,field.dictionaryIndex).list"
              :key="itemssIndex"
              :label="itemss.confName"
              :value="itemss.confVue">
            </el-option>
          </el-select>
        </div>
      </el-form-item>

      <!--富文本框-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='6'">
        <div class="editor-container el-input el-input-group el-input-group--prepend el-input--suffix"  >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <editor id="editor_id"
                  height="400px"
                  width="100%"
                  style="width:100%"
                  :content.sync="data"
                  :pluginsPath="'/static/kindeditor/plugins/'"
                  :uploadJson="imgUrl"
                  filePostName="file"
                  :loadStyleMode="false"
                  :allowFileManager="false"
                  :allowImageRemote="false"
                  placeholder="商品详情"
          ></editor>
        </div>
      </el-form-item>
      <!--文本域-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='7'">
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-input :size="size" :autosize="{ minRows: 10, maxRows: 4}"  :disabled="isUpdate(field)" clearable
                    type="textarea"
                    :rows="2"
                    :placeholder="field.pageComment"
                    v-model="data">
          </el-input>
        </div>
      </el-form-item>
      <!--图片上传-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='8' || field.inputType=='9'">
        <upload  :disabled="isUpdate(field)" :pageComment="field.pageComment" v-model="data" :isMultiple="field.inputType=='9'"  :isPage="isPage" :size="size"></upload>
      </el-form-item>
      <!--搜索框-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='10'">
        <div  @click="activeIndex=field.dictionaryIndex">
          <el-autocomplete  clearable :size="size" style="width:100%;"  :disabled="isUpdate(field)"
                            class="inline-input"
                            v-model="data"
                            :fetch-suggestions="querySearch"
                            :placeholder="field.pageComment"
          > <template slot="prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;" >{{field.pageComment}}</label></template></el-autocomplete>
        </div>
      </el-form-item>
      <!--四级联动-->
      <el-form-item  :prop="field.fieldName"  v-else-if="field.inputType=='11'||field.inputType=='12'">
        <linkage     :disabled="isUpdate(field)" :level="field.inputType=='11'?4:3" :pageComment="field.pageComment" v-model="data"  :isPage="isPage" :size="size"> </linkage>
      </el-form-item>
      <!--创建条目输入框-->
      <el-form-item  :prop="field.fieldName"   v-else-if="field.inputType=='13'">
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-select clearable  style="width:100%" :size="size"   :disabled="isUpdate(field)" v-model="data"   multiple
                      filterable
                      allow-create
                      default-first-option  :placeholder="field.pageComment">
            <el-option
              v-for="(itemss,itemssIndex) in []"
              :key="itemssIndex"
              :label="itemss.label"
              :value="itemss.value">
            </el-option>
          </el-select>
        </div>
      </el-form-item>
      <!--密码框-->
     <!-- <el-row :gutter="20" v-else-if="field.inputType=='14'">
        <el-col :lg="isPage?12:24">
          <el-form-item :prop="field.fieldName">
            <div class="el-input el-input-group el-input-group&#45;&#45;prepend el-input&#45;&#45;suffix">
              <div class="el-input-group__prepend" v-if="isPage"><label class="el-form-item__label"  style="padding: 0;line-height: initial;">{{field.pageComment}}</label>
              </div>
              <el-input clearable v-model="data" type="password" :placeholder="field.pageComment" :size="size"></el-input>
            </div>
          </el-form-item>
        </el-col>
        <el-col :lg="isPage?12:24">
          <el-form-item :prop="field.fieldName+'password'">
            <div class="el-input el-input-group el-input-group&#45;&#45;prepend el-input&#45;&#45;suffix">
              <div class="el-input-group__prepend" v-if="isPage"><label class="el-form-item__label"  style="padding: 0;line-height: initial;">确认{{field.pageComment}}</label>
              </div>
              <el-input clearable v-model="dataForm[field.fieldName+'password']" type="password" :placeholder="'确认'+field.pageComment" :size="size"></el-input>
            </div>
          </el-form-item>
        </el-col>
      </el-row>-->
      <password  v-else-if="field.inputType=='14'"  :dataRule="dataRule"  :dataForm="dataForm" :fieldName="field.fieldName" :pageComment="field.pageComment" :isPage="isPage" :size="size"> </password>
      <!--树表格-->
      <el-form-item   :prop="field.fieldName" v-else-if="field.inputType=='15' || field.inputType=='17'" >
        <tree v-model="data" :dataForm="dataForm" :fieldName="field.fieldName" :pageComment="field.pageComment" :dictionaryIndex="field.dictionaryIndex" :isMultiple="field.inputType=='15'" :isPage="isPage"  :size="size"></tree>
      </el-form-item>
      <!--单选框-->
      <el-form-item   :prop="field.fieldName" v-else-if="field.inputType=='16'" >
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-radio-group v-model="data" style="    padding: 6px;border: 1px solid #dcdfe6;border-radius: 0 4px 4px 0;" :size="size" clearable>
            <el-radio :label="itemss.confVue"  :key="itemssIndex" v-for="(itemss,itemssIndex) in getBusConfig(model+pathUrl,field.dictionaryIndex).list"  :size="size">{{itemss.confName}}</el-radio>
          </el-radio-group>
        </div>
      </el-form-item>
      <!--开关输入框-->
      <el-form-item   :prop="field.fieldName" v-else-if="field.inputType=='18'" >
        <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
          <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></div>
          <el-switch clearable
            v-model="data"
            :active-text="field.pageComment"
           >
          </el-switch>
        </div>
      </el-form-item>
      <!--普通文本框-->
      <el-form-item  :prop="field.fieldName"  v-else >
        <el-input :size="size" v-model="data" :placeholder="field.pageComment"  :disabled="isUpdate(field)" clearable>
          <template slot="prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{field.pageComment}}</label></template>
        </el-input>
      </el-form-item>
    </div>
</template>

<script>
  import API from '@/api'
  import linkage from '@/components/input/linkage.vue'
  import password from '@/components/input/password.vue'
  import tree from '@/components/input/tree.vue'
  import upload from '@/components/input/upload.vue'
    export default {
        name: "field",
        data(){
          return {
            imgUrl: API.sysoss.upload(this.$cookie.get('PC_TOKEN')),
            data:this.value,
          };
        },
      components: {
        linkage,
        upload,
        password,
        tree,
      },
      watch:{
        value:function(val){
         this.data=val;
        },
        data:function(val){
          this.$emit('input', val)
        },
      },
      props:{
        value:{

        },
        size:{
          type:String,
          default:'mini'
        },
        isPage:{
          type:Boolean,
          default:false
        },
        field:{
          type:Object
        },
        dataRule:{},
        dataForm:{},
        model:{},
        pathUrl:{},
        type:{}
      },
      methods:{
        isUpdate(item){
          return item.isUpdate=='1'&&!(!this.dataForm.id)
        },
        createFilter(queryString) {
          return (restaurant) => {
            return (restaurant.confName.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
          };
        },
        querySearch(queryString, cb) {
          var restaurants = this.getBusConfig(this.module+this.pathUrl,this.activeIndex).list;
          for(var i in restaurants){
            restaurants[i].value=restaurants[i].confName;
          }
          //查询表格数据
          var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
          // 调用 callback 返回建议列表的数据
          cb(results);
        },
      }
    }
</script>

<style scoped>

</style>
