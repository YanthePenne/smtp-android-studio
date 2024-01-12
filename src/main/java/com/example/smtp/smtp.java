package com.example.smtp;
import static android.content.ContentValues.TAG;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class smtp extends AsyncTask<Void, Void, Boolean> {
    private String recipientEmail;

    public smtp(String recipientEmail) {

        this.recipientEmail = recipientEmail;

    }
    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com"); // replace with your SMTP server
            props.put("mail.smtp.port", "587");  // or "465" or "25"

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("penne.yanthe@gmail.com", "**Y@nthe1087");
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("penne.yanthe@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Yanthe.penne@gmail.com"));
            message.setSubject("This is a subject");
            message.setText("this is my first test");

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (success) {
            // Email sent successfully, handle UI update or other actions
        } else {
            // Failed to send email, handle error
        }
    }

}

