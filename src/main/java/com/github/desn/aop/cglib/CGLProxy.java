package com.github.desn.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CGLProxy {

    public Object createProxy(Class<?> targetClz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClz);
        enhancer.setCallback(new CGLInterceptor());
        return enhancer.create();
    }
}
