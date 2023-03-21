package servlet;

import bean.GeoBean;
import bean.LoginBean;
import dao.Geo;
import dao.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Login loginDao = new Login();
    Geo geoDao = new Geo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        List<GeoBean> geoLocations = null;

        LoginBean login = new LoginBean();
        login.setUsername(user);
        login.setPassword(pass);

        try{
            if(loginDao.loginUser(login)){
                geoLocations = geoDao.getGeos(0);
                //System.out.println("servlet geo count:"+geoLocations.size());
                //System.out.println("servlet geo count:"+geoLocations.toString());
                request.setAttribute("geos", geoLocations);
                getServletContext().getRequestDispatcher("/geo.jsp").forward(request, response);
            }
            else{
                String message = "Invalid username or password";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
