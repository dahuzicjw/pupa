package com.github.desn.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("before");
        arg3.invokeSuper(arg0, arg2);
        System.out.println("after");
        return null;
    }

}
