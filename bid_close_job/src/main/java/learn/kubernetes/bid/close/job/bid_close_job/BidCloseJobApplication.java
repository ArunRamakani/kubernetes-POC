package learn.kubernetes.bid.close.job.bid_close_job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BidCloseJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidCloseJobApplication.class, args);
	}
}
