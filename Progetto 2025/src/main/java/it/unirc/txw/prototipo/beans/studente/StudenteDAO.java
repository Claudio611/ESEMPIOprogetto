package it.unirc.txw.prototipo.beans.studente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import it.unirc.txw.prototipo.utils.DBManager;



/*
package it.unirc.txw.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.txw.dao.utils.DBManager;
*/


public class StudenteDAO {

	private static Connection conn = null;

	public Studente get(Studente studente) {
		String query = "SELECT * FROM STUDENTE WHERE matricola =?";
		
		Studente res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, studente.getMatricola());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToStudente(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private Studente recordToStudente(ResultSet rs) throws SQLException {
		Studente studente = new Studente();
		studente.setMatricola(rs.getInt("matricola"));
		studente.setNome(rs.getString("nome"));
		studente.setDataDiNascita(rs.getDate("data_di_nascita"));
		if (rs.getObject("cdl") != null)
			studente.setCdl(rs.getInt("cdl"));
		return studente;
	}

	public Vector<Studente> getAll() {
		String query = "SELECT * FROM STUDENTE order by matricola";
		
		Vector<Studente> res = new Vector<Studente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Studente studente = recordToStudente(rs);
				res.add(studente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Studente studente) {
		String query = "INSERT INTO STUDENTE VALUES ( ?, ?, ?, ?)";
		boolean esito = false;
		
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
//			ps = conn.prepareStatement(query);
			
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, studente.getMatricola());
			ps.setString(2, studente.getNome());
			
			//converto da util.Date a sql.Date 
			java.sql.Date data=new java.sql.Date(studente.getDataDiNascita().getTime());
			ps.setDate(3, data);
			
			if (studente.getCdl() != null)
				ps.setInt(4, studente.getCdl());
			else
				ps.setNull(4, java.sql.Types.INTEGER);
			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
			ResultSet rs = ps.getGeneratedKeys();
		    rs.next();
		    //System.out.println("Chiave inserita "+rs.getInt(1));
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Studente studente) {
		String query = "DELETE FROM Studente WHERE matricola = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, studente.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;

		} catch (SQLException e) {
			esito = false;
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean modifica(Studente s) {
		String query = "UPDATE Studente SET nome=?, data_di_nascita=?, cdl=? WHERE matricola=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, s.getNome());
			
			//converto da util.Date a sql.Date 
			ps.setDate(2, new java.sql.Date(s.getDataDiNascita().getTime()));

			if (s.getCdl() != null)
				ps.setInt(3, s.getCdl());
			else
				ps.setNull(3, java.sql.Types.INTEGER);

			ps.setInt(4, s.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
}
