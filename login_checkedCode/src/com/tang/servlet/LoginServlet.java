package com.tang.servlet;

import com.tang.dao.UserDao;
import com.tang.domain.User;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");

       //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        String checkCode_session = (String) request.getSession().getAttribute("checkCode_session");
        //一次性验证码
        request.getSession().removeAttribute("checkCode_session");

        //判断验证码是否正确（用户填写的验证码 和 生成的验证码 判断）
        if(checkCode != null && checkCode.equalsIgnoreCase(checkCode_session)){
            //验证码验证成功 判断用户名密码
            UserDao dao = new UserDao();
            User userLogin = new User();
            userLogin.setUsername(username);
            userLogin.setPassword(password);
            User user = dao.login(userLogin);

            if(user != null){
                //存储用户信息：现在为了后来登录成功，跳过去会欢迎xxx
                                //以后 jsp 没有登录 就不能访问某些页面  eg：我的订单
                                //判断登录与否，就是判断session中的username,如果没有就直接跳到重新登录
               request.getSession().setAttribute("user",user.getUsername());
                //重定向 要 虚拟路径
                response.sendRedirect(request.getContextPath()+"/success.jsp");

                /*
                此时 不能使用request存的两个理由：
                request第一个不好
                （使用request保存 ，使用请求转发，这个功能也能实现）
                （但是：浏览了其他网页 再回去 就不行了）
                    所以 登录成功的判断是 session中存储username
                 request第二个不好
                    刷新页面：以为你在刷新，其实是在重新登录
                    转发 浏览器地址栏不变
                    你以为刷新 xxx.jsp 其实是在继续访问 loginServlet 重新登录

                */


            }else{

                request.getSession().setAttribute("error_up","用户名或密码错误");
                System.out.println("用户名密码");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else{
            request.getSession().setAttribute("error_check","验证码输入错误");
            System.out.println("验证码");
            //请求转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }



        //先判断验证码是否正确
        //(在ckeckCodeServlet中 把生成的验证码存到session中)

        //获取生成的验证码 session.getAttribute();
        /*
        if("获取的验证码".equalsIgnoreCase(生成的验证码比较))jdk  String类
            //忽略大小写比较
            {
                //验证码正确
                if（判断账号密码  UserDao.login(username,password);）{
                    //查询数据库 //登录成功
                   //存储用户信息息
                   request.getSession().setAttribute("user",user);

                   //重定向success.jsp(两次请求，所以存在session中)
                    （success.jsp中，）



                }else{
                    //登录失败

                    //
                }

            }else{
            //验证码不一致
                //存储提示信息到request 请求转发到错误页面
                (错误 login.jsp )
                (<div><%=request.getSession().getAttribute("error_checkCode")  %></div>)
                request.getSession().getAttribute("error_checkCode")

            }

         */



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
