
//测试使用
function login() {
    alert('常规写法');//这里是你函数的内容
}

//登陆界面登陆
function loginpass() {
    //alert("出发消息成功");
    $.ajax({
        data: {username:$("#username").val(), password:$("#password").val()},
        type:"post",
        dataType:'json',
        url:"/usercontroller/mlogin",
        error:function (data) {
            alert("ajax执行失败");
        },
        success:function(data){
            /*alert(data["msg"]);*///返回的data是一个map,所以data["msg"]是对象的值
            //alert(data.toString())
            var loginmsg=data["loginmsg"];
            /*alert(msg1);*/
            if(loginmsg=="wrong")
            {
                alert("用户名或密码错误");
                $("#loginform").resetForm();
            }else if(loginmsg=="faile"){
                alert("该用户不存在");
            }else{
                alert("登陆成功，即将跳转"+loginmsg);
               //不同的框架这里使用方式也是不一样的，这里是执行后台usercontroller里边的hello方法
                window.location.href ="hello";
            }
        }
    });

}