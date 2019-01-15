<template>
  <div>
    <basic-container>
      <avue-form :option="option"
                 v-model="form"
                 @submit="handleSubmit"></avue-form>
    </basic-container>
    <basic-container>
      <el-button @click.native="formate"
                 style="margin: 8px 0">格式化</el-button>
      <el-input type="textarea"
                :autosize="{ minRows: 2, maxRows: 15}"
                placeholder="请输入内容"
                v-model="formJson">
      </el-input>
    </basic-container>
  </div>
</template>

<script>
import option from '@/const/select/selectOption'
export default {
  data () {
    return {
      option: option,
      formJson: '',
      form: {
        "province": "110000",
        "city": "110100",
        "area": "110101"
      }
    }
  },
  created () {
    this.formJson = JSON.stringify(this.option, null, 2);
  },
  mounted () {

  },
  methods: {
    formate () {
      let p = new Promise((resolve, reject) => {
        resolve(JSON.parse(this.formJson));
      });
      p.then(data => {
        this.option = data;
        this.formJson = JSON.stringify(data, null, 2);
        this.$notify({
          message: '数据加载成功',
          type: 'success',
        });
      })
        .catch(err => {
          this.$notify({
            center: true,
            dangerouslyUseHTMLString: true,
            message: `JSON格式错误<br \>\n${err}`,
            type: 'error',
          });
        });
    },
    handleSubmit (form) {
      this.form = form;
      this.$message({
        message: form,
        type: "success"
      });
    }
  }
}
</script>

<style>
</style>
