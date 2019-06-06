package com.hyron.demo3.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

//监听器，用于监视其他类的执行情况
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //获取总的配置ApplicationContext对象
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        //从ApplicationContext 中获取applicationContext对象，然后获取线程类StepExcute对象
        StepExcute stepExcute = applicationContext.getBean(StepExcute.class);

        Thread thread = new Thread(stepExcute);

        thread.start();
    }
}
