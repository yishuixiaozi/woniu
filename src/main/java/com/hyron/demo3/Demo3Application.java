package com.hyron.demo3;

import com.hyron.demo3.config.ApplicationStartup;
import com.hyron.demo3.controller.UserController2;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan({"com.hyron.demo3.dao"})
public class Demo3Application {

    public static void main(String[] args) {
        //SpringApplication.run(Demo3Application.class, args);
        //System.out.println("this is a test ");

        //创建SpringApplication类的对象
        SpringApplication springApplication = new SpringApplication(Demo3Application.class);
        //位该类添加监视器（判断什么时候运行完成）
        //springApplication.addListeners(new ApplicationStartup());
        //启动Application
        springApplication.run(args);


    }


}
