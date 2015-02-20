package Users;
import java.util.Scanner;

public class Tester 
{

	public static void main(String[] args) 
	{
		Admin admin = new Admin();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite su nombre: ");
		admin.setName(scan.next());
		System.out.println("Digite su contrasena: ");
		admin.setPass(scan.next());
		scan.close();
		
		System.out.println("Su nombre es: " + admin.getName());
		System.out.println("Su contrasena es: " + admin.getPass());
		System.out.println("Root State: " + admin.getRoot());
		
	}

}
