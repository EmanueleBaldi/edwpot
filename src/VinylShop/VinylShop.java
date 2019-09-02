package VinylShop;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VinylShop/VinylShop")
public class VinylShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		List <Integer> vinile = (List<Integer>) session.getAttribute("vinile");
		
		if (vinile == null) {
			
			
	            } else {
	            	String vinyls = request.getParameter("vinyls");
	            	String quantita = request.getParameter("quantity");
	            }
	
		if (request.getParameter("logout") != null) {
			session.invalidate();
			
			response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head><meta charset=\"utf-8\">");
                writer.println("<title>So long</title></head>");
                writer.println("<body><h1>Goodbye</h1>");
                writer.println("</body></html>");
		}
		} else {
				Duration duration = null;
	        	request.setAttribute("duration", duration ); 
	        	RequestDispatcher rd = request.getRequestDispatcher("/VinylShop/VinylShop");
	        	rd.forward(request, response);
		}
	}
}