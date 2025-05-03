package it.unirc.txw.prototipo.servlet.privato.studente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.txw.prototipo.beans.studente.Studente;
import it.unirc.txw.prototipo.beans.studente.StudenteDAO;



/**
 * Servlet implementation class EliminaStudente
 */
@WebServlet("/privato/studente/EliminaStudente")
public class EliminaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminaStudente() {
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
		
		String matricolaS=request.getParameter("matricola");
		int matricola=-1;
		try {
			matricola=Integer.parseInt(matricolaS);
		}
		catch (Exception e) {
			// lo mando in una pagina di errore ....
		}
		
		StudenteDAO studenteDAO= new StudenteDAO();
		Studente studente=new Studente();
		studente.setMatricola(matricola);
		if (studenteDAO.elimina(studente))
			response.sendRedirect("Index?successo");
		else
			response.sendRedirect("Index?errore");

	}

}
