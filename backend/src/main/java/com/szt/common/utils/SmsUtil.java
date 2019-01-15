package com.szt.common.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SmsUtil {

	private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);
	
	public static final String CODE_VAIL="vailCode";
	public static final String CODE_TIME="code_long_time";
//	private long sendTime = 0l;//记录发送验证码时间
	
	// 模板发送接口的http地址
//	@Value("${sms.uri.tpl}")
	private String URI_TPL_SEND_SMS = "https://sms.yunpian.com/v2/sms/tpl_batch_send.json";

    //编码格式。发送编码格式统一用UTF-8
//	@Value("${sms.encoding}")
    private String ENCODING = "UTF-8";
    
    //修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后获取
//	@Value("${sms.apikey}")
    private String apikey = "7b46a1343d2dbcd8ca8902bd9f8d3e91";
	
//	@Value("${param.value}")
//    private String var_testid;//"#testId#";服务名称 设备名称
	
//	@Value("${param.value.code}")
	private String var_code = "#code#";//"#code#";验证码

//	@Value("${sms.temp.pwd}")
    private String sms_temp_pwd = "1859632";//模板id(发验证码)
	
//	@Value("${param.value.delay}")
//	private String var_delay;//"#delay#";延缓期  保养项目名称
    
//    @Value("${sms.temp.param}")
//    private String sms_temp_param;//模板id(发验证码)  交费提醒
    
//    @Value("${sms.temp.param.py}")
//    private String sms_temp_param_py;//模板id(发验证码)  停机提醒
    
//    @Value("${sms.temp.param.byxm}")
//    private String sms_temp_param_byxm;//模板id(发验证码)  设备保养提醒
	/**
	 * 通过模板发送短信(不推荐)
	 *
	 * @param apikey
	 *            apikey
	 * @param tpl_id
	 *            模板id
	 * @param tpl_value
	 *            模板变量值
	 * @param mobile
	 *            接受的手机号
	 * @return json格式字符串
	 * @throws IOException
	 */

    
//    public String sendSms(String mobile, String testId) throws IOException {
//    	return tplSendSms (mobile, testId);
//    }
    
	/**
	 * 停机短信提醒
	 * @param mobile 手机号码
	 * @param code 验证码
	 * @return
	 * @throws IOException
	 */
    public  String sendSms(String mobile,String code) throws IOException {
		String tpl_value = URLEncoder.encode(var_code, ENCODING) + "=" + URLEncoder.encode(code, ENCODING);
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("tpl_id", sms_temp_pwd);
		params.put("tpl_value", tpl_value);
		params.put("mobile", mobile);
		String res = post(URI_TPL_SEND_SMS, params);
		return smsResult(res);
	}
    
    /**
     * 余额不足  交费提醒
     * @param mobile
     * @param name  姓名
     * @param testId  服务名称
     * @param delay 延缓期 天
     * @return
     * @throws IOException
     */
    /*public String sendSms(String mobile,String name,String testId,String delay) throws IOException {
    	String tpl_value = URLEncoder.encode(var_testid, ENCODING) + "=" + URLEncoder.encode(testId, ENCODING);
			tpl_value +="&"+URLEncoder.encode(var_name, ENCODING) + "=" + URLEncoder.encode(name, ENCODING);
			tpl_value +="&"+URLEncoder.encode(var_delay, ENCODING) + "=" + URLEncoder.encode(delay, ENCODING);
    	
    	Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("tpl_id", sms_temp_param);
		params.put("tpl_value", tpl_value);
		params.put("mobile", mobile);
		String res = post(URI_TPL_SEND_SMS, params);
		return smsResult(res);
    }*/
    /**
     * 设备保养提醒
     * @param mobile
     * @param name 设备负责人名称
     * @param testId 设备名称
     * @param delay  保养项目名称
     * @return
     * @throws IOException
     */
    /*public String sendSmsBytx(String mobile,String name,String testId,String delay) throws IOException {
    	String tpl_value = URLEncoder.encode(var_testid, ENCODING) + "=" + URLEncoder.encode(testId, ENCODING);
    	tpl_value +="&"+URLEncoder.encode(var_name, ENCODING) + "=" + URLEncoder.encode(name, ENCODING);
    	tpl_value +="&"+URLEncoder.encode(var_delay, ENCODING) + "=" + URLEncoder.encode(delay, ENCODING);
    	
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("apikey", apikey);
    	params.put("tpl_id", sms_temp_param_byxm);
    	params.put("tpl_value", tpl_value);
    	params.put("mobile", mobile);
    	String res = post(URI_TPL_SEND_SMS, params);
    	return smsResult(res);
    }*/
   
    
	/**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    private String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
        	logger.error("发送短信失败，url"+url+",参数："+paramsMap,e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                logger.error("关闭云片网http连接失败", e);
            }
        }
        return responseText;
    }
    
	private static String smsResult(String r){
		JSONObject json = new JSONObject();
		try {
			JSONObject result_json = JSONObject.fromObject(r);
			JSONObject data = ((JSONArray)result_json.get("data")).getJSONObject(0);
			String result_state = data.get("code").toString();
			String msg = data.get("msg").toString();
			
			json.put("status", result_state);//为0时 成功
			json.put("msg", msg);
			if("0".equals(result_state)){
				return result_state;
			}else{
				return msg;
			}
		} catch (Exception e) {
			logger.error("短信发送失败："+r,e);
		}
		
		return "短信发送失败";
	}
	
	
	
	/**
	 * 发送验证码或已发送则不重复发送
	 * @param request
	 * @param telephone
	 * @return
	 * @throws Exception
	 */
	public String sendCode(HttpServletRequest request, String telephone) throws Exception{
		long times = System.currentTimeMillis();
		Object sendTime = request.getSession().getAttribute(CODE_TIME);
		if(sendTime != null && times-Long.parseLong(sendTime+"")<1*60*1000){//每分钟只能发一次
			throw new Exception("验证码一分钟只能发送一次!");
		}
		DecimalFormat decimalFormat = new DecimalFormat("0000");
		String code = decimalFormat.format(Math.random() * 1000);
		sendSms(telephone,code);
		request.getSession().setAttribute(CODE_VAIL, code);
		request.getSession().setAttribute(CODE_TIME, System.currentTimeMillis());
		return code;
	}
	
	/**
	 * 验证验证码是否正确
	 * @param request
	 * @param code
	 * @return
	 * @throws Exception
	 * 默认验证码三分钟过期
	 */
	public boolean checkCode(HttpServletRequest request, String code){
		return checkCode(request,code,3);
	}

	/**
	 * 验证验证码是否正确
	 * @param request
	 * @param code  验证码
	 * @param overTime 过期时间  分钟
	 * @return
	 * @throws Exception
	 */
	public boolean checkCode(HttpServletRequest request, String code,long overTime){
		long times = System.currentTimeMillis();
		Object sendTime = request.getSession().getAttribute(CODE_TIME);
		if(sendTime==null || times-Long.parseLong(sendTime+"")>overTime*60*1000){//大于三分钟
//			throw new RuntimeException("验证码已过期!");
			return false;
		}
		String newcode = (String)request.getSession().getAttribute(CODE_VAIL);
		if(code.equals(newcode)){
			return true;
		}
		return false;
	}

}
