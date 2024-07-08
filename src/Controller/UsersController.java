package Controller;

import java.util.List;

import Model.Users;
import Model.dao.UsersDAO;

public class UsersController {
	
	private UsersDAO ud;
	
	public UsersController()
	{
		ud = new UsersDAO();
	}
	

	public List<Users> buscarUsers()
	{
		return ud.buscarUsers();
	}
	
	
}
