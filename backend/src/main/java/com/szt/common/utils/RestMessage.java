package com.szt.common.utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/***
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 */
@ApiModel(description = "返回接口类")
public class RestMessage<T> implements Serializable{

	@ApiModelProperty(value = "状态码",notes = "状态码")
	private Integer code;
	@ApiModelProperty(value = "描述",notes = "描述")
	private String msg;
	@ApiModelProperty(value = "返回对象",notes = "返回对象")
	private T data;

	public RestMessage() {
		code=0;
		msg="ok";
	}
	public static RestMessage error() {
		return error(1, "未知异常，请联系管理员");
	}

	public static RestMessage error(String msg) {
		return error(1, msg);
	}

	public static RestMessage error(int code, String msg) {
		RestMessage r = new RestMessage();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	public static RestMessage ok() {
		return new RestMessage();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public RestMessage<T> put(T value) {
		this.setData(value);
		return this;
	}
}
