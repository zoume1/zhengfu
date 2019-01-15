<template>
  <div class="table-container pull-chheight">
    <el-card class="box-card">
    <!--用户表格-->
    <el-tabs class="tabs" type="card"  style="width:100%;height:100%;">
      <el-tab-pane class="pane" label="个人会员" v-if="type=='0' || type==null">
        <person ref="person"></person>
      </el-tab-pane>
      <el-tab-pane class="pane" label="企业会员" v-if="type=='1' || type==null">
        <enterprise ref="enterprise"></enterprise>
      </el-tab-pane>

      <el-tab-pane class="pane" label="团体会员" v-if="type=='2' || type==null">
        <leagueMembers ref="leagueMembers"></leagueMembers>
      </el-tab-pane>
    </el-tabs>
    </el-card>
  </div>
</template>

<script>
  import upload from '@/components/input/upload.vue'
  import person from './person/index.vue'
  import leagueMembers from './leagueMembers/index.vue'
  import enterprise from './enterprise/index.vue'

  export default {
    components: {
      upload,
      person,
      leagueMembers,
      enterprise
    },
    data() {
      return {
        type:this.user==null?null:this.user.userType
      }
    },
    created(){
      console.log(this.user);
    },
    methods: {

      onSubmit() {
        console.log('submit!');
      },
      addAllOrUpdateHandle() {
        this.$nextTick(() => {
          this.$refs.tablefield.addAllOrUpdateHandle()
        })
      },
      addOrUpdateHandle(row) {
        //       this.$nextTick(() => {
        //                  this.$refs.tablefield.addOrUpdateHandle(row)
        // })
        this.update = true;
      },
      deleteHandle(row) {
        this.$nextTick(() => {
          this.$refs.tablefield.deleteHandle(row)
        })
      },
      setListSelections(val) {
        this.dataListSelections = val
      },
      getDataList() {
        this.$nextTick(() => {
          this.$refs.tablefield.getDataList()
        })
      }
    }
  }
</script>
<style scoped>
  .tabs .el-tabs__header {
    top: 107px !important;
    position: initial;
  }

  .tabs .el-card__body {
    padding: 0 !important;
  }

  .site-content--tabs > .el-tabs .el-tabs__content {
    padding: 0;
  }

  .pane {
    min-height: 800px;
  }

  .col {
    border: 1px solid red;
  }

  .col >>> .el-form-item__content {
    width: 60%;
  }

  .col .el-form-item {
    margin-bottom: 0px;
  }

  .tabs >>> .el-tabs__header {
    position: initial !important;
    padding: 0;
  }
</style>
