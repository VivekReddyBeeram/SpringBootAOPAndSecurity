package com.vivek.SpringBootAOPAndSecurity;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Aspect
@Component
public class AOPDemo {
	
	private static final Logger Logger = LoggerFactory.getLogger(AOPDemo.class);
	
	{Logger.info("AOPDemo class created");}
	
	//This method is executed before the called method starts execution
	@Before("execution(public * com.vivek.SpringBootAOPAndSecurity.HomeController.home())")
	public void logBefore() {
		System.out.println("called AOP");
		Logger.info("home() Method is called");
		}
	
	//This method runs even though getAnimals() stopped because of an error
	@After("execution(public * com.vivek.SpringBootAOPAndSecurity.HomeController.getAnimals(..))")////(..) should be used when there are parameters for that method
	public void logAfter() {
		Logger.info("getAnimals() is executed");
	}
	
	//logs will be generated only if the method is successfully executed
	@AfterReturning("execution(public * com.vivek.SpringBootAOPAndSecurity.HomeController.getAnimals())")
	public void logAfterReturning() {
		Logger.info("getAnimals() completed successfully");
	}
	
	@AfterThrowing("execution(public * com.vivek.SpringBootAOPAndSecurity.HomeController.getAnimals())")
	public void logAfterThrowing() {
		Logger.info("getAnimals() stopped because of some error;");
	}
	
}

