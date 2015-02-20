package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Products.Product;

public class ProductService extends Service
{
	public void registerProduct(Product product) 
	{
		conectar();

		try 
		{
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO PRODUCT (ID,CODE,NAME,BRAND)values(?,?,?,?)");
			ps.setInt(1, product.getId());
			ps.setInt(2, product.getCode());
			ps.setString(3, product.getName());
			ps.setString(4, product.getBrand());
			ps.executeUpdate();
			System.out.println("El producto: " + product.getName() + " se ha creado correctamente" );

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
	
	public void showProducts() 
	{
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");

			while (rs.next()) {
				System.out.println("==================================================");
				System.out.println("ID: " + rs.getInt(1));
				System.out.println("CODE: " + rs.getInt(2));
				System.out.println("NAME: " + rs.getString(3));
				System.out.println("BRAND: " + rs.getString(4));
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
}
