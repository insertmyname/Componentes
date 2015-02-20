package Mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail 
{
	private final Properties properties = new Properties();
    private Session session;
    
    String username = "";
	String password = "";

    private void init() 
    {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", username);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }

    public void send(String to,String subject, String mensaje) 
    {
        init();
        
        try 
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(mensaje,"text/html");
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            System.out.println("Messege Sent :D");
        }
        
        catch (MessagingException e) 
        {
            return;
        }
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
    
}
