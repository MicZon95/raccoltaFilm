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
import org.apache.commons.lang3.StringUtils;

@WebServlet("/ExecuteSearchFilmServlet")
public class ExecuteSearchFilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String titolo = request.getParameter("titolo");
        String genere = request.getParameter("genere");
        String minutiDurata = request.getParameter("minutiDurata");
        String dataPubblicazione = request.getParameter("dataPubblicazione");
        String idRegista = request.getParameter("idRegista");

        Regista regista = null;


        Integer minutiDurataParsed = StringUtils.isNotBlank(minutiDurata) ? Integer.parseInt(minutiDurata) : null;

        Date dataPubblicazioneParsed = StringUtils.isNotBlank(dataPubblicazione) ? UtilityForm.parseDateArrivoFromString(dataPubblicazione) : null;


        try {
            if (StringUtils.isNotBlank(idRegista)) {
                regista = MyServiceFactory.getRegistaServiceInstance().caricaSingoloElemento(Long.parseLong(idRegista));
            }

            Film example = new Film(titolo, genere , dataPubblicazioneParsed, minutiDurataParsed, regista);

            request.setAttribute("film_list_attribute",
                    MyServiceFactory.getFilmServiceInstance().findByExample(example));
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
            request.getRequestDispatcher("/regista/search.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("film/list.jsp").forward(request, response);
    }

}
