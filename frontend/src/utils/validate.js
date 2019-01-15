import Vue from 'vue'
/**
 * 邮箱
 * @param {*} s
 */
export function isEmail (s) {
  return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
}

/**
 * 手机号码
 * @param {*} s
 */
export function isMobile (s) {
  return /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/.test(s)
}

/**
 * 电话号码
 * @param {*} s
 */
export function isPhone (s) {
  return /^([0-9]{3,4}-)?[0-9]{7,8}$/.test(s)
}

/**
 * 身份证
 * @param s
 * @returns {boolean}
 */
export function isIdentityCard(s){
  return /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}$)/.test(s);
}

/**
 * 整数
 * @param s
 * @returns {boolean}
 */
export function isInteger(s){
  return /^\d+$/.test(s);
}

/**
 * 小数
 * @param s
 * @returns {boolean}
 */
export function isDecimals(s){
  return /^[0-9]+([.]{1}[0-9]+){0,1}$/.test(s);
}
/**
 * 判断非空
 * @param s
 * @returns {boolean}
 */
export function isNull(s){
  return /\S/.test(s);
}

/**
 * 正则绑定
 * @param s
 * @returns {boolean}
 */
export function regularBinding(dataRule={},columns=[],dataForm={},getData){
  for (var i in  columns) {
    var cou = columns[i];
    if (cou.isSet == '0') {
      if(dataRule[cou.fieldName]==undefined || dataRule[cou.fieldName]==null){
        if(cou.inputType === '14'){
          dataRule[cou.fieldName + 'password'] = [{
            fieldName: cou.fieldName,dataForm:dataForm, validator: function (rule, value, callback) {
              console.log(getData());
              var data= getData()[rule.fieldName];
              if(value==undefined){
                value="";
              }
              if(data==undefined){
                data=''
              }
              if (!getData().id && !/\S/.test(value)) {
                callback(new Error('确认密码不能为空'))
              } else if (data !== value ) {
                callback(new Error('确认密码与密码输入不一致'))
              } else {
                callback()
              }
            }
            , trigger: 'blur'
          }];
        }

        dataRule[cou.fieldName] = [
          { //required: cou.checkout == null ? false : JSON.parse(cou.checkout).indexOf("1") != -1,
            fieldName: cou.fieldName,msg:cou.pageComment, checkout: cou.checkout, validator: function (rule, value, callback) {
              if (rule.checkout != null) {
                var che = JSON.parse(rule.checkout);
                var boo = true;
                for (var i in che) {
                  var item = che[i];
                  //0-手机号,1-非空,2-身份证,3-邮箱,4-数字,5-小数
                  if (item === "0" && !isMobile(value)) {
                    //Vue.prototype.$message.error(rule.msg+'手机号格式错误');
                    callback(new Error(rule.msg+'手机号格式错误'))
                  } else if (item === "1" && !isNull(value)) {
                    //Vue.prototype.$message.error(rule.msg+'不能为空');
                    callback(new Error( rule.msg+'不能为空'))
                    boo = false;
                  } else if (item === "2" && !isIdentityCard(value)) {
                    //  Vue.prototype.$message.error(rule.msg+'身份证格式错误');
                    callback(new Error(rule.msg+'身份证格式错误'))
                    boo = false;
                  } else if (item === "3" && !isEmail(value)) {
                    // Vue.prototype.$message.error(rule.msg+'邮箱格式错误');
                    callback(new Error(rule.msg+'邮箱格式错误'))
                    boo = false;
                  } else if (item === "4" && !isInteger(value)) {
                    // Vue.prototype.$message.error(rule.msg+'数字格式错误');
                    callback(new Error(rule.msg+'数字格式错误'))
                    boo = false;
                  } else if (item === "5" && !isDecimals(value)) {
                    //  Vue.prototype.$message.error(rule.msg+'小数格式错误');
                    callback(new Error(rule.msg+'小数格式错误'))
                    boo = false;
                  }
                }
                if (boo) {
                  callback()
                }
              } else {
                callback()
              }
            }
            , trigger: 'blur'
          }
        ]
      }
      if(dataForm[cou.fieldName]==undefined || dataForm[cou.fieldName]==null){
        if (cou.inputType === '9' || cou.inputType === '5' || cou.inputType === '11' || cou.inputType === '12'|| cou.inputType === '13' || cou.inputType === '15'|| cou.inputType === '19') {
          if (cou.dataDefault != '' && cou.dataDefault != undefined) {
            dataForm[cou.fieldName] = JSON.parse(cou.dataDefault);
          } else {
            dataForm[cou.fieldName] = [];
          }
        }else {
          if (cou.dataDefault !='' && cou.dataDefault!=undefined && dataForm.id==0) {
            dataForm[cou.fieldName] = cou.dataDefault;
          } else {
            dataForm[cou.fieldName] = '';
          }
        }
      }
    }
  }
}



