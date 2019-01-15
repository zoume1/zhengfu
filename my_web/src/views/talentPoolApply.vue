 <template>
  <div>
    <Nav></Nav>
    <div class="content">
      <div class="contLeft">
        <list-left></list-left>
      </div>
      <div class="contRig">
        <div class="contMbx">
          <a>商会风采</a> > <a>人才库 </a> > <a>人才库申请</a>
        </div>
        <div style="border: 1px solid #e4e4e4;margin-top:10px;">
          <div class="taleCont">
            <div class="taleMsg">
              <el-form ref="dataForm" :model="dataForm" :rules="dataFormRu" label-width="80px">
                <el-row>
                  <el-col :span="24">
                     <div style="display: flex;  justify-content: center; align-items: center;  padding: 30px;">
                       <span style="margin-right: 20px;">上传本人照片</span>
                       <upload   pageComment="上传本人照片" v-model="dataForm.pic" :isMultiple="false"  :isPage="false" ></upload>
                     </div>
                  </el-col>

                  <el-col :span="12">
                    <el-form-item label="行业"  prop="text">
                      <el-select v-model="dataForm.text" placeholder="请选择">
                        <el-option :label="item.confName" :value="item.confVue" v-for="(item,index) in sysConfig['lp_talent_text'].list":key="index" > </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="姓名"  prop="name">
                      <el-input v-model="dataForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="兴趣爱好"  prop="interest">
                      <el-input v-model="dataForm.interest"></el-input>
                    </el-form-item>
                    <el-form-item label="联络方式"  prop="contactWay">
                      <el-input v-model="dataForm.contactWay"></el-input>
                    </el-form-item>

                  </el-col>
                  <el-col :span="12">

                    <el-form-item label="年龄"  prop="age">

                    <el-input-number  clearable v-model="dataForm.age"  :min="0"  > </el-input-number>
                    </el-form-item>
                    <el-form-item label="性别"  prop="sex">
                      <el-select v-model="dataForm.sex" placeholder="请选择">
                        <el-option :label="item.confName" :value="item.confVue" v-for="(item,index) in sysConfig['lp_talent_sex'].list" :key="index"> </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="出生日期"  prop="birthdate">
                      <el-date-picker v-model="dataForm.birthdate" clearable   type="date" style="width:100%;" value-format="yyyy-MM-dd"  format="yyyy-MM-dd" >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="专长"  prop="speciality">
                      <el-input v-model="dataForm.speciality"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="24">
                    <el-form-item label="自我介绍" prop="introduce">
                      <el-input type="textarea" v-model="dataForm.introduce" :rows="4"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
              <div class="talePs">
                <span>注：</span>
                <p>1、请认真填写，提交后不可修改。</p>
                <p>2、人才信息将在审核通过显示在人才库。</p>

                <button @click="save()">提交</button>
              </div>
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
  import upload from '@/components/input/upload.vue'

  export default {
    name: 'talentPoolApply',
    data () {
      return {
        dataForm: {

        },
        dataFormRu:{
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          text: [
            { required: true, message: '行业不能为空', trigger: 'blur' }
          ],
          birthdate: [
            { required: true, message: '出生日期不能为空', trigger: 'blur' }
          ],

          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          pic: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          speciality: [
            { required: true, message: '专长不能为空', trigger: 'blur' }
          ],
          introduce: [
            { required: true, message: '自我介绍不能为空', trigger: 'blur' }
          ],
          contactWay: [
            { required: true, message: '联系方式不能为空', trigger: 'blur' }
          ],
          interest: [
            { required: true, message: '兴趣爱好不能为空', trigger: 'blur' }
          ],
        }
      }
    },
    mounted(){

    },
    methods:{
        save(){
          var that = this;
          that.$refs['dataForm'].validate((valid) => {
              if (valid) {
                API.lptalent.add(this.dataForm).then(({data}) => {
                  if (data && data.code === 0) {
                    that.$message({
                      message: '操作成功',
                      type: 'success',
                      duration: 1500,
                      onClose: () => {
                        that.$router.go(-1);
                      }
                    })
                  } else {
                    that.$message.error(data.msg)
                  }
                })
              }});
      }
    },

    components: {
      ListLeft,
      Nav,
      footerNav,
      upload
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

  .taleCont {
    display: table;
    width: 100%;
    text-align: center;
  }

  .talePic {
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 20px 0;
  }

  .el-col {
    border-radius: 4px;
  }

  .bg-purple-dark {
    background: #99a9bf;
  }

  .bg-purple {
    background: #d3dce6;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

  .taleMsg {
    padding: 0 20px;
    display: table;
    width: 100%;
    box-sizing: border-box;
  }

  .el-select {
    width: 100%;
  }

  .talePs{
    display: table;
    text-align: left;
    margin:0 auto;
    padding-bottom: 50px;
  }

  .talePs span{
    font-size:13px;
  }

  .talePs p{
    font-size:13px;
    margin:0;
  }

  .talePs button{
    width: 100px;
    height: 35px;
    text-align: center;
    font-size:14px;
    background: transparent;
    border-radius:4px;
    border:1px solid #e4e4e4;
    margin-top: 30px;
  }
</style>
