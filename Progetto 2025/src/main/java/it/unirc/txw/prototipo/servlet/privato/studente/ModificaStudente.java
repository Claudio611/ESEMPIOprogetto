package it.unirc.txw.prototipo.servlet.privato.studente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.txw.prototipo.beans.studente.Studente;
import it.unirc.txw.prototipo.beans.studente.StudenteDAO;



/**
 * Servlet implementation class ModificaStudente
 */
@WebServlet("/privato/studente/ModificaStudente")
public class ModificaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaStudente() {
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

		String nome=request.getParameter("nome");
		String dataS=request.getParameter("data");
		Date data=new Date(); //se non riesce a convertire, usa la data di oggi - non è il massimo ma mi permette di andare avanti
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	    try {
			data=sdf.parse(dataS);
		} catch (ParseException e) {
			//gestire  l'eccezione opportunamente
			e.printStackTrace();
		}
	    
	
		String cdlS=request.getParameter("cdl");
		Integer cdl=null;
		try {
			cdl=Integer.parseInt(cdlS);
		}
		catch (Exception e) {
			// verificare se e come gestire in caso di necessità
		}
		
				
		Studente studente=new Studente();
		studente.setMatricola(matricola);
		studente.setNome(nome);
		studente.setDataDiNascita(data);
		studente.setCdl(cdl);
		
		
		StudenteDAO studenteDAO= new StudenteDAO();
		studenteDAO.modifica(studente);
		//Sarebbe da gestire la restituzione di true e false con opportuni messaggi
		
		response.sendRedirect("Index");
	
	}

}
