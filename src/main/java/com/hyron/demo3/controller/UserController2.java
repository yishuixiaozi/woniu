package com.hyron.demo3.controller;
import com.hyron.demo3.entity.User;
import com.hyron.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/user"})
public class UserController2 {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/hello"})
    public String hello(){

        System.out.println("this is test");
        return "hello";
    }

    //从浏览器跳转到登陆界面进行登陆 ewewewew
    @RequestMapping(value = {"loginpage"})
    public  String loginPage(){
        return "login";
    }


    //用户登陆界面登陆
    @RequestMapping(value ={"/login"})
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        System.out.println("--------------------1");

        System.out.println("username = " +username);
        System.out.println("password =" +password);

        User user = userService.getUserInfo(username,password);
        if (user!= null){
            //设置session的值，在登陆成功界面进行显示
            session.setAttribute("username",username);
            return "hello";
        }else {
            return "error";
        }
    }

    //这是测试另一种传输方式，和上面的方法有所区别
    @RequestMapping(value = {"/login2"},method = {RequestMethod.GET,RequestMethod.POST})
    public String login2(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+",password="+password);
        User user = userService.getUserInfo(username,password);
        if(user != null) {
            session.setAttribute("username",username);
            return "hello";

        }else {
            System.out.println("11111");
            return "error";
        }

    }

    //用户注册界面的跳转密码
    @RequestMapping(value = {"/register"})
    public  String register(){
        return  "register";
    }

}
