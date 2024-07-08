package Model;

import java.util.Date;

public class KPI {

	private int Id_kpi;
	private String name;
	private double weight;
	private double goal_daily;
	private double goal_weekly;
	private double goal_monthly;
	private boolean visibilidade;
	private String date_time;

	public KPI()
	{

	}

	public KPI(int id_kpi, String name, double weight, double goal_daily, double goal_weekly, double goal_monthly,
			boolean visibilidade, String date_time)
	{
		Id_kpi = id_kpi;
		this.name = name;
		this.weight = weight;
		this.goal_daily = goal_daily;
		this.goal_weekly = goal_weekly;
		this.goal_monthly = goal_monthly;
		this.visibilidade = visibilidade;
		this.date_time = date_time;
	}
	
	
	public int getId_kpi() {
		return Id_kpi;
	}
	public void setId_kpi(int id_kpi) {
		Id_kpi = id_kpi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getGoal_daily() {
		return goal_daily;
	}
	public void setGoal_daily(double goal_daily) {
		this.goal_daily = goal_daily;
	}
	public double getGoal_weekly() {
		return goal_weekly;
	}
	public void setGoal_weekly(double goal_weekly) {
		this.goal_weekly = goal_weekly;
	}
	public double getGoal_monthly() {
		return goal_monthly;
	}
	public void setGoal_monthly(double goal_monthly) {
		this.goal_monthly = goal_monthly;
	}
	public boolean isVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
	
	
	
}
