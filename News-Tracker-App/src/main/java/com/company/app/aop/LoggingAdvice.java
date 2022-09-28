package com.company.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class LoggingAdvice {

	private Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	/*
	 * @Before(value = "execution(* com.company.app.controller.*.*(..) )") public
	 * void logBefore(JoinPoint jp) { log.info("Executing : " + jp.toString()); }
	 * 
	 * @After(value = "execution(* com.company.app.controller.*.*(..) )") public
	 * void logAfter(JoinPoint jp) { log.info("Completed : " + jp.toString()); }
	 */

	@Pointcut(value = "execution(* com.company.app.controller.*.*(..) )")
	public void myPointCut() {

	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("Request: [" + className + "] : [Method Invoked : " + methodName + "()] : " + "args "+ mapper.writeValueAsString(array));
		Object obj = pjp.proceed();
		log.info("Response: ["+className + "] : [" + methodName + "()] : " + "response : " + mapper.writeValueAsString(array));
		return obj;
	}

}
