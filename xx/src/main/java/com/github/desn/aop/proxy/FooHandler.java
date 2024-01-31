package com.github.desn.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FooHandler implements InvocationHandler {

    //要代理的原始对象
    private Object targetObject;
    public FooHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    void doBefore() {
        System.out.println("before");
    }
    void doAfter() {
        System.out.println("after");
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invoke = method.invoke(targetObject, args);
        doAfter();
        return invoke;
    }


}
