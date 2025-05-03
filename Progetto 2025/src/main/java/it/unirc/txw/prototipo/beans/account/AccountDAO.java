package it.unirc.txw.prototipo.beans.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unirc.txw.prototipo.utils.DBManager;



public class AccountDAO {

	private static Connection conn = null;

	public boolean get(Account account) {
		//verificare se è necessario usare
		//String query = "SELECT * FROM ACCOUNT WHERE username =? and BINARY password=?";
		String query = "SELECT * FROM ACCOUNT WHERE username =? and BINARY password=?";
		boolean res = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
}
