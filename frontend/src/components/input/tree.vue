<template>
  <div id="trees">
    <div class="el-input el-input-group el-input-group--prepend el-input--suffix">
      <div class="el-input-group__prepend" v-if="isPage"><label  class="el-form-item__label" style="padding: 0;line-height: initial;">{{pageComment}}</label></div>
      <el-tree clearable @check="chage" :highlight-current="true" :expand-on-click-node="false" v-if="isMultiple"
               :data="treeConfig.data"
               :filter-node-method="filterNode"
               :props="{
                label:treeConfig.label,

                children: 'children'
              }" size="mini"
               node-key="id"
               ref="tree"
               :default-expand-all="false"
               show-checkbox>
      </el-tree>
      <div v-if="!isMultiple" >
        <el-popover ref="menuListPopover" placement="bottom-end" trigger="click">
          <el-input
            placeholder="输入关键字进行过滤"
            v-model="filterText">
          </el-input>
          <el-tree clearable :data="treeConfig.data" :filter-node-method="filterNode" :props="{
                label:treeConfig.label,
                children: 'children'
              }" node-key="id" ref="tree" @current-change="menuListTreeCurrentChangeHandle" :default-expand-all="false"
                   :highlight-current="true" :expand-on-click-node="false">
          </el-tree>
        </el-popover>
        <el-input v-model="name" v-popover:menuListPopover :readonly="true" :placeholder="pageComment" :size="size"  ></el-input>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "tree",
    data() {
      return {
        filterText:'',
        name: null,
        treeConfig: {},
        key:-666666,
      }
    },

    watch: {
      filterText(val) {
        console.log(this.$refs);
        this.$refs.tree.filter(val);
      },
      value(value) {
        // if(value==null||value==''){
        //   return;
        // }
        this.name=null;
        try {
          if (this.isMultiple) {
            var data = JSON.parse(JSON.stringify(value));
            this.$nextTick(() => {
              var idx = data.indexOf(this.key)
              if (idx !== -1) {
                data.splice(idx, data.length - idx)
              }
              this.$refs.tree.setCheckedKeys(data)
            });
          } else {
            var ids = [];
            this.treeSelectMenu(this.treeConfig.data, parseInt(value), ids);
            this.name = ids[0][this.treeConfig.label];
          }
        }catch (e) {
        }
        this.$emit('input', value)
      },
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
      // 使用v-module必须要使用value
      value: {
        default: 0,
      },
      //注释
      pageComment: {
        type: String,
        default: ''
      },
      dictionaryIndex: {
        type: String
      },
      dataForm: {
        type: Object
      },
      fieldName: {
        type: String
      },
      isMultiple: {
        type: Boolean,
        default: false
      },
    },
    created:function () {
      this.treeConfig = this.getTreeConfig(this.dictionaryIndex);
    },
    methods: {
      filterNode(value, data) {
        console.log(value,data,this.treeConfig.label,data[this.treeConfig.label]);
        if (!value) return true;
        return (data[this.treeConfig.label]+'').indexOf(value) !== -1;
      },
      treeSelectMenu(list,id,ids){
        for (var i in list) {
          var item = list[i];
          if (item.id === id) {
            ids[0] = item;
            return;
          } else if (item.children != null && item.children.length > 0) {
            this.treeSelectMenu(item.children, id, ids)
          }
        }
      },
      // 菜单树选中
      menuListTreeCurrentChangeHandle(data, node) {
       // this.value = data.id;
        this.name = data[this.treeConfig.label];
        this.dataForm[this.treeConfig.levelKey]=data[this.treeConfig.levelKey]+1;
        this.$emit('input',data.id);
      },
      chage(value) {
        ////console.log( [].concat(this.$refs.tree.getCheckedKeys(), [-666666], this.$refs.tree.getHalfCheckedKeys()));
       this.value=this.$refs.tree.getCheckedKeys().concat([this.key], this.$refs.tree.getHalfCheckedKeys())
      }
    }
  }
</script>

<style >

  #trees >>> .el-tree--highlight-current {
    height: 400px!important;
    overflow-y: scroll!important;
  }

</style>
