package com.tang.dao;

import com.tang.domain.User;
import com.tang.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User user){
        try {
            String sql = "select * from user where username=? and password=?";
            User userLogin = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
            return userLogin;
        } catch (DataAccessException e) {
            return null;
        }


    }
}
