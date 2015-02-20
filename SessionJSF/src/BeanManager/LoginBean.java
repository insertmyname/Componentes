package BeanManager;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import DAO.UserService;


public class LoginBean 
{
	private String username;
    private String password;
    private String root;
	
	UserService userService = new UserService();
	
	public String doLogin() 
	{
        int result = userService.compareCredentials(username, password);
        System.out.println("Result es igual a: " + result);
        System.out.println(username);
        System.out.println(password);
        
        if (result == 1) 
        {
        	HttpSession hs = Util.getSession();
			hs.setAttribute("username", username);
			root = "Administrador";
            return "profileAdmin";
        } 
        
        if (result == 2) 
        {
        	HttpSession hs = Util.getSession();
			hs.setAttribute("username", username);
			root = "Normal";
            return "profileNormal";
        } 
        
        else 
        {
        	FacesMessage fm = new FacesMessage("Login Error","ERROR MSG");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, fm);
            return "index";
        }
    }
 
    public String doLogout() 
    { 
      HttpSession hs = Util.getSession();
      hs.invalidate();
      return "index";
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

	public String getRoot() 
	{
		return root;
	}

	public void setRoot(String root)
	{
		this.root = root;
	}
	
	
}
