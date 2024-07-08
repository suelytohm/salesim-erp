package Model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.ConectaBanco;

//imports aqui
public class EmpregadoDAO {
	private Connection connection;

	public EmpregadoDAO() {
		this.connection = ConectaBanco.obterConexao();
	}

	
	
//
//	
//	
//	public List<Empregado> buscarTodosEmpregados() {
//		List<Empregado> resultados = new ArrayList<Empregado>();
//		PreparedStatement stmt = null;
//		ResultSet rs;
//		String sql = "SELECT employee_id, first_name, last_name, job_id FROM employees";
//		try {
//		stmt = connection.prepareStatement(sql);
//		rs = stmt.executeQuery();
//		while (rs.next()) {
//		Empregado temp = new Empregado();
//		temp.setCodigo(rs.getInt("employee_id"));
//		temp.setPrimeiroNome(rs.getString("first_name"));
//		temp.setSegundoNome(rs.getString("last_name"));
//		temp.setCodigoCargo(rs.getString("job_id"));
//		resultados.add(temp);
//		}
//		return resultados;
//		} catch (SQLException e) { e.printStackTrace(); return null;
//		} finally {
//		try { stmt.close();
//		} catch (SQLException e) { e.printStackTrace();} } } }	
//	
//	
//	
//	
	
	
	
}