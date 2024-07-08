package Model;

import java.util.Date;

public class Users {
	
	private String filial;
	private String codigo; 
	private String id_users;
	private String Username;
	private String fullname;
	private String email;
	private String phone;
	private String type;
	private String visibilidade;
	private String date_time;

	public Users() 
	{

	}
	
	
	public Users(String filial, String codigo, String id_users, String username, String fullname, String email, String phone,
			String type, String visibilidade, String date_time)
	{
		this.filial = filial;
		this.codigo = codigo;
		this.id_users = id_users;
		this.Username = username;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.visibilidade = visibilidade;
		this.date_time = date_time;
	}

	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getid_users() {
		return id_users;
	}
	public void setid_users(String id_users) {
		this.id_users = id_users;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String Username) {
		this.Username = Username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}
	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
		
	}
	
	
	
	
}
