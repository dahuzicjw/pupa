package com.cjw;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring应用启动类
 *
 * @author chenjw
 * @date: 2022年11月13日
 */
@MapperScan("com.cjw.mapper")
@SpringBootApplication
public class SpringApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ConfigurableApplicationContext run = org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        log.info("启动成功, 耗时:{}s", (System.currentTimeMillis() - startTime) / 1000);
    }

}
