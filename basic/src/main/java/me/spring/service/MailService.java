package me.spring.service;

public interface MailService {
    void sendPasswordResetEmail(String to, String resetToken);
    void sendBillReminder(String to, String billName, String dueDate);
    void sendBudgetAlert(String to, String categoryName, double percentage);
}
