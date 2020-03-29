package com.hyron.demo3.controller;
import com.hyron.demo3.entity.User;
import com.hyron.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/usercontroller"})
public class UserController {

    @Autowired
    UserService userService;

    User user = new User();
    //private Object modelMap;

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

    //利用JS进行数据的返回判断的
    @RequestMapping(value = "/mlogin")
    @ResponseBody
    public Map<String,Object> mlogin(HttpServletRequest request) throws Exception{
        ModelMap modelMap = new ModelMap();
        HttpSession session = request.getSession();
        System.out.println("查看获取用户名="+request.getParameter("username"));
        System.out.println("密码="+request.getParameter("password"));

        if (request.getParameter("username")==null||request.getParameter("password")==null){
            modelMap.addAttribute("loginmsg","wrong");
        }else {
            user=userService.getUserInfo(request.getParameter("username"),request.getParameter("password"));
            if(user==null){
                modelMap.addAttribute("loginmsg","faile");
            }else {
                modelMap.addAttribute("loginmsg","success");
                session.setAttribute("model",modelMap);
            }
        }
        return modelMap;

    }

    //登陆成功后跳转的方法
    //这里好像需要使用在参数里写上model
    @RequestMapping(value = {"/hello"})
    public String hello(Model model){
        //System.out.println("测试是否跳转到hello方法里边");
        //System.out.println("测试用户内容="+user.getUsername());
        List<User> userList =userService.getAllUser();
        if (user==null){
            //这里就表示登陆用户为空，需要从登陆界面重新登陆
            return "login";
        }else {
            model.addAttribute("person",user);
            model.addAttribute("userList",userList);
            System.out.println("--------------------2");
            return "hello";
        }

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
