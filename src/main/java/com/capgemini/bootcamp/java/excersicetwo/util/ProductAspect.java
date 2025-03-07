package com.capgemini.bootcamp.java.excersicetwo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Aspect
@Component
public class ProductAspect {

    LogManager logManager;

    @Autowired
    public ProductAspect(LogManager logManager){
        this.logManager = logManager;
    }

    @Pointcut("execution(* com.capgemini.bootcamp.java.excersicetwo.controller.*.get*(..))")
    public void getControllerFunction(){}

    @Pointcut("execution(* com.capgemini.bootcamp.java.excersicetwo.controller.*.create(..))")
    public void createControllerFunctions() {}

    @Pointcut("execution(* com.capgemini.bootcamp.java.excersicetwo.service.*.get*(..))")
    public void getServiceFunction(){}

    @Pointcut("execution(* com.capgemini.bootcamp.java.excersicetwo.service.*.create(..))")
    public void createServiceFunctions() {}

    @Pointcut("getControllerFunction() || getServiceFunction()")
    public void getFunctions() {}

    @Pointcut("createControllerFunctions() || createServiceFunctions()")
    public void createFunctions() {}

    @Before("getFunctions()")
    public void beforeGet(JoinPoint joinPoint){
        logManager.createLog(Level.INFO, "Execution -> " + joinPoint.getSignature());
    }

    @Before("createFunctions()")
    public void beforeCreate(JoinPoint joinPoint){
        logManager.createLog(Level.INFO, "Execution -> " + joinPoint.getSignature());
    }
}