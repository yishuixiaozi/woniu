package com.hyron.demo3.controller;
import com.hyron.demo3.entity.User;
import com.hyron.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/usercontroller"})
public class UserController2 {

    @Autowired
    UserService userService;

    User user = new User();

    @RequestMapping(value = {"/hello"})
    public String hello(){

        System.out.println("this is test");
        return "hello";
    }

    //从浏览器跳转到登陆界面进行登陆 ewewewew
    @RequestMapping(value = {"/loginpage"})
    public  String loginPage(ModelMap map){
        map.put("username","zhouxiangrong");
        User userInfo = new User();
        userInfo.setPassword("123456");
        userInfo.setUsername("zxr");

        map.put("userInfo",userInfo);

        return "login";
    }

    //从浏览器跳转到登陆界面进行登陆 ewewewew
    @RequestMapping(value = {"/loginpage1"})
    public  String loginPage1(ModelMap map){
        map.put("username","zhouxiangrong");
        User userInfo = new User();
        userInfo.setPassword("123456");
        userInfo.setUsername("zxr");

        map.put("userInfo",userInfo);

        return "login1";
    }





    //利用ajax进行登陆的数据判断'
    @RequestMapping(value = "/mlogin")
    @ResponseBody
    public Map<String,Object> mlogin(HttpServletRequest request) throws Exception{
        Map<String,Object> map = new HashMap<String ,Object>();

        System.out.println("查看获取用户名="+request.getParameter("username"));
        System.out.println("密码="+request.getParameter("password"));

        if (request.getParameter("username")==null||request.getParameter("password")==null){
            map.put("msg","wrong");
        }else {
            user=userService.getUserInfo(request.getParameter("username"),request.getParameter("password"));
            if(user==null){
                map.put("msg","wrong");
            }else {
                map.put("msg","success");
            }
        }
        return map;

    }

    //用户登陆界面登陆
    @RequestMapping(value ={"/login"})
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        System.out.println("--------------------1");

        System.out.println("username = " +username);
        System.out.println("password =" +password);

        User user = userService.getUserInfo(username,password);
        List<User> userList =userService.getAllUser();
        if (user!= null){
            //设置session的值，在登陆成功界面进行显示
            session.setAttribute("username",username);
            model.addAttribute("person",user);
            model.addAttribute("userList",userList);
            return "hello";
        }else {
            return "error";
        }
    }

    @PostMapping(value = {"/login3"})
    public String login3(@ModelAttribute User user){
        System.out.println("-----tesut username="+user.getUsername());
        System.out.println("------test password="+user.getPassword());

        return "hello";
    }




    //这是测试另一种传输方式，和上面的方法有所区别
    @RequestMapping(value = {"/login2"},method = {RequestMethod.GET,RequestMethod.POST})
    public String login2(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+",password="+password);
        User user = userService.getUserInfo(username,password);
        //List<User> listuser=userService.getAllUser();

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
