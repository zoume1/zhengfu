<template>
  <div class="table-container pull-chheight">
    <basic-container>
    <el-form :inline="true" @keyup.enter.native="getDataList()" style="margin-bottom:60px;">
      <seek ref="seek" v-model="seek" :tableFieldMap="tableFieldMap"  :pathUrl="pathUrl" :model="model"></seek>
      <div style="float:right">
        <el-button type="primary" @click="getDataList()" size="small">查询</el-button>
        <el-button :type="items.type" plain v-for="(items,index) in formButton"  :key="index" v-if="isAuth(model+':'+pathUrl+':'+items.scope)"
                   :disabled="items.disabled!=undefined&&items.disabled(dataListSelections)" @click="items.fun()"
                   size="small" v-text="items.name"></el-button>
      </div>
    </el-form>
    <el-table  row-key="id" ref="table"
               :default-sort="{prop:orderBy, order: order}"
               @sort-change="sort"
               stripe
               :data="dataList"
               border height="500"
               size="mini"
               v-loading="dataListLoading"
               @selection-change="selectionChangeHandle"
               style="width: 100%;">
      <el-table-column
        srtable="custom"
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <template v-for="(item,index) in tableFieldMap.columns"   v-if="item.tableSet=='0'" >
        <table-tree-column v-if="item.fieldName===tableFieldMap.treeFieldName" :orderBy="orderBy"
                           :prop="item.fieldName"
                           header-align="center"
                           :pathUrl="pathUrl"
                           :treeKey="tableFieldMap.treeKey"
                           :label="item.pageComment" :parentKey="tableFieldMap.parentKey"
                           :levelKey="tableFieldMap.levelKey">
        </table-tree-column>
        <el-table-column
          sortable="custom"
          :prop="item.fieldName"
          header-align="center"
          align="center" :label="item.pageComment" height="10" v-else>
          <template slot-scope="scope">
            <!--日期date-->
            <div v-if="item.inputType==='2'">
              <i class="el-icon-time"></i>
              <span  v-text="getText(scope.row[item.fieldName])"></span>
            </div>
            <!-- 时间datetime-->
            <div v-else-if="item.inputType==='3'">
              <i class="el-icon-time"></i>
              <span  v-text="scope.row[item.fieldName]"></span>
            </div>

            <!--上传图片-->
            <span v-else-if="item.inputType==='8'||item.inputType==='9'"><img :src="oneImg(scope.row[item.fieldName],item.inputType==='9')"
                                                                              @click="handlePictureCardPreview(scope.row[item.fieldName],item.inputType==='9')"
                                                                              style="width:50px;height:50px;">
        </span>
            <!--下拉选selec-->
            <span v-else-if="item.inputType=='4'|| item.inputType=='16' || item.inputType=='17'" v-text="getBusConfig(model+pathUrl,item.dictionaryIndex).map[scope.row[item.fieldName]]"> </span>
            <!--复选框-->
            <span v-else-if=" item.inputType=='5'"  v-text="selectText(getBusConfig(model+pathUrl,item.dictionaryIndex).map,scope.row[item.fieldName])"> </span>
            <span v-else-if=" item.inputType=='11' ||  item.inputType=='12'" v-text="addJsonText(scope.row[item.fieldName])"> </span>
            <span v-else-if=" item.inputType=='18'" v-text="scope.row[item.fieldName]?'是':'否'"></span>
            <span v-else v-text="scope.row[item.fieldName]"></span>
          </template>
        </el-table-column>

      </template>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="300"
        label="操作">
        <template slot-scope="scope">
          <el-button :type="items.type" plain v-for="(items,index) in operation" :key="index"   v-if="isAuth(model+':'+pathUrl+':'+items.scope)"
                     :disabled="items.disabled!=undefined&&items.disabled(scope.row)" @click="items.fun(scope.row)" v-show="!(items.isShow!=undefined && !items.isShow(scope.row))"
                     size="small" v-text="items.name"></el-button>
        </template>
      </el-table-column>

    </el-table>
    <!--   <div class="block" style="display:flex;align-items:center;justify-content: space-between">-->
    <!--<span class="demonstration" style="margin-top: 15px;">显示总数:10000</span>-->
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!--  </div>-->
    <!-- 弹窗, 新增 / 修改 -->
    <save ref="save" :pathUrl="pathUrl" :model="model" @refreshDataList="getDataList" :defaultForm="dataForm" :tableFieldMap="tableFieldMap"  :dataFormDisabled="dataFormDisabled"  :updateDataFormSubmit="updateDataFormSubmit"></save>
    <!--批量新增-->
    <saveall ref="saveall" :model="model" :pathUrl="pathUrl" @refreshDataList="getDataList" :defaultForm="dataForm"   :tableFieldMap="tableFieldMap"  :dataFormDisabled="dataFormDisabled" :updateDataFormSubmit="updateDataFormSubmit"></saveall>
    <previewEdition ref="previewEdition" @refreshDataList="getDataList"  ></previewEdition>
    </basic-container>
  </div>
