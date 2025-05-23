package dk.kvalitetsklaedt.backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmationEmail(String toEmail) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(toEmail);
            helper.setSubject("Tak for din tilmelding!");

            String htmlContent = """
                    <!DOCTYPE html>
                    <html lang="da">
                    <head>
                      <meta charset="UTF-8">
                      <title>Tak for din tilmelding</title>
                    </head>
                    <body style="margin:0; padding:0; font-family:'Segoe UI', sans-serif; background-color:#0f171f; color:#f5f5f5;">

                      <table align="center" cellpadding="0" cellspacing="0" width="100%" style="max-width:600px; margin:auto;">
                        <tr>
                          <td bgcolor="#d7be74" style="padding: 40px 0; text-align: center;">
                            <h1 style="margin:0; font-size:36px; color:#0f171f;">Kvalitetsklædt</h1>
                            <p style="margin:0; font-size:16px; color:#0f171f;">Stil med holdning</p>
                          </td>
                        </tr>

                        <tr>
                          <td bgcolor="#0f171f" style="padding: 40px 30px 20px 30px;">
                            <h2 style="color: #d7be74; font-size: 28px;">Tak for din tilmelding!</h2>
                            <p style="font-size: 18px; line-height: 1.6;">
                              Vi har modtaget din interesse og din feedback.<br>
                              Det betyder meget for os, og vi glæder os til at dele mere med dig, når vi lancerer!
                            </p>
                          </td>
                        </tr>

                        <tr>
                          <td bgcolor="#0f171f" style="padding: 0 30px 30px 30px;">
                            <div style="background-color:#d7be74; padding:20px; border-radius:12px;">
                              <p style="margin:0; color:#0f171f; font-size:16px; text-align:center;">
                                🎉 Du er nu en del af vores community – følg med for eksklusive opdateringer!
                              </p>
                            </div>
                          </td>
                        </tr>

                        <tr>
                          <td bgcolor="#0f171f" style="padding: 20px 30px 40px 30px; text-align: center;">
                            <img src="https://via.placeholder.com/500x150.png?text=Tak+for+din+interesse!" 
                                 alt="Tak" style="width:100%; max-width:500px; border-radius:8px;">
                          </td>
                        </tr>

                        <tr>
                          <td bgcolor="#0f171f" style="padding: 20px 30px 40px 30px; text-align: center;">
                            <a href="#" style="background-color:#d7be74; color:#0f171f; padding:15px 30px; font-size:16px; font-weight:bold; text-decoration:none; border-radius:30px;">
                              Besøg vores hjemmeside
                            </a>
                          </td>
                        </tr>

                        <tr>
                          <td bgcolor="#0f171f" style="padding: 30px; text-align: center; color: #aaa; font-size: 12px;">
                            &copy; 2025 Kvalitetsklædt · Alle rettigheder forbeholdes
                          </td>
                        </tr>
                      </table>

                    </body>
                    </html>
                    """;

            helper.setText(htmlContent, true);

            mailSender.send(message);
            System.out.println("succes");

        } catch (MessagingException e) {
            System.err.println("Kunne ikke sende mail: " + e.getMessage());
        }
    }
}
