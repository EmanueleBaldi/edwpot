package s08;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s08/checker") 
public class Checker extends HttpServlet { //la servlet è una classe che estende HttpServlet che gestisce il ciclo request response
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user"); //quello che mi arriva dall'utente è un parametro (è il name dell'input e con get parameter vado a prendere il contenuto) 
        Set<Character> set = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }							   //l'attributo è il modo in cui passiamo da una servlet all'altra il lavoro che abbiamo appena fatto				
        }									
        request.setAttribute("set", set); //infatti l'attributo è ciò su cui lavoriamo noi 

        RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp"); //getRequestDispatcher passiamo la request da questa servlet ad un'altra
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
