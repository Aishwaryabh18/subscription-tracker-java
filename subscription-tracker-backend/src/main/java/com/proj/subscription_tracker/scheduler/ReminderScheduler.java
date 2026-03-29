@Component
@EnableScheduling
public class ReminderScheduler {

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendReminders() {
        System.out.println("Running reminder job...");
    }
}