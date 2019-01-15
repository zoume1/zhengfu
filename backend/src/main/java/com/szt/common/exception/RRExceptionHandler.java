package com.szt.common.exception;

import com.mysql.jdbc.MysqlDataTruncation;
import com.szt.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
@Slf4j
public class RRExceptionHandler {

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public R handleRRException(RRException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());
		e.printStackTrace();
		return r;
	}
	/**
	 * 处理sql异常
	 */
	@ExceptionHandler(SqlException.class)
	public R sqlException(SqlException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());
		e.printStackTrace();
		return r;
	}
	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e){
		log.error(e.getMessage(), e);

		return R.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public R handleAuthorizationException(AuthorizationException e){
		log.error(e.getMessage(), e);
		return R.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		log.error(e.getMessage(), e);
		return R.error();
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public R handleException(DataIntegrityViolationException e){
		log.error(e.getMessage(), e);
		return R.error("您填写的数据过长无法储存!");
	}

}
