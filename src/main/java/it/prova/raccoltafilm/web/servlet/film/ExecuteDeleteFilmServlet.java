package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteFilmServlet
 */
@WebServlet("/ExecuteDeleteFilmServlet")
public class ExecuteDeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteDeleteFilmServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idFilm = request.getParameter("idFilm");
		
		try {
			Film film = MyServiceFactory.getFilmServiceInstance().caricaSingoloElementoEager(Long.parseLong(idFilm));
			System.out.println("sono qui");
			System.out.println(film);
			MyServiceFactory.getFilmServiceInstance().rimuovi(film);
			response.sendRedirect("ExecuteListFilmServlet?operationResult=SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/film/delete.jsp").forward(request, response);
			
		}
	}

}
