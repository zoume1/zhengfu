// 配置编译环境和线上环境之间的切换

let baseUrl = '';
let iconfontVersion = ['567566_qo5lxgtishg'];
let iconfontUrl = `//at.alicdn.com/t/font_$key.css`;
let codeUrl = `${baseUrl}/lppc`
const env = process.env
if (env.NODE_ENV == 'development') {
    baseUrl = `http://localhost:8082/lp/`; // 开发环境地址
} else if (env.NODE_ENV == 'production') {
    baseUrl = `http://lp.siring.cn/lp/`; //生产环境地址
} else if (env.NODE_ENV == 'test') {
    baseUrl = ``; //测试环境地址
}
console.log(baseUrl);
export {
    baseUrl,
    iconfontUrl,
    iconfontVersion,
    codeUrl,
    env
}
