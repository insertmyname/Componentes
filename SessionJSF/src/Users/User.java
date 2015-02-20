package Users;
public abstract class User 
{
	int id = 0;
	int root = 0;
	String name = "";
	String pass = "";
	String email = "";
	

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getRoot() 
	{
		return root;
	}
	
	public void setRoot(int root) 
	{
		this.root = root;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getPass() 
	{
		return pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
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
