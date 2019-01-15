<template>
  <div   class="el-input el-input-group el-input-group--prepend el-input--suffix" >
    <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{pageComment}}</label></div>
    <el-cascader clearable :size="size" v-model="val" :disabled="disabled"
                 :placeholder="pageComment"
                 @active-item-change="handleSelect"
                 :options="options2" style="width:100%;"
                 filterable
                 :props="props"
    ></el-cascader>
  </div>
</template>

<script>
  import {getAddress,queryAddressById} from '@/utils'
    export default {
      name: "linkage",
      data () {
        return {
          val:[],
          props: {
            label:"areaname",
            value: 'id',
            children: 'children'
          },
        }
      },
      watch:{
        val(val){
          this.$emit('input', val)
        },
        value(val){
          this.val=val;
        }
      },
      props: {
        size:{
          type:String,
          default:'mini'
        },
        isPage:{
          type:Boolean,
          default:false
        },
        disabled:{
          type:Boolean,
          default:false
        },
        // 使用v-module必须要使用value
        value: {
          default: '',
        },
        //层级选择,默认为3级,还有4级可以选
        level:{
          type:Number,
          default:3
        },
        //注释
        pageComment:{
          type:String,
          default:''
        }
      },
      methods:{
        //地址的选中方法
        handleSelect(item) {
          //获得层级
          var level = item.length;
          var address = [];
          queryAddressById(this.options2,item[level-1],address);
          if(address[0].isNext!='0' && address[0].children.length==0){
            address[0].children=getAddress(item[level-1],this.level);
            var children = address[0].children;
            for (var j = 0; j < children.length; j++) {
              var item1 = children[j];
              this.optionsMap[item1.id] = item1;
            }
          }
        },
      }
    }
</script>

<style scoped>

</style>
