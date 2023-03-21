package servlet;

import bean.GeoBean;
import dao.Geo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GeoServlet", value = "/geo")
public class GeoServlet extends HttpServlet {
    Geo geoDao = new Geo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GeoBean> geoLocations = null;
        int levelValue = Integer.parseInt(request.getParameter("levelValue"));
        try{
            geoLocations = geoDao.getGeos(levelValue);
            request.setAttribute("geos", geoLocations);
            request.setAttribute("level", levelValue);
            getServletContext().getRequestDispatcher("/geo.jsp").forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
