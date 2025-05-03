package it.unirc.txw.prototipo.servlet.privato.studente;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.txw.prototipo.beans.studente.Studente;
import it.unirc.txw.prototipo.beans.studente.StudenteDAO;


/**
 * Servlet implementation class Index
 */
@WebServlet("/privato/studente/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
		
		//passo 1: nessun parametro
		
		//passo 2:
		StudenteDAO studenteDAO=new StudenteDAO();
		Vector<Studente> studenti= studenteDAO.getAll();
		
		//passo 3:
		request.setAttribute("studenti", studenti);
		
		request.getRequestDispatcher("/WEB-INF/privato/studente/index.jsp").forward(request, response);
	}

}
