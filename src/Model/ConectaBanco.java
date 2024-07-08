package Model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConectaBanco {
	public static Connection obterConexao() 
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Carregou o Driver");
			String url = "jdbc:mysql://localhost:3307/teste"; // 
			String user = "root";
			String password = "";
			try 
			{
				con = (Connection) DriverManager.getConnection(url, user, password);
				System.out.println("Conectou");
			}
			catch (SQLException ex) {
				System.out.println("Não Conectou");
			}
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.println("Não Carregou o Driver");
		}
		return con;
	}

	public static void main(String[] args) 
	{
		obterConexao();
	}
}
