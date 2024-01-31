package com.github.desn.aop.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Foo fooImpl = new FooImpl();
        FooHandler handler = new FooHandler(fooImpl);
        
        Foo proxy = (Foo)Proxy.newProxyInstance(
                fooImpl.getClass().getClassLoader(), 
                fooImpl.getClass().getInterfaces(),
                handler);
        proxy.hello();
    }
}
