package servlet;

import bean.GeoBean;
import dao.Geo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GeoDetailsServlet", value = "/geoDetails")
public class GeoDetailsServlet extends HttpServlet {
    Geo geoDao = new Geo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GeoBean g = null;
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Servlet id: "+ id);
        try{
            g = geoDao.getGeoDetail(id);
            request.setAttribute("geoDetails", g);
            getServletContext().getRequestDispatcher("/geoDetails.jsp").forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
