package com.tacademy.ecommerce.aspect;

import javax.servlet.ServletContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.tacademy.ecommerce.security.SecurityUtils;

import lombok.extern.apachecommons.CommonsLog;

@Component
@Aspect
@CommonsLog
public class EcommerceAspect {
	
	@Autowired
    private ServletContext servletContext;
	
	@Pointcut("within(@org.springframework.stereotype.Controller *) ||"
			+ "within(@org.springframework.web.bind.annotation.RestController *)")
	public void controllerBean() { }
	
	@Pointcut("execution(* com.tacademy.ecommerce..*.*(..))")
	public void userBean() { }
	
	@Around("controllerBean() && userBean()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		String userName = null;
		
		if(SecurityUtils.getCurrentUser() != null) {
			userName = SecurityUtils.getCurrentUser().getUsername();
		}
		
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = pjp.proceed();
		
		stopWatch.stop();
		
		log.info(String.format("[사용자명:%s][%s메소드 수행시간:%s]", userName, methodName, stopWatch.getTotalTimeSeconds()));
		
		return result;

	}
}
