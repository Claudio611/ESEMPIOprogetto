package it.unirc.txw.prototipo.servlet.privato.studente;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.txw.prototipo.beans.corso_di_laurea.CDL;
import it.unirc.txw.prototipo.beans.corso_di_laurea.CDLDAO;


/**
 * Servlet implementation class RichiediAggiungiStudente
 */
@WebServlet("/privato/studente/RichiediAggiungiStudente")
public class RichiediAggiungiStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediAggiungiStudente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if (session.getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore=1");
			return;
		}
		
		CDLDAO cDAO=new CDLDAO();
		Vector<CDL> cdls=cDAO.getAll();
		
//		Studente studente=new Studente();
//		studente.setMatricola(0);
//		studente.setNome("prova");
//		studente.setDataDiNascita(new Date(0));
//		studente.setCdl(1);
//
//		request.setAttribute("studente",  studente);
		
		request.setAttribute("cdls", cdls);
		
		request.getRequestDispatcher("/WEB-INF/privato/studente/aggiungi.jsp").forward(request, response);
		
	}

}
