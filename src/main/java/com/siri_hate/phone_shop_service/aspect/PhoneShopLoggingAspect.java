package com.siri_hate.phone_shop_service.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Aspect-oriented programming (AOP) component for logging method invocations in the Phone Shop service application.
 * This aspect provides logging for DAO, service, and controller methods.
 */
@Component
@Aspect
@Log4j2
public class PhoneShopLoggingAspect {

    /**
     * Pointcut definition for DAO methods.
     */
    @Pointcut("execution(* com.siri_hate.phone_shop_service.repository..*(..))")
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
        log.info("DAO method: {} - was called", methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        log.info("DAO method: {} - has completed", methodName);
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
        log.info("Service method: {} - was called", methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        log.info("Service method: {} - has completed", methodName);
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
        log.info("Controller method: {} - was called", methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        log.info("Controller method: {} - has completed", methodName);
        return targetMethodResult;
    }

}