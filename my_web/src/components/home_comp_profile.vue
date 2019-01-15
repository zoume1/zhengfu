<template>
  <div class="container">
    <div class="home_comp_profile">
      <div class="prof_left">
        <img src="http://website.3zhit.cn/jtgw_ic_background1.png" alt="">
      </div>
      <div class="prof_rig">
        <div class="prof_tit">
          <h3>COMPANY<br>PROFILE</h3>
          <h4>公司简介</h4>
        </div>
        <p>{{ comp_prof1 }}</p>
        <p>{{ comp_prof2 }}</p>
        <p>{{ comp_prof3 }}</p>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'home_comp_profile',
    data() {
      return {
        comp_prof1: '三智头智能科技集团是一家全球领先的人工智能领域综合型集团企业，致力于为全球各产业提供智能升级、产业整合，商业布局、软件研究，大数据服务等一体化解决方案， 集团总部位于广东省佛山市，在深圳设有软硬件研发中心，与美国、德国、日本等多个科技发达国家人工智能领域科学研究院达成了战略合作伙伴关系，依托于强大的技术背景以及政府的扶持， 三智头智能科技集团，自成立之日起在科技前沿领域迅猛发展，企业分别获得了中力资本、博将资本，东方富海等创投机构的青睐，三智头智能科技集团 致力于为各行业细分领域进行赋能、创新和转型， 为进一步推动中国工业4.0的发展而努力。',
        comp_prof2: '集团拥有一支锐意进取，励精图治的核心领导团队，拥有高度的社会责任感和历史使命感， 团队聚集了一批来自各个细分领域的顶级人才，具有丰富的行业经验，自创始以来，三智头智能科技集团的理念和方向得到了社会各界的广泛的认可和支持。',
        comp_prof3: '集团旗下分别成立了三智头智能科技、工业壹号科技、三智头商业智库、三智头软件研究中心、三智头大数据产业创投基金佛山软服众创科技等前沿科技企业。',
      }
    }
  }
</script>

<style scoped>

  .home_comp_profile {
    /*position: relative;
    border-radius: 30px;
    top: -105px;*/
    background: #fff;
    width: 100%;
    padding: 100px 10px;
    padding-bottom: 0;
    margin-bottom: 80px;
    display: table;
  }

  .home .prof_left img {
    width: 100%;
  }

  .home .prof_rig {
    float: left;
    width: 55%;
  }

  .prof_tit {
    border-left: 4px solid #c12828;
    padding-left: 8px;
    margin-bottom: 54px;
  }

  .prof_left {
    float: left;
    margin-right: 20px;
    height: 590px;
    width: 453px;
  }

  .prof_left img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .prof_rig {
    float: left;
    width: 508px;
  }

  .prof_tit h3 {
    font-size: 20px !important;
    color: #333333;
    margin: 0;
    font-weight: bold;
  }

  .prof_tit h4 {
    font-size: 24px !important;
    color: #333;
    margin: 0;
  }

  .prof_rig p {
    font-size: 18px;
    color: #8d8d8d;
    text-indent: 2em;
    line-height: 27px;
  }

  .prof_rig p:nth-last-child(1) {
    margin-bottom: 0;
  }
</style>
