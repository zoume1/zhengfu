<template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会首页</a> > <a>在线交流</a>
        </div>
        <div class="onlineCont">
          <div class="onlineLeaving">
            <el-form ref="dataForm" :model="dataForm" :rules="formRu" label-width="80px">
              <el-form-item label="留言人" prop="name">
                <el-input v-model="dataForm.name"></el-input>
              </el-form-item>
              <el-form-item label="联系方式"  prop="contactWay">
                <el-input v-model="dataForm.contactWay"></el-input>
              </el-form-item>
              <el-form-item label="来自" prop="source">
                <el-input v-model="dataForm.source"></el-input>
              </el-form-item>
              <el-form-item label="性别" prop="sex">
                <el-select v-model="dataForm.sex" placeholder="请选择">
                  <el-option :label="item.confName" :value="item.confVue" v-for="(item,index) in sysConfig['lp_leave_word_sex'].list" :key="index"> </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="留言内容" prop="center">
                <el-input type="textarea" v-model="dataForm.center" :rows="4"></el-input>
              </el-form-item>
              <el-form-item label="验证码" prop="captcha">
                <el-input v-model="dataForm.captcha" style="width: 40%;" ></el-input>
                <img :src="captchaPath" alt="" style="vertical-align: bottom;height:40px;" @click="getCaptcha()">

              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit()">提交</el-button>
                <el-button @click="form={}">清空</el-button>
              </el-form-item>
            </el-form>
          </div>
          <div class="onlineMsg">
            <el-form label-width="80px" style="border-bottom:1px solid #e4e4e4;">
              <el-row :gutter="10">

                <el-col :lg="7">
                  <el-form-item label="留言ID" prop="desc">
                    <el-input v-model="formData.id"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :lg="7">
                  <el-form-item label="姓名" prop="desc">
                    <el-input v-model="formData.name" placeholder="姓名"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :lg="7">
                  <el-form-item label="联系方式" prop="desc">
                    <el-input v-model="formData.contactWay" placeholder="联系方式"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :lg="3">
                    <el-button type="primary" @click="getList()">查找</el-button>
                </el-col>
              </el-row>
            </el-form>
            <div class="msgCont" v-for="item in replyCont.list">
              <ul>
                <li>留言人ID：{{item.id}}</li>
                <li>留言时间：{{item.createTime}}</li>
                <li>留言人：{{item.name}}</li>
                <li>联系方式：{{item.contactWay}}</li>
                <li>来自：{{item.source}}</li>
                <li>性别：{{sysConfig['lp_leave_word_sex'].map[item.sex]}}</li>
              </ul>
              <p>留言内容：{{item.center}}</p>
              <div class="reply">
                答复：{{item.response}}
              </div>
            </div>
            <div class="imgblock">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="formData.page"
                :page-sizes="[10, 20, 50, 100]"
                :page-size="10"
                layout="total, sizes, prev, pager, next, jumper"
                :total="replyCont.totalCount">
              </el-pagination>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div style="position: relative;bottom: -730px;">
      <footer-nav></footer-nav>
    </div>
  </div>
</template>

<script>
  import Nav from '../components/Nav'
  import API from '@/api'

  import ListLeft from '../components/ListLeft';
  import footerNav from '../components/footer_nav'
  import { getUUID } from '@/utils'
  export default {
    name: 'onlineMsg',
    data () {
      return {
        dataForm: {
          "captcha":"",
          "center":"",
          "contactWay":"",
          "name":"",
          "sex":"",
          "uuid":"",
        },
        form:{

        },
        currentPage4: 4,
        replyCont: {},
        captchaPath:null,
        formRu:{
          captcha: [
            { required: true, message: '验证码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '留言人不能为空', trigger: 'blur' }
          ],
          center: [
            { required: true, message: '留言内容不能空', trigger: 'blur' }
          ],
          contactWay: [
            { required: true, message: '联系方式不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
        },
        formData:{
          page:1,
          limit:10,
          sidx:"createTime",
          order:"desc"
        },
      }
    },
    mounted(){
      this.getCaptcha(this.form);
      this.getList();
    },
    methods: {
      // 获取验证码
      getCaptcha () {
        var that = this;
        that.dataForm.uuid = getUUID()
        that.captchaPath = API.common.captcha(that.dataForm.uuid)
      },
      onSubmit(){
        var that = this;

        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            API.lpleaveword.add(that.dataForm).then(({data})=>{
              if (data && data.code === 0) {
                that.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    that.getList();
                  }
                })
              } else {
                that.getCaptcha();
                that.$message.error(data.msg)
              }
            });
          } else {
            that.getCaptcha();
            return false;
          }
        });
      },
      getList(){
        API.lpleaveword.list(this.formData).then(({data})=>{
          this.replyCont=data.data;
        });

      },
      handleSizeChange (val) {
        this.formData.limit=val;
        this.getList();
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange (val) {
        this.formData.page=val;
        this.getList();
        console.log(`当前页: ${val}`);
      }
    },
    components: {
      ListLeft,
      Nav,
      footerNav
    }
  }
</script>

<style scoped>
  .content {
    width: 95%;
    margin: 0 auto;
    margin-top: 30px;
    display: flex;
    justify-content: space-between;
    /*align-items: center;*/
  }
  .contLeft {
    width: 22%;
    position: absolute;
    top: 530px;
  }


  .contRig {
    width: 72%;
    position: absolute;
    top: 530px;
    left: 26%;
    height: 1110px;
    overflow: scroll;
  }

  .contMbx {
    width: 100%;
    border-bottom: 2px solid #e4e4e4;
    padding: 8px 0;
  }

  .contMbx a {
    font-size: 16px;
  }

  .onlineCont {
    display: table;
    width: 100%;
    padding: 20px 0;
  }

  .onlineLeaving {
    border-bottom: 4px solid #ccc;
  }

  .onlineMsg {
    margin: 30px 0;
  }

  .onlineLeaving .el-form {
    width: 60%;
  }

  .msgCont {
    border: 1px solid #e4e4e4;
    margin-top: 30px;
  }

  .msgCont ul {
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
    padding: 10px;
  }

  .msgCont li {
    list-style: none;
    width: 50%;
    margin-top: 10px;
  }

  .msgCont p {
    line-height: 27px;
    padding: 10px;
  }

  .reply {
    background: rgb(242, 242, 242);
    padding: 10px;
    border-top: 1px solid #e4e4e4;
    border-bottom: 1px solid #e4e4e4;
  }

  .imgblock {
    text-align: center;
    padding-top: 20px;
    padding-bottom: 20px;
    border-top: 1px solid #ccc;
    margin-top: 80px;
  }
</style>
