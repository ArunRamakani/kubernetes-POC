package learn.kubernetes.bid.close.job.bid_close_job.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import learn.kubernetes.bid.close.job.bid_close_job.dao.AuctionItem;

@Service("closeAuctions")
public class CloseAuctionImpl implements CloseAuctions {
	
	@Value("${auction.inventory.host}")
	private String inventoryHost;
	
	@Value("${auction.close.host}")
	private String closeHost;
	
	@Value("${auction.updatepurchase.host}")
	private String purchaseUpdate;

	@Override
	public void findAndCloseAuctions() {
		
		
		RestTemplate restTemplate = new RestTemplate();
		AuctionItem[] auctionItem = restTemplate.getForObject(inventoryHost, AuctionItem[].class);
       
		for(AuctionItem item : auctionItem){
			
			Calendar givenDate = Calendar.getInstance();
			givenDate.setTime(item.getBidEndTime());
			Calendar givenDate1 = Calendar.getInstance();
			givenDate1.setTime(new Date());
			
			if(givenDate.before(givenDate1)) {
				String closeHost1 = closeHost.replace("{auctionID}", item.getItemId());
				RestTemplate restTemplate1 = new RestTemplate();
				restTemplate1.getForObject(closeHost1, Boolean.class);
				
				if(!item.getBidHistory().isEmpty()) {
					RestTemplate restTemplate2 = new RestTemplate();
					
				    restTemplate2.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
				    // create request body
				    String input = "{\"item_discription\": \"{item_discription}\", \"item_id\": \"{item_id}\", \"item_name\": \"{item_name}\", \"purchase_value\": {purchase_value}, \"user_id\": {user_id}}";
				    input = input.replace("{item_discription}", item.getItemDiscription());
				    input = input.replace("{item_id}", item.getItemId());
				    input = input.replace("{item_name}", item.getItemName());
				    input = input.replace("{purchase_value}", Integer.toString(item.getBidHistory().get(0).getBidValue()));
				    input = input.replace("{user_id}", Integer.toString(item.getBidHistory().get(0).getUserId()));
				    
				    
				    // set headers
				    HttpHeaders headers = new HttpHeaders();
				    headers.setContentType(MediaType.APPLICATION_JSON);
				    HttpEntity<String> entity = new HttpEntity<String>(input, headers);

				    // send request and parse result
				    restTemplate
				            .exchange(purchaseUpdate, HttpMethod.POST, entity, String.class);
			    }

				
				
			}
		}
	}

}


