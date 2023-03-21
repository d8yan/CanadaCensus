package dao;

import bean.AgeBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Age {

    public List getAgeList(int yearId){
        List<AgeBean> ageList = new ArrayList<AgeBean>();
        Connection con = DBUtil.dbConnection();
        try
        {
            PreparedStatement prep = con.prepareStatement("SELECT a.ageId, b.description, a.male, a.female \n" +
                    "FROM group5.age a \n" +
                    "JOIN group5.agegroup b ON a.ageGroup = b.ageGroupID\n" +
                    "WHERE a.geographicArea = 1 AND a.censusYear = ? ");
            prep.setInt(1, yearId);

            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                AgeBean age = new AgeBean();
                age.setId(rs.getInt("ageId"));
                age.setAgeGroup(rs.getString("description"));
                age.setMale(rs.getInt("male"));
                age.setFemale(rs.getInt("female"));
                ageList.add(age);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ageList;
    }
}
