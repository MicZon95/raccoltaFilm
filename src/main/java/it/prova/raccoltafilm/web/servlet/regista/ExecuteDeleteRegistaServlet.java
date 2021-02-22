package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteRegistaServlet
 */
@WebServlet("/ExecuteDeleteRegistaServlet")
public class ExecuteDeleteRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteDeleteRegistaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idRegista = request.getParameter("idRegista");
		
		System.out.println("CIAO" + idRegista );

		try {
			Regista regista = MyServiceFactory.getRegistaServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idRegista));
			MyServiceFactory.getRegistaServiceInstance().rimuovi(regista);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/delete.jsp").forward(request, response);
		}
		
		try {
			response.sendRedirect("ExecuteListRegistaServlet?operationResult=SUCCESS");

		}catch(IOException ioException) {
			ioException.printStackTrace();
			request.setAttribute("errorMessage", "Errore nel redirect in pagina!");
			request.getRequestDispatcher("home").forward(request, response);
		}
	}

}
