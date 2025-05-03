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
import it.unirc.txw.prototipo.beans.studente.Studente;
import it.unirc.txw.prototipo.beans.studente.StudenteDAO;


/**
 * Servlet implementation class RichiediModificaStudente
 */
@WebServlet("/privato/studente/RichiediModificaStudente")
public class RichiediModificaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediModificaStudente() {
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
		
		//1 input
		String matricolaS=request.getParameter("matricola");
		int matricola=-1;
		try {
			matricola=Integer.parseInt(matricolaS);
		}
		catch (Exception e) {
			// lo mando in una pagina di errore ....
		}
		
		
		//2 elaborazione
		StudenteDAO studenteDAO= new StudenteDAO();
		Studente studente=new Studente();
		studente.setMatricola(matricola);
		studente=studenteDAO.get(studente);
	
		CDLDAO cDAO=new CDLDAO();
		Vector<CDL> cdls =  cDAO.getAll();
		
		//3 output
		request.setAttribute("studente", studente);
		request.setAttribute("cdls",cdls);
		
		//4 scelta view
		request.getRequestDispatcher("/WEB-INF/privato/studente/aggiungi.jsp").forward(request, response);
		
		
	}

}
