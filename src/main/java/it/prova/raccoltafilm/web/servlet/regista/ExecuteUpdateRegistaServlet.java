package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.model.Sesso;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteUpdateRegistaServlet
 */
@WebServlet("/ExecuteUpdateRegistaServlet")
public class ExecuteUpdateRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteUpdateRegistaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idRegista = request.getParameter("idRegista");
		String nomeRegista = request.getParameter("nome");
		String cognomeRegista = request.getParameter("cognome");
		String dataDiNascitaRegista = request.getParameter("dataDiNascita");
		String nickNameRegista = request.getParameter("nickName");
		String sessoRegista = request.getParameter("sesso");
		
		System.out.println(idRegista);
		
		Date dataDiNascita = UtilityForm.parseDateArrivoFromString(dataDiNascitaRegista);
		
		//VALIDAZIONE
		if(!UtilityForm.validateRegistaFormInput(nomeRegista, cognomeRegista, nickNameRegista, 
				dataDiNascitaRegista) || dataDiNascita == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/regista/update.jsp").forward(request, response);
		}
		
		try {
			//cerco il regista nel db
			Regista registaInstance = MyServiceFactory.getRegistaServiceInstance().caricaSingoloElemento(Long.parseLong(idRegista));
			
			//campi da aggiornare
			registaInstance.setNome(nomeRegista);
			registaInstance.setCognome(cognomeRegista);
			registaInstance.setNickName(nickNameRegista);
			registaInstance.setDataDiNascita(dataDiNascita);
			registaInstance.setSesso(Sesso.valueOf(sessoRegista));
			
			//aggiorno l'articolo
			MyServiceFactory.getRegistaServiceInstance().aggiorna(registaInstance);
			
			request.setAttribute("lista_regista_attr", MyServiceFactory.getRegistaServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Modifica effettuata con successo");
			response.sendRedirect("ExecuteListRegistaServlet?operationResult=SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/update.jsp").forward(request, response);
		}
	}

}