</template>

<script>
  import API from '@/api'
  import {getAddress, queryAddressById,getCookie} from '@/utils'
  import previewEdition from '@/components/input/previewEdition.vue'
  import seek from '@/components/generator/seek.vue'
  import save from '@/components/generator/save.vue'
  import saveall from '@/components/generator/saveall.vue'
  import TableTreeColumn from '@/components/table-tree-column/index1'
  import Sortable from 'sortablejs'
  export default {
    name: 'tablefield',
    components: {
      save,
      saveall,
      seek,
      TableTreeColumn,
      previewEdition
    },
    data() {
      return {
        saveall: false,
        tableFieldMap: {},
        sortData: {
          order: undefined,
          sidx: undefined
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 20,
        totalPage: 0,
        dataListLoading: false,
        addOrUpdateVisible: false,
        dataListSelections: [],
        prewImgLoad: false,
        prewImg: null,
        seek:{}
      }
    },
    props: {
      order:{
        type:String,
        default:"descending"
      },
      orderBy:{
        type:String,
        default:"createTime"
      },
      seekForm: {
        type: Object,
        default:function () {
          return {}
        }
      },
      dataFormDisabled: {
        type: Object,
        default: function () {
          return {}
        }
      },
      dataForm: {
        type: Object,
        default: function () {
          return {}
        }
      },
      pathUrl: {
        type: String
      },
      model: {
        type: String
      },
      templateHtml: {
        type: String
      },
      //操作按钮
      operation: {
        type: Array,
        default: function () {
          return []
        }
      },
      //表格按钮
      formButton: {
        type: Array,
        default: function () {
          return []
        }
      },
      setListSelections: {
        type: Function
      },
      //表格数据
      tabData:{
        type:Object,
        default: function (val) {
          return null
        }
      },
      // 表单提交
      updateDataFormSubmit: {
        type: Function,
        default:null
      }
    },
    watch: {
      //监听勾选数据改变
      dataListSelections(val) {
        this.setListSelections(val)
      },
      seekForm: function (seekData) {
        this.seek=seekData;
      },
        deep: true    //深度监听
    },
    mounted(){
      this.seek=this.seekForm;
    },
    created() {
      var that = this;
      if(this.tabData==null){
        API.common.jqueryRequest('/'+this.model+'/'+this.pathUrl+'/selectTableConfig',"get",{},function(data){
            that.tableFieldMap = data.data;
          if (that.tableFieldMap.parentKey!=undefined) {
            that.seekForm[that.tableFieldMap.parentKey] = 0;
          }
        },false,false)
      }else {
        that.tableFieldMap=this.tabData;
      }
    },
    methods: {
      getText(value){
        var now = new Date(value);
        var yy = now.getFullYear();      //年
        var mm = now.getMonth() + 1;     //月
        var dd = now.getDate();          //日
        // var hh = now.getHours();         //时
        // var ii = now.getMinutes();       //分
        // var ss = now.getSeconds();       //秒
        return yy+"-"+mm+"-"+dd;
      },
      arrayParse(val){
        if(val==null||val==''){
          return '';
        }
        return JSON.parse(val).join();
      },
      // 预览多图片事件
      handlePictureCardPreview: function (url,boo) {
        this.$refs.previewEdition.init(url,boo);
      },
      oneImg(val,boo) {
        if(val==null||val==''){
          return '';
        }
        if(boo){
          var list=null;
          try{
            list = JSON.parse(val)[0].url;
          }catch (e) {
            list=val
          }
          return  list
        }else{
          return val;
        }
      },
      addJsonText(val) {
        if (val == null || val == undefined || val == '') {
          return '';
        }
        var str = "";
        var list = JSON.parse(val);
        if (list[0] != null) {
          var item = list[0];
          var obj = this.optionsMap[item];
          if (obj != null && obj.isNext != '0' && obj.children!=undefined&& obj.children.length == 0) {
            var children = getAddress(item,3);
            for (var j = 0; j < children.length; j++) {
              var item1 = children[j];
              this.optionsMap[item1.id] = item1;
            }
            obj.children = children
          }
          str += obj.areaname;
        }
        if (list[1] != null) {
          var item = list[1];
          var obj = this.optionsMap[item];
          if (obj != null && obj.isNext != '0' && obj.children!=undefined &&obj.children.length == 0) {
            var children =  getAddress(item,3);
            for (var j = 0; j < children.length; j++) {
              var item1 = children[j];
              this.optionsMap[item1.id] = item1;
            }
            obj.children = children
          }
          str += ">" + obj.areaname;
        }
        if (list[2] != null) {
          var item = list[2];
          var obj = this.optionsMap[item];
          if (obj != null && obj.isNext != '0' && obj.children!=undefined&& obj.children.length == 0) {
            var children =  getAddress(item,3);
            for (var j = 0; j < children.length; j++) {
              var item1 = children[j];
              this.optionsMap[item1.id] = item1;
            }
            obj.children = children
          }
          str += ">" + obj.areaname;
        }
        if (list[3] != null) {
          var item = list[3];
          var obj = this.optionsMap[item];
          if (obj != null && obj.isNext != '0' && obj.children!=undefined && obj.children.length == 0) {
            var children =  getAddress(item,3);
            for (var j = 0; j < children.length; j++) {
              var item1 = children[j];
              this.optionsMap[item1.id] = item1;
            }
            obj.children = children
          }
          str += ">" + obj.areaname;
        }

        return str;
      },
      selectText(map, val) {
        if (val == null) {
          return '';
        }
        var list = [];
        var vals = JSON.parse(val)
        for (var i in vals) {
          var item = vals[i];
          list.push(map[item])
        }
        return list.join();
      },
      sort(value) {
        this.sortData.sidx = value.prop
        this.sortData.order = value.order === 'descending' ? 'desc' : 'asc'
        this.getDataList()
      },
      // 获取数据列表
      getDataList() {
        var that = this;
        //默认拥有数据
        this.dataListLoading = true
        //查询默认分页参数
        var params = {
          page: this.pageIndex,
          limit: this.pageSize,
          sidx: this.sortData.sidx,
          order: this.sortData.order
        }
        //判断是否有表格筛选条件
        for (var key in this.seek) {
          if (this.seek[key] != null) {
            if (this.seek[key] instanceof Array) {
              params[key] = JSON.stringify(this.seek[key])
            } else {
              params[key] = this.seek[key]
            }
          }
        }
        setTimeout(function(){
          //发起表格请求
          API[that.pathUrl].list(params).then(({data}) => {
            if (data && data.code === 0) {
              that.dataList = data.data.list
              that.totalPage = data.data.totalCount
              that.rowDrop()
              if (data.data.totalPage < that.pageIndex && data.data.totalPage !== 0) {
                that.pageIndex = 1;

                that.getDataList()
              }
            } else {
              that.dataList = []
              that.totalPage = 0
            }
            that.dataListLoading = false
          })
        },500)

      },
      // 每页数
      sizeChangeHandle(val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle(val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle(val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle(row) {
        this.addOrUpdateVisible = true;
        if(row===undefined){
          this.dataForm.sort=this.totalPage+1;
        }
        var id = row===undefined?0:row.id
        this.$nextTick(() => {
          this.$refs.save.init(id)
        })
      },
      // 删除
      deleteHandle(id) {
        if (id != null) {
          id = id.id;
        }
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          API[this.pathUrl].del(ids).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.reloadBusConfig(this.model + this.pathUrl, this.tableFieldMap.tableName);
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      },
      // 批量新增
      addAllOrUpdateHandle() {
        this.saveall = true
        this.dataForm.sort=this.totalPage;
        this.$nextTick(() => {
          this.$refs.saveall.init()
        })
      },
      //行拖拽
      rowDrop() {
        const tbody = document.querySelector('.el-table__body-wrapper tbody')
        const _this = this
        Sortable.create(tbody, {
          onEnd({ newIndex, oldIndex }) {
            console.log(API);
            API[_this.pathUrl].sort([_this.dataList[newIndex].id,_this.dataList[oldIndex].id]).then(({data}) => {
              if (data && data.code === 0) {
                _this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    // const currRow = _this.dataList.splice(oldIndex, 1)[0]
                    // _this.dataList.splice(newIndex, 0, currRow)
                    _this.getDataList()
                  }
                })
              } else {
                _this.$message.error(data.msg)
              }
            })

          }
        })
      },
      //列拖拽
      columnDrop() {
        const wrapperTr = document.querySelector('.el-table__header-wrapper tr')
        this.sortable = Sortable.create(wrapperTr, {
          animation: 180,
          delay: 0,
          onEnd: evt => {
            const oldItem = this.dropCol[evt.oldIndex]
            this.dropCol.splice(evt.oldIndex, 1)
            this.dropCol.splice(evt.newIndex, 0, oldItem)
          }
        })
      },
      returnSave(){
        return   this.$refs.save;
      },
    }
  }
</script>

<style scoped>

</style>
