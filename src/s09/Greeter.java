package s09;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s09/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); // metto la request in session con getsession perchè l'oggetto session è automaticamente creato da tomcat
        LocalTime start = (LocalTime) session.getAttribute("start"); // sto chidendo a session se ha un attributo start, se non ce l'ha start è null

        Duration duration;
        if (start == null) {
            duration = Duration.ZERO; //duration.ZERO è una proprietà della classe Duration per settare la duration costante a zero
            session.setAttribute("start", LocalTime.now()); //setAttribute settiamo start come attributo a session con valore localtime.now a start, nel caso in cui sia null, facciamo così perchè gli attributi sono chiave-valore
        } else {
            duration = Duration.between(start, LocalTime.now());//se invece start ha un valore, che sarà localtime, fammi la differenza fra localtime e localtime.now
        }

        if (request.getParameter("done") != null) { //sto chiedendo a request se ha un parametro done
            session.invalidate(); //se hai un parametro done chiudi la sessione

            //mi genero la risposta
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head><meta charset=\"utf-8\">");
                writer.println("<title>So long</title></head>");
                writer.println("<body><h1>Goodbye</h1>");
                writer.println("<p>You worked on this stuff for " + duration.getSeconds() + " seconds</p>");
                writer.println("</body></html>");
            }
           
        } else {

        //qui abbiamo l'else dell'if della riga 33 (se il done è null avremo invece)
        request.setAttribute("duration", duration); //prendo la mia variabile locale duration e la setto come attributo a request, faccio questo perchè vogliamo passare duration alla servlet nel file greeter.jsp
        RequestDispatcher rd = request.getRequestDispatcher("/s09/greeter.jsp");
        rd.forward(request, response);
        }
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
