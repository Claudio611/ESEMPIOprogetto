package it.unirc.txw.prototipo.servlet.privato.cdl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Index
 */
@WebServlet("/privato/cdl/Index")
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
		
		
		
		request.getRequestDispatcher("/WEB-INF/privato/cdl/index.jsp").forward(request, response);
	}

}
