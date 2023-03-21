package dao;

import bean.GeoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Geo {

    public List getGeos(int level){
        List<GeoBean> geoLocations = new ArrayList<GeoBean>();
        Connection con = DBUtil.dbConnection();
        try
        {
            PreparedStatement prep = con.prepareStatement("SELECT * FROM geographicarea WHERE level = ? ");
            prep.setInt(1, level);

            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                GeoBean g = new GeoBean();
                g.setId(rs.getInt("geographicAreaID"));
                g.setCode(rs.getInt("code"));
                g.setLevel(rs.getInt("level"));
                g.setName(rs.getString("name"));
                g.setAlternativeCode(rs.getInt("alternativeCode"));
                geoLocations.add(g);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println("hello geoDao:"+geoLocations.size());
        return geoLocations;
    }

    public GeoBean getGeoDetail(int id){
        GeoBean g = null;
        Connection con = DBUtil.dbConnection();

        try
        {
            PreparedStatement prep = con.prepareStatement("SELECT c.geographicAreaID, c.code, c.level, c.name, c.alternativeCode, (p.combined) AS totalPopulation \n" +
                    "FROM group5.geographicarea c\n" +
                    "JOIN group5.age p on\n" +
                    "p.geographicArea = c.geographicAreaID WHERE c.geographicAreaID = ? and p.censusYear = 1 and ageGroup = 1 ");
            prep.setInt(1, id);

            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                g = new GeoBean();
                g.setId(rs.getInt("geographicAreaID"));
                g.setCode(rs.getInt("code"));
                g.setLevel(rs.getInt("level"));
                g.setName(rs.getString("name"));
                g.setAlternativeCode(rs.getInt("alternativeCode"));
                g.setTotalPopulation(rs.getInt("totalPopulation"));
            }
            System.out.println("hello geoDetails:"+g.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return g;
    }
}
