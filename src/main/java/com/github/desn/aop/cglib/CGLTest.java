package com.github.desn.aop.cglib;

public class CGLTest {

    public static void main(String[] args) {
        CGLFoo cglFoo = new CGLFoo();
        CGLProxy proxy = new CGLProxy();
        CGLFoo cglProxy = (CGLFoo) proxy.createProxy(cglFoo.getClass());
        cglProxy.hello();
    }
}
