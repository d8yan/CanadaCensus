package servlet;

import bean.AgeBean;
import dao.Age;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AgeServlet", value = "/age")
public class AgeServlet extends HttpServlet {
    Age ageDao = new Age();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AgeBean> age = null;
        int id = Integer.parseInt(request.getParameter("yearId"));
        int censusYear = id == 1 ? 2021:2016;
        try{
            age = ageDao.getAgeList(id);
            request.setAttribute("ageList", age);
            request.setAttribute("censusYear", censusYear);
            getServletContext().getRequestDispatcher("/ageList.jsp").forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
