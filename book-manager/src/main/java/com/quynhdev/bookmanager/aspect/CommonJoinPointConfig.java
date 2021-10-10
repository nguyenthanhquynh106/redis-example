package com.quynhdev.bookmanager.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.quynhdev.bookmanager.controller.*.*(..))")
    public void controllerLayerExecution() {
    }
}

