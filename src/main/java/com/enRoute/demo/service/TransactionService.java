package com.enRoute.demo.service;

import com.enRoute.demo.model.Transaction;
import com.enRoute.demo.repository.TransactionRepository;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author JODY
 */
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    
	/*@Value("${gmail.username}")
	private String username;
	@Value("${gmail.password}")
	private String password;*/
    
        public List<Transaction> getAllTransactions() {
            return (List<Transaction>) transactionRepository.findAll();
	}
 
	/*public Transaction getTransaction(Long id) {
               return transactionRepository.findById(id).orElse(null);
	}*/
        public List<Transaction> getUserTransactions(Long userId) {
               return (List<Transaction>) transactionRepository.findByUserId(userId);
	}
 
	public void makeTransaction(@RequestBody Transaction transaction)/* throws MessagingException, AddressException, IOException */{
           // Email email=new Email();
            Random ran=new Random();
            transaction.setId(transaction.getTransactionDate().getNanos()+ran.nextInt(transaction.getTransactionDate().getNanos())+1);
           
            /*email.setToAddress(transaction.getEmail());
            email.setSubject("Kulula payment information");
            email.setBody("This is your booking reference "+transaction.getId());
            
            sendmail(email.getToAddress(),email.getSubject(),email.getBody());*/
            
            transactionRepository.save(transaction);

	}
       
	public void updateTransaction(@RequestBody Transaction transaction) {
                transactionRepository.save(transaction);
	}
        
        
        /*private void sendmail(String To,String Subject,String Body) throws AddressException, MessagingException, IOException {	
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "*");
            Session session = Session.getInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
		}
            });
            Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username, false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
		msg.setSubject(Subject);
		msg.setContent(Body, "text/html");
		msg.setSentDate(new Date());
		Transport.send(msg);
		/*MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(email.getBody(), "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();

		attachPart.attachFile("C:\\talk2amareswaran-downloads\\mysql2.png");

		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);*/
		// sends the e-mail
			
    //}
}

