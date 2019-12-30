import java.io.*;
import java.util.*;
import java.sql.*;

import javax.mail.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.Session;

public class MailReminderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("email_id");

        String userEmailId = request.getParameter("email_id");
        String feeDueDate = request.getParameter("fee_due_date");
        Float feeAmount = Float.parseFloat(request.getParameter("fee_amount"));

        if(emailId.equals("admin")){
            final String senderEmailId = "#";
            final String senderEmailPassword = "123";

            Properties prop = new Properties();
            prop.put("mail.smtp.auth","true");
            prop.put("mail.smtp.starttls.enable","true");
            prop.put("mail.smtp.host","smtp.gmail.com");
            prop.put("mail.smtp.port","587");

            Session emailSession = Session.getInstance(prop,
                    new Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication(senderEmailId,senderEmailPassword);
                        }
                    });

            System.out.println("Session for mail created");

            try{
                Message message = new MimeMessage(emailSession);
                message.setFrom(new InternetAddress(senderEmailId));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(userEmailId));
                message.setSubject("Reminder for fee payment");
                message.setText("Fee payment\nDue Date : "+ feeDueDate + "\nAmount : "+feeAmount+"\nTo be paid on or before " +
                        "due date.\nThanks and regards.\nAcademics");

                Transport.send(message);

                System.out.print("Mail Sent");
            } catch (MessagingException e){
                System.out.println("Mail Sending error : " + e.getMessage());
            }

            request.setAttribute("mail_message","mail_sent");
            request.getRequestDispatcher("#").include(request,response);
        } else {
            session.invalidate();
            response.sendRedirect("#");
        }
    }
}
