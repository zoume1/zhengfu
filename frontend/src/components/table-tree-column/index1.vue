<template>
  <el-table-column :prop="prop" v-bind="$attrs">
    <template slot-scope="scope">
      <span @click.prevent="toggleHandle(scope.$index, scope.row)" :style="childStyles(scope.row)">
        <i :class="iconClasses(scope.row)" :style="iconStyles(scope.row)"></i>
        {{ scope.row[prop] }}
      </span>
    </template>
  </el-table-column>
</template>

<script>
  import isArray from 'lodash/isArray'
  import API from '@/api'
  export default {
    name: 'table-tree-column',
    props: {
      prop: {
        type: String
      },
      treeKey: {
        type: String,
        default: 'id'
      },
      parentKey: {
        type: String,
        default: 'parentId'
      },
      levelKey: {
        type: String,
        default: '_level'
      },
      childKey: {
        type: String,
        default: 'children'
      },
      pathUrl:{
        type: String,
      },
      orderBy:{
        type: String,
      }
    },
    methods: {
      childStyles (row) {
        return { 'padding-left': (row[this.levelKey] > 1 ? row[this.levelKey] * 7 : 0) + 'px' }
      },
      iconClasses (row) {
        return [ !row._expanded ? 'el-icon-caret-right' : 'el-icon-caret-bottom' ]
      },
      iconStyles (row) {
        return { 'visibility': this.hasChild(row) ? 'visible' : 'hidden' }
      },
      hasChild (row) {
        return row["isNext"]!='0'
      },
      // 切换处理
      toggleHandle (index, row) {
        //判断是否存在下级分类
        //if (this.hasChild(row)) {
        var list = this.$parent.store.states.data.slice(0);
        list[index]._expanded = !list[index]._expanded;
        var parentKey = this.parentKey;
        var params = {
          page: 1,
          limit:1000,
          sidx:this.orderBy,
          order:'asc'
        }
        params[parentKey]=row[this.treeKey];
          //判断是展开还是关闭
          if (list[index]._expanded) {
            API[this.pathUrl].list(params).then(({data})=> {
              list = list.splice(0, index + 1).concat(data.data.list).concat(list)
              this.$parent.store.commit('setData', list)
              this.$nextTick(() => {
                this.$parent.doLayout()
              })
            })
          } else {
            list = this.removeChildNode(list, row[this.treeKey])
            this.$parent.store.commit('setData', list)
            this.$nextTick(() => {
              this.$parent.doLayout()
            })
          }
      },
      // 移除子节点
      removeChildNode (data, parentId) {
        var parentIds = isArray(parentId) ? parentId : [parentId]
        if (parentId.length <= 0) {
          return data
        }
        //////console.log(parentIds);
        var ids = [];
        //遍历所有数据
        for (var i = 0; i < data.length; i++) {
          if (parentIds.indexOf(data[i][this.parentKey]) !== -1 && parentIds.indexOf(data[i][this.treeKey]) === -1) {
            ids.push(data.splice(i, 1)[0][this.treeKey])
            i--
          }
        }
        return this.removeChildNode(data, ids)
      }
    }
  }
</script>
