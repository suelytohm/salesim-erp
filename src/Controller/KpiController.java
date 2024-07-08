package Controller;

import java.util.Date;

import Model.KPI;
import Model.dao.KpiDAO;

public class KpiController {
	
	// Método para salvar o KPI na pasta de configuração do integrador.
	public void salvarKpi(int id_kpi, String name, double weight, double goal_daily, double goal_weekly, double goal_monthly, boolean visibilidade, String date_Time)
	{
		ArquivoKPI ak = new ArquivoKPI();
		ak.criarKPI(id_kpi, name, weight, goal_daily, goal_weekly, goal_monthly, visibilidade, date_Time);	
	}
	
	public String listarKpi(int i)
	{
		ArquivoKPI ak = new ArquivoKPI();
		return ak.lerKPI(i);
	}
	
	
	public String listarKpiJunto(int i)
	{
		ArquivoKPI ak = new ArquivoKPI();
		return ak.lerKPIjunto();
	}	
	
	public String listarKpi_Users()
	{
		ArquivoKPI ak = new ArquivoKPI();
		return ak.lerKPIjunto();
	}
}
