@Service
public class EmailService {
    public void sendEmail(String to, String msg) {
        System.out.println("Sending email to " + to);
    }
}