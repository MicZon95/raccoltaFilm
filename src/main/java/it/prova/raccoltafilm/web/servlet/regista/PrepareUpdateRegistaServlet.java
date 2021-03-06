package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareUpdateRegista
 */
@WebServlet("/PrepareUpdateRegista")
public class PrepareUpdateRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareUpdateRegistaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRegista = request.getParameter("idRegista");
		
		if(!NumberUtils.isCreatable(idRegista)) {
			request.setAttribute("errorMessage", "Si è verificato un errore");
			request.getRequestDispatcher("regista/list.jsp").forward(request, response);
			return;
		}
		
		try {
			Regista registaDaModificare = MyServiceFactory.getRegistaServiceInstance().caricaSingoloElemento(Long.parseLong(idRegista));
			request.setAttribute("registaDaModificare", registaDaModificare);
			
			request.getRequestDispatcher("regista/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Si è verificato un errore nella visualizzazione della pagina di modifica");
			request.getRequestDispatcher("regista/list.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
