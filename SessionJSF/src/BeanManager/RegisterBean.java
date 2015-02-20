package BeanManager;

import Users.Admin;
import Users.Normal;
import DAO.UserService;

public class RegisterBean 
{
	private String username;
    private String password;
    private String email;
    
    Admin admin = new Admin();
	Normal normal = new Normal();
	UserService userService = new UserService();
	
	public void registerAdmin()
	{
		admin.setName(username);
		admin.setPass(password);
		admin.setEmail(email);
		userService.registerAdmin(admin);
	}
	
	public void registerNormal()
	{
		normal.setName(username);
		normal.setPass(password);
		normal.setEmail(email);
		userService.registerNormal(normal);
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
}
