package learn.kubernetes.bid.close.job.bid_close_job.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import learn.kubernetes.bid.close.job.bid_close_job.service.CloseAuctions;


@Component
public class CloseAuctionsScheduler {

    private static final Logger log = LoggerFactory.getLogger(CloseAuctions.class);
    
    @Autowired
	private CloseAuctions closeAuctions;

    @Scheduled(fixedRate = 500)
    public void reportCurrentTime() {
    	closeAuctions.findAndCloseAuctions();
    	log.debug("Closing auctions");
    }
}