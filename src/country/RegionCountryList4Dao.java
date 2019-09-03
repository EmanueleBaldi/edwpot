package country;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/country/regionCountry")
public class RegionCountryList4Dao extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/hr")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Integer value = (Integer.parseInt(request.getParameter("region"))) ;
        DaoRegionCountry dao = new DaoRegionCountry(ds);
        request.setAttribute("countries", dao.getQuery(value));
        request.getRequestDispatcher("/country/regionCountry.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}