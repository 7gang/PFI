package server;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Database_com_ref {

	public static void main(String[] args) {
		try {  
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "1");
			Statement statement = conn.createStatement();
			//statement.execute("INSERT INTO TEST VALUES(4,'Hello')");
			ResultSet res =	statement.executeQuery("SELECT * FROM TEST");
			while(res.next()) {
				System.out.println(res.getString("ID") + res.getString("NAME"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
