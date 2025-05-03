package it.unirc.txw.prototipo.beans.corso_di_laurea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.txw.prototipo.utils.DBManager;



public class CDLDAO {
	private static Connection conn = null;

	protected CDL recordToCDL(ResultSet rs) throws SQLException {
		CDL cdl = new CDL();
		cdl.setId(rs.getInt("id"));
		cdl.setNome(rs.getString("nome"));
		return cdl;
	}

	public CDL get(CDL cdl) {
		String query = "SELECT * FROM CDL WHERE id = ?";
		CDL res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, cdl.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToCDL(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(CDL cdl) {
		String query = "INSERT INTO CDL VALUES (?, ?)";
		boolean esito = false;
		conn = DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cdl.getId());
			ps.setString(2, cdl.getNome());
			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(CDL cdl) {
		String query = "DELETE FROM CDL WHERE id = ?";
		boolean esito = false;
		conn = DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cdl.getId());
			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean modifica(CDL cdl) {
		String query = "UPDATE CDL SET nome=? WHERE id=?";
		boolean esito = false;
		conn = DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(2, cdl.getId());
			ps.setString(1, cdl.getNome());
			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public Vector<CDL> getAll() {
		String query = "SELECT * FROM CDL";
		Vector<CDL> res = new Vector<CDL>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			CDL cdl = new CDL();
			while (rs.next()) {
				cdl = recordToCDL(rs);
				;
				res.add(cdl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
}
