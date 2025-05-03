package it.unirc.txw.prototipo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.txw.prototipo.beans.account.Account;
import it.unirc.txw.prototipo.beans.account.AccountDAO;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Account account=new Account();
		account.setUsername(username);
		account.setPassword(password);
		
		AccountDAO aDAO=new AccountDAO();
		boolean esiste=aDAO.get(account);
		
		if (esiste) {
			HttpSession session=request.getSession();
			session.setAttribute("autenticato", true);
		}
		response.sendRedirect("privato/");
	}

	
	
	
}
