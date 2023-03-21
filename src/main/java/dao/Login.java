package dao;

import bean.LoginBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public boolean loginUser(LoginBean login){
        boolean result = false;
        Connection con = DBUtil.dbConnection();

        try
        {
            PreparedStatement prep = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ? ");
            prep.setString(1, login.getUsername());
            prep.setString(2, login.getPassword());

            ResultSet rs = prep.executeQuery();
            result = rs.next();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
