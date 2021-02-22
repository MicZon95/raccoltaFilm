package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteUpdateFilmServlet
 */
@WebServlet("/ExecuteUpdateFilmServlet")
public class ExecuteUpdateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExecuteUpdateFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titolo = request.getParameter("titolo");
		String genere = request.getParameter("genere");
		String dataPubblicazione = request.getParameter("dataPubblicazione");
		String minutiDurata = request.getParameter("minutiDurata");
		String registaId = request.getParameter("regista.id");
		
		Date dataPubblicazioneParam = UtilityForm.parseDateArrivoFromString(dataPubblicazione);
		
		if (!UtilityForm.validateFilmFormInput(titolo, genere, minutiDurata, dataPubblicazione,
				registaId) || dataPubblicazioneParam == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/film/update.jsp").forward(request, response);
		}
		
		Film filmInstance = new Film(titolo, genere, dataPubblicazioneParam,
				Integer.parseInt(minutiDurata), new Regista(Long.parseLong(registaId)));
		
		try {
			
			MyServiceFactory.getFilmServiceInstance().aggiorna(filmInstance);
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/film/update.jsp").forward(request, response);
		}
		
		try {
		response.sendRedirect("ExecuteListFilmServlet?operationResult=SUCCESS");
		}catch(IOException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Errore nel redirect!");
			request.getRequestDispatcher("/film/update.jsp").forward(request, response);
		}
	}

}
