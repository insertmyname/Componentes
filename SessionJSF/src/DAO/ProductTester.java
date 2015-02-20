package DAO;

import java.util.Scanner;
import Products.Product;

public class ProductTester 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Product product = new Product();
		ProductService ps = new ProductService();
		
		System.out.println("Type the product code: ");
		product.setCode(scan.nextInt());
		System.out.println("Type the product name: ");
		product.setName(scan.next());
		System.out.println("Type the product brand: ");
		product.setBrand(scan.next());
		
		ps.registerProduct(product);
		ps.showProducts();
		
		scan.close();
	}

}
