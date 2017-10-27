package pl.agataanaszewicz.portfolioAgataAnaszewicz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class ContactService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String content){
        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail,true);
            helper.setTo(to);
            helper.setReplyTo("ananaszek@gmail.com");
            helper.setFrom("ananaszek@gmail.com");
            helper.setSubject("Portfolio Contact");
            helper.setText(content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
}
