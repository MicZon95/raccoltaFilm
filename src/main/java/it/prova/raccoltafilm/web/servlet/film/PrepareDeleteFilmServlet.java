package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareDeleteFilmServlet
 */
@WebServlet("/PrepareDeleteFilmServlet")
public class PrepareDeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareDeleteFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idFilm = request.getParameter("idFilm");
		
		if(!NumberUtils.isCreatable(idFilm)) {
			request.setAttribute("errorMessage", "Si è verificato un errore");
			request.getRequestDispatcher("film/list.jsp").forward(request, response);
			return;
		}
		
		try {
			Film filmDaEliminare = MyServiceFactory.getFilmServiceInstance().caricaSingoloElementoEager(Long.parseLong(idFilm));

			if (filmDaEliminare == null) {
				request.setAttribute("errorMessage", "Elemento non trovato.");
				request.getRequestDispatcher("ExecuteListFilmServlet?operationResult=NOT_FOUND").forward(request,
						response);
				return;
			}
			
			request.setAttribute("filmDaEliminare", filmDaEliminare);
			request.getRequestDispatcher("film/delete.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Si è verificato un errore nella visualizzazione della pagina");
			request.getRequestDispatcher("film/list.jsp").forward(request, response);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
