package nl.pa3bmg.chat.scheduledtaks;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    		log.info("reportCurrentTime Current Thread : {}", Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
    
    @Scheduled(fixedDelay = 2000)
    public void scheduleTaskWithFixedDelay() {
    	log.info("scheduleTaskWithFixedDelay Current Thread : {}", Thread.currentThread().getName());
        log.info("Fixed Delay Task :: Execution Time - {}", dateFormat.format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            log.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }
    
    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
    		log.info("scheduleTaskWithInitialDelay Current Thread : {}", Thread.currentThread().getName());
        log.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateFormat.format(new Date()));
    }
    
    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
    		log.info("scheduleTaskWithCronExpression Current Thread : {}", Thread.currentThread().getName());
        log.info("Cron Task :: Execution Time - {}", dateFormat.format(new Date()));
    }
}
