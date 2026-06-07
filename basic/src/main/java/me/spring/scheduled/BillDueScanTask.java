package me.spring.scheduled;

import me.spring.dao.BillRepository;
import me.spring.entity.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Scheduled task — scans bills due for payment each morning and triggers email reminders.
 */
@Component
public class BillDueScanTask {

    private static final Logger log = LoggerFactory.getLogger(BillDueScanTask.class);

    private final BillRepository billRepository;

    public BillDueScanTask(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    /** Run daily at 8:00 AM */
    @Scheduled(cron = "0 0 8 * * ?")
    public void scanOverdueBills() {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysLater = today.plusDays(3);

        // Find bills due within the next 3 days
        List<Bill> dueBills = billRepository.findByDueDateBetweenAndStatus(today, threeDaysLater, "PENDING");

        // Mark overdue bills (due date passed)
        List<Bill> overdueBills = billRepository.findByStatusAndDueDateBefore("PENDING", today);
        for (Bill bill : overdueBills) {
            bill.setStatus("OVERDUE");
            billRepository.save(bill);
            log.info("Bill [{}] marked as OVERDUE", bill.getName());
        }

        log.info("Bill due scan complete: {} due soon, {} newly overdue", dueBills.size(), overdueBills.size());

        // TODO: send email reminders for dueBills via MailService
    }
}
