package com.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AspectBuilder{

	@Before("execution(* com.state.States.WaitingState.answerCall())")
	public void AspectBefore(JoinPoint jp){
		System.out.println("LOGGER: " + jp.getSignature());
	}
}