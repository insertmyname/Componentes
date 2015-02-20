package DAO;

import java.util.Scanner;
import Users.Normal;
import Users.Admin;

public class UserTester 
{
	public static void main(String[] args) 
	{
		UserService us = new UserService();
		Normal normal = new Normal();
		Admin admin = new Admin();
		Scanner scan = new Scanner(System.in);
		int selection = 0;
		
		System.out.println("Seleccione la operacion que desea realizar: " + "\n" + 
							"(1) Crear Usuario: Administrador" + "\n" + 
							"(2) Crear Usuario: Normal" + "\n" + 
							"(3) Ver lista de usuarios" + "\n" + 
							"(4) Login" + "\n" + 
							"(5) Login2");
		
		selection = scan.nextInt();
		
		switch(selection)
		{
		case 1: System.out.println("Type your name: ");
				admin.setName(scan.next());
				System.out.println("Type your pass: ");
				admin.setPass(scan.next());
				System.out.println("Type your email: ");
				admin.setEmail(scan.next());
				us.registerAdmin(admin);
				System.out.println("Usuario Administrador creado correctamente.");
				break;
				
		case 2: System.out.println("Type your name: ");
				normal.setName(scan.next());
				System.out.println("Type your pass: ");
				normal.setPass(scan.next());
				System.out.println("Type your email: ");
				normal.setEmail(scan.next());
				us.registerNormal(normal);
				System.out.println("Usuario Normal creado correctamente.");
				break;
				
		case 3: us.showUsers(); break;
		
		case 4: System.out.println("Digite su nombre de usuario y su contrasena");
				us.compareCredentials(scan.next(), scan.next()); break;
				
		case 5: us.compareCredentials3(); break;
				
		default: System.out.println("Seleccion incorrecta, intentelo de nuevo."); break;
		}
		
		scan.close();
	}
}

