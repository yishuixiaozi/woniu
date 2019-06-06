package com.hyron.demo3.config;


import org.springframework.stereotype.Component;

@Component
public class StepExcute implements Runnable {
    @Override
    public void run() {
        startStreamTask();
    }

    /**
     * 项目启动后打开1个页面
     */
    public void startStreamTask() {
        //windows 控制台 cmd /c start http://localhost:8080/login.html
        //macOS 控制台  open 'http://localhost:8080/login.html
        //应该将这个东西放在一个配置文件里边，而不是直接写在程序里边
        //String url = "open "+"'http://localhost:63342/demo3/public/login.html'";

        //System.out.println("url的测试"+url);
        try {
            Runtime.getRuntime().exec("open "+"'http://localhost:8080/user/loginpage'");
//
//            if(java.awt.Desktop.isDesktopSupported()){
//                try{
//
//                    java.net.URI uri=java.net.URI.create("http://www.baidu.com");
//
//                    java.awt.Desktop dp=java.awt.Desktop.getDesktop();
//
//                    if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
//                        dp.browse(uri);
//                    }
//                }catch(java.lang.NullPointerException e){
//
//                }catch(java.io.IOException e){
//
//                }
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
