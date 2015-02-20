package Mail;

import java.util.Scanner;

public class Tester 
{
	public static void main(String[] args) 
	{
		String to = "";
		String subject = "";
		String mensaje = "";
		
		Mail mail = new Mail();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Type your Username: ");
		mail.setUsername(scan.nextLine());
		System.out.println("Type your Password: ");
		mail.setPassword(scan.nextLine());
		
		System.out.println("To: ");
		to = scan.nextLine();
		System.out.println("Subject: ");
		subject = scan.nextLine();
		System.out.println("Message: ");
		mensaje = scan.nextLine();
		scan.close();
		
		mail.send(to, subject, mensaje);
	}
}
