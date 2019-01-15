<template>
  <div class="mod-config">
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu   @open="handleOpen"  :default-active="indexId+''">
          <!--<el-submenu index="1">-->
          <!--  <template slot="title"><i class="el-icon-message"></i>模板导航</template>-->
              <el-menu-item v-for="(item,index) in templateList" :key="index" :index="item.id+''"   @click="handleOpen(item.id)" v-text="item.remark"></el-menu-item>
         <!-- </el-submenu>-->
        </el-menu>
      </el-aside>

      <el-container>
        <el-main>
          <el-input
            type="textarea"
            :autosize="{ minRows: 21, maxRows:20 }"
            placeholder="请输入内容"
            v-model="textarea3" :disabled="true">
          </el-input>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
<script>
  import API from '@/api'
  export default {
    data () {
      return {
        indexId:0,
        templateList: [],
        textarea3: '',
        tableId: 0
      }
    },
    components: {
      API
    },

    methods: {
      init: function (id) {
        this.tableId = id
        // 模板预览
        API.generatortemplate.queryGeneratorTemplateList().then(({data}) => {
          this.templateList = data.data
          if (this.templateList.length > 0) {
            this.handleOpen(this.templateList[0].id)
          }
        })
      },
      handleOpen (id) {
        API.generatortable.preview({tableId: this.tableId, templateId: id}).then(({data}) => {
          if (data.code === 0) {
            this.indexId=id
            this.textarea3 = data.data
          } else {
            this.textarea3 = '模板异常'
          }
        })
      }
    }
  }
</script>
