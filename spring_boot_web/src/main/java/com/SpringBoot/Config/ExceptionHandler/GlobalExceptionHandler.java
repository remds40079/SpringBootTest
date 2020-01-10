package com.SpringBoot.Config.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseData defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error("some error in the ",e);
		ResponseData responseData = new ResponseData();
		responseData.setMessage(e.getMessage());
		if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			responseData.setCode(404);
		}else {
			responseData.setCode(500);
		}
		responseData.setData(null);
		responseData.setStatus(false);
		return responseData;
		
	}
}
