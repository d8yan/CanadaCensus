package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;

public class DBUtil {
    static Connection con = null;
    public static Connection dbConnection(){
        if(con != null){
            return con;
        }
        final String url = "jdbc:mysql://localhost:3306/hrmanager";
        final String user = "root";
        final String password = "1234";
        final String className = "com.mysql.cj.jdbc.Driver";

        try{
            MysqlDataSource mysql = new MysqlDataSource();

            mysql.setURL(url);
            mysql.setUser(user);
            mysql.setPassword(password);
            Class.forName(className);
            con = mysql.getConnection();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
