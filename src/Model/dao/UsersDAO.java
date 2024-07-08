package Model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.ConectaBanco;
import Model.Users;

public class UsersDAO {

	private Connection connection;

	// Conexão com o banco de dados.
	public UsersDAO()
	{
		this.connection = ConectaBanco.obterConexao();
	}
	
	// Método para buscar todos os usuários cadastrados no banco de dados.
	public List<Users> buscarUsers()
	{
		List<Users> resultados = new ArrayList<Users>();
		PreparedStatement stmt = null;
		ResultSet rs;
		String sql = "SELECT MID(codigofilial, 4, 5) AS filial, codigo AS vendedor, MID(nome, 1, 20) AS username, nome AS full_name, email, telefone AS phone, categoria AS TYPE, ativo AS visible, CURDATE() AS date_time FROM vendedores WHERE ativo = 'S';";
		try 
		{
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				Users u = new Users();
				String filial_codigo;
				// Mesclagem do código da filial com o código do vendedor
				filial_codigo = rs.getString("filial") + rs.getString("vendedor");
				u.setFilial(rs.getString("filial"));
				u.setCodigo(rs.getString("vendedor"));
				filial_codigo = u.getFilial() + u.getCodigo();
				u.setid_users(filial_codigo);
				u.setUsername(rs.getString("username"));
				u.setFullname(rs.getString("full_name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setType(rs.getString("type"));
				u.setVisibilidade("true");
				u.setDate_time(rs.getString("date_time"));
				System.out.println("teste");
				resultados.add(u);
			}
			return resultados;
		} 
		catch (SQLException e)
		
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				stmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			} 
		}
	}		
	
	// Método para buscar todas as vendas realizadas no dia.
	
}
