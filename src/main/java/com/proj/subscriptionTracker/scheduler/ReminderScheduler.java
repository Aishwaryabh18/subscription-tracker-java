package com.proj.subscriptionTracker.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReminderScheduler {

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendReminders() {
        System.out.println("Running reminder job...");
    }
}