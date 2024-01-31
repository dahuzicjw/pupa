package com.github.db.memcache;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemCacheClient {

    
    public static void main(String[] args) {
//        readAndWrite();
        test();
    }
    
    public static void test() {
        MemCachedClient memCachedClient = new MemCachedClient();
        Object object = memCachedClient.get("999");
        System.out.println(object);
        memCachedClient.set("999", "test");
        object = memCachedClient.get("999");
        System.out.println(object);
    }
    
    public static void readAndWrite() {
       
        /**
         * 建立MemcachedClient实例
         * */
        MemCachedClient memCachedClient = new MemCachedClient();
        for (int i = 0; i < 1000; i++) {
            /**
             * 将对象加入到memcached缓存
             * */
            boolean success = memCachedClient.set("" + i, "Hello!");
            /**
             * 从memcached缓存中按key值取对象
             * */
            String result = (String) memCachedClient.get("" + i);
            System.out.println(String.format("set( %d ): %s", i, success));
            System.out.println(String.format("get( %d ): %s", i, result));
        }
    }
    

    /**
     * 初始化SockIOPool，管理memcached的连接池
     * */
    static SockIOPool pool;
    static {
        init();
    }
    private static void init() {
        String[] servers = {"172.16.86.135:11111"};
        pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
    }
}
