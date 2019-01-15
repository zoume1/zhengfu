<template>
  <el-row :gutter="20">
    <el-col :lg="isPage?12:24">
      <el-form-item :prop="fieldName">
        <div class="el-input el-input-group el-input-group--prepend el-input--suffix">
          <div class="el-input-group__prepend" v-if="isPage"><label class="el-form-item__label"  style="padding: 0;line-height: initial;">{{pageComment}}</label>
          </div>
          <el-input clearable v-model="dataForm[fieldName]" type="password" :placeholder="pageComment" :size="size"></el-input>
        </div>
      </el-form-item>
    </el-col>
    <el-col :lg="isPage?12:24">
      <el-form-item :prop="(fieldName+'password')">
        <div class="el-input el-input-group el-input-group--prepend el-input--suffix">
          <div class="el-input-group__prepend" v-if="isPage"><label class="el-form-item__label"  style="padding: 0;line-height: initial;">确认{{pageComment}}</label>
          </div>
          <el-input clearable v-model="dataForm[fieldName+'password']" type="password" :placeholder="'确认'+pageComment" :size="size"></el-input>
        </div>
      </el-form-item>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "password",
    data() {
      return {
      }
    },

    watch: {

    },
    props: {
      size: {
        type: String,
        default: 'mini'
      },
      isPage: {
        type: Boolean,
        default: false
      },

      //注释
      pageComment: {
        type: String,
        default: ''
      },
      dataRule: {
        type: Object
      },
      dataForm: {
        type: Object,
        default:{}
      },
      fieldName: {
        type: String,
      }
    },
    created: function () {
      var that = this;
      // that.dataForm[that.fieldName] = '';
      // that.dataForm[that.fieldName + 'password'] = '';
      // that.dataRule[that.fieldName + 'password'] = [{
      //   fieldName: that.fieldName + 'password', validator: function (rule, value, callback) {
      //     console.log(that.dataForm[that.fieldName],value);
      //     if(value==undefined){
      //       value="";
      //     }
      //     if(that.dataForm[that.fieldName]==undefined){
      //       that.dataForm[that.fieldName]=''
      //     }
      //     if (!that.dataForm.id && !/\S/.test(value)) {
      //       callback(new Error('确认密码不能为空'))
      //     } else if (that.dataForm[that.fieldName] !== value ) {
      //       callback(new Error('确认密码与密码输入不一致'))
      //     } else {
      //       callback()
      //     }
      //   }
      //   , trigger: 'blur'
      // }];
    },
    methods: {}
  }
</script>

<style scoped>

</style>
