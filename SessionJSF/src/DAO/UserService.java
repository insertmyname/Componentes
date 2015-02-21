package DAO;

import Users.Normal;
import Users.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserService extends Service
{

	public void registerAdmin(Admin admin) 
	{
		conectar();

		try 
		{
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO USUARIO (ID,ROOT,NAME,PASS,EMAIL)values(?,?,?,?,?)");
			ps.setInt(1, admin.getId());
			ps.setInt(2, admin.getRoot());
			ps.setString(3, admin.getName());
			ps.setString(4, admin.getPass());
			ps.setString(5, admin.getEmail());
			ps.executeUpdate();
			System.out.println("El usuario (Administrador): " + admin.getName() + " se ha creado correctamente" );

			if (ps != null) 
			{
				ps.close();
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		desconectar();
	}

	public void registerNormal(Normal normal) 
	{
		conectar();

		try 
		{
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO USUARIO (ID,ROOT,NAME,PASS,EMAIL)values(?,?,?,?,?)");
			ps.setInt(1, normal.getId());
			ps.setInt(2, normal.getRoot());
			ps.setString(3, normal.getName());
			ps.setString(4, normal.getPass());
			ps.setString(5, normal.getEmail());
			ps.executeUpdate();
			System.out.println("El usuario (Normal): " + normal.getName() + " se ha creado correctamente" );

			if (ps != null) 
			{
				ps.close();
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		desconectar();
	}

	public void showUsers() 
	{
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL, ORDERDATE FROM USUARIO");

			while (rs.next()) 
			{
				System.out.println("==================================================");
				System.out.println("ID: " + rs.getInt(1));
				System.out.println("ROOT STATE: " + rs.getInt(2));
				System.out.println("NAME: " + rs.getString(3));
				System.out.println("PASS: " + rs.getString(4));
				System.out.println("EMAIL: " + rs.getString(5));
				System.out.println("CREATION DATE: " + rs.getTimestamp(6));
				System.out.println("==================================================");
			}

			if (rs != null) 
			{
				rs.close();
			}
			if (st != null) 
			{
				st.close();
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		desconectar();
	}
	
	
	public int compareCredentials(String username, String password) 
	{
		boolean entro = false;
		int exist = 0;
		
		
		conectar();

		try {
			Statement st = null;
			st = getConexion().createStatement(); 
			
			ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL FROM USUARIO");

			while (rs.next() && !entro) 
			{

				if (username.equals(rs.getString(3)) && (password.equals(rs.getString(4)))) {
					System.out.println("Welcome " + username);
					entro = true;

					if (rs.getInt(2) == 1) 
					{
						System.out.println("Tipo de Usuario: Administrador");
						exist = 1;
					}

					else 
					{
						System.out.println("Tipo de Usuario: Normal");
						exist = 2;
					}
				}
			}

			if (entro == false) 
			{
				
				System.out.println("Usuario o contrasena incorrectos");
				exist = 0;
			}

			if (rs != null) 
			{
				rs.close();
			}

			if (st != null) 
			{
				st.close();
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		desconectar();
		return exist;
	}
	

	public void compareCredentials2(String username, String password) 
	{
		boolean entro = false;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement(); 
			
			ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL FROM USUARIO");

			while (rs.next() && !entro) 
			{
				if (username.equals(rs.getString(3)) && (password.equals(rs.getString(4)))) 
				{
					System.out.println("Welcome " + username);
					entro = true;

					if (rs.getInt(2) == 1) 
					{
						System.out.println("Tipo de Usuario: Administrador");
					}

					else 
					{
						System.out.println("Tipo de Usuario: Normal");
					}
				}
			}

			if (entro == false) 
			{
				System.out.println("Usuario o contrasena incorrectos");
			}

			if (rs != null) 
			{
				rs.close();
			}

			if (st != null) 
			{
				st.close();
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		desconectar();
	}

	public void compareCredentials3() 
	{
		String username = "";
		String password = "";

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite su nombre de Usuario: ");
		username = scan.next();
		System.out.println("Digite su contrasena: ");
		password = scan.next();
		scan.close();

		boolean entro = false;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL FROM USUARIO");

			while (rs.next() && !entro) 
			{
				if (username.equals(rs.getString(3))&& (password.equals(rs.getString(4)))) 
				{
					System.out.println("Welcome " + username);
					entro = true;

					if (rs.getInt(2) == 1) 
					{
						System.out.println("Tipo de Usuario: Administrador");
					}

					else 
					{
						System.out.println("Tipo de Usuario: Normal");
					}
				}
			}

			if (entro == false) 
			{
				System.out.println("Usuario o contrasena incorrectos");
			}

			if (rs != null) 
			{
				rs.close();
			}

			if (st != null) 
			{
				st.close();
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		desconectar();
	}
}
