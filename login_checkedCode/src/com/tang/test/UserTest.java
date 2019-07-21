package com.tang.test;

import com.tang.dao.UserDao;
import com.tang.domain.User;
import org.junit.Test;

public class UserTest {

    @Test
    public void test01(){
        User userLogin = new User();
        userLogin.setUsername("lisa");
        userLogin.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(userLogin);

        if(user != null) {
            System.out.println(user.getUsername() + "-" + user.getPassword());
        }else{
            System.out.println("user=null");
        }

    }
}
