package Model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.ConectaBanco;
import Model.KPI;

public class KpiDAO {
	
	private Connection connection;

	public KpiDAO()
	{
		this.connection = ConectaBanco.obterConexao();
	}
	
	public void inserirKpi(KPI k)
	{
		PreparedStatement st = null;
		String  sql = "INSERT INTO kpi VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		try 
		{
			st = (PreparedStatement) connection.prepareStatement(sql);
			st.setInt(1,  k.getId_kpi());
			st.setString(2, k.getName());
			st.setDouble(3, k.getWeight());
			st.setDouble(4,  k.getGoal_daily());
			st.setDouble(5, k.getGoal_weekly());
			st.setDouble(6, k.getGoal_monthly());
			st.setBoolean(7, k.isVisibilidade());
			st.setString(8, k.getDate_time());
			st.executeQuery();
			st.close();
			
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				st.close();
			}
			catch(SQLException x)
			{
				x.printStackTrace();
			}
		}
	}
	
	public List<KPI> buscarKPI()
	{
		List<KPI> resultados = new ArrayList<KPI>();
		PreparedStatement stmt = null;
		ResultSet rs;
		String sql = "SELECT id_kpi, name, weight, goal_daily, goal_weekly, goal_monthly, visible, data FROM kpi where data = CURDATE();";
		try 
		{
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				KPI temp = new KPI();
				temp.setId_kpi(rs.getInt("id_kpi"));
				temp.setName(rs.getString("name"));
				temp.setWeight(rs.getDouble("weight"));
				temp.setGoal_daily(rs.getDouble("goal_daily"));
				temp.setGoal_weekly(rs.getDouble("goal_weekly"));
				temp.setGoal_monthly(rs.getDouble("goal_monthly"));
				temp.setVisibilidade(rs.getBoolean("visible"));
				temp.setDate_time(rs.getString("data"));
				resultados.add(temp);
			}
			return resultados;
		} 
		catch (SQLException e)
		{
			e.printStackTrace(); return null;
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
}
