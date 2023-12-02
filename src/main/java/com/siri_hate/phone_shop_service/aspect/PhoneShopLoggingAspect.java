package com.siri_hate.phone_shop_service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Aspect-oriented programming (AOP) component for logging method invocations in the Phone Shop service application.
 * This aspect provides logging for DAO, service, and controller methods.
 */
@Component
@Aspect
public class PhoneShopLoggingAspect {

    private static final Logger logger = LogManager.getLogger(PhoneShopLoggingAspect.class);

    /**
     * Pointcut definition for DAO methods.
     */
    @Pointcut("execution(* com.siri_hate.phone_shop_service.dao..*(..))")
    private void daoMethods() {}

    /**
     * Pointcut definition for service methods.
     */
    @Pointcut("execution(* com.siri_hate.phone_shop_service.service..*(..))")
    private void serviceMethods() {}

    /**
     * Pointcut definition for controller methods.
     */
    @Pointcut("execution(* com.siri_hate.phone_shop_service.controller..*(..))")
    private void controllerMethods() {}

    /**
     * Advice around DAO methods for logging.
     *
     * @param proceedingJoinPoint ProceedingJoinPoint for the intercepted method.
     * @return The result of the intercepted method.
     * @throws Throwable If an error occurs during method execution.
     */
    @Around("daoMethods()")
    public Object aroundAllDAOMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("DAO method: {} - was called", methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger.info("DAO method: {} - has completed", methodName);
        return targetMethodResult;
    }

    /**
     * Advice around service methods for logging.
     *
     * @param proceedingJoinPoint ProceedingJoinPoint for the intercepted method.
     * @return The result of the intercepted method.
     * @throws Throwable If an error occurs during method execution.
     */
    @Around("serviceMethods()")
    public Object aroundAllServiceMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Service method: {} - was called", methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger.info("Service method: {} - has completed", methodName);
        return targetMethodResult;
    }

    /**
     * Advice around controller methods for logging.
     *
     * @param proceedingJoinPoint ProceedingJoinPoint for the intercepted method.
     * @return The result of the intercepted method.
     * @throws Throwable If an error occurs during method execution.
     */
    @Around("controllerMethods()")
    public Object aroundAllControllerMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Controller method: {} - was called", methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger.info("Controller method: {} - has completed", methodName);
        return targetMethodResult;
    }

}