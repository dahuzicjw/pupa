package com.inbyte.main;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kevin on 2016/5/29.
 *
 * @author chenjw
 */
@RestController
@RequestMapping("/sse")
@SpringBootApplication
public class SseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SseApplication.class);
    }

    /**
     * 网上的方法 但存在一个问题 运行在tomcat中，tomcat会帮助直接给关掉，而sse有自动重连，所以每次都会重新发起请求。
     *
     * @return
     */
    @GetMapping(value = "get", produces = "text/event-stream;charset=UTF-8")
    public String getData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:测试:" + Math.random() + "\n\n";
    }

    @GetMapping(value = "test")
    public void test(HttpServletResponse response) {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");

        try {
            PrintWriter pw = response.getWriter();
            for (int i = 0; i < 5; i++) {
                if (pw.checkError()) {
                    System.out.println("客户端断开连接");
                    break;
                }
                Thread.sleep(1000);
                pw.write("data:测试:" + Math.random() + "\n\n");
                pw.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
