package com.bob.config.root.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 事务切面
 *
 * @author wb-jjb318191
 * @create 2017-12-27 13:53
 */
@Aspect
@Component
public class TransactionAspectJAdvisor {

    @Autowired
    private TransactionAspectInvoker transactionAspectInvoker;

    @Around("com.bob.config.mvc.userenv.aspect.AopArchitecture.serviceMethod()")
    public Object invokeWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        return transactionAspectInvoker.invoke(joinPoint);
    }

}
