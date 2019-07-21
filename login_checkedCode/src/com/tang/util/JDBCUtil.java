package com.tang.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
        private static DataSource ds;

        static{
            try {
                Properties prop = new Properties();
                prop.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
                ds = DruidDataSourceFactory.createDataSource(prop);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static DataSource getDataSource(){
            return ds;
        }

        public static Connection getConnection() throws SQLException {
            return ds.getConnection();
        }

}
