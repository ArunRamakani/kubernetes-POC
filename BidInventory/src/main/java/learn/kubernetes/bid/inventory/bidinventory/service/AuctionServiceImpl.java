package learn.kubernetes.bid.inventory.bidinventory.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.kubernetes.bid.inventory.bidinventory.dto.BidRequest;
import learn.kubernetes.bid.inventory.bidinventory.repo.AuctionListRepo;
import learn.kubernetes.bid.inventory.bidinventory.repo.BidHistoryRepo;
import learn.kubernetes.bid.inventory.bidinventory.repo.entity.AuctionItem;
import learn.kubernetes.bid.inventory.bidinventory.repo.entity.BidHistory;

@Service("auctionService")
public class AuctionServiceImpl implements AuctionService{

	
	@Autowired
    private AuctionListRepo auctionListRepo;
	
	@Autowired
    private BidHistoryRepo bidHistoryRepo;
	
	@Transactional
	public Boolean placeBid(BidRequest bidObject) {
		// TODO Auto-generated method stub
		
		AuctionItem auctionitem = auctionListRepo.findOne(bidObject.getAuctionID());
		
		if(auctionitem.getAuctionStatus().equals("ACTIVE")) {
			Integer[] bidHistory= bidHistoryRepo.bidHistoryForAuction(bidObject.getAuctionID());
			if(bidHistory.length == 0) {
				BidHistory newBid = new BidHistory();
				newBid.setTransID(UUID.randomUUID().toString());
				newBid.setBidTime(new Date(Calendar.getInstance().getTime().getTime()));
				newBid.setBidValue(bidObject.getBidValue());
				newBid.setUserId(bidObject.getUserID());
				newBid.setItemId(bidObject.getAuctionID());
				bidHistoryRepo.save(newBid);
				return true;
			}
			if(bidHistory[bidHistory.length-1].intValue() <  bidObject.getBidValue()) {
				BidHistory newBid = new BidHistory();
				newBid.setTransID(UUID.randomUUID().toString());
				newBid.setBidTime(new Date(Calendar.getInstance().getTime().getTime()));
				newBid.setBidValue(bidObject.getBidValue());
				newBid.setUserId(bidObject.getUserID());
				newBid.setItemId(bidObject.getAuctionID());
				bidHistoryRepo.save(newBid);
				return true;
			}
		}
		return false;
	}

	
	public Boolean close(String itemID) {
		AuctionItem item = auctionListRepo.findOne(itemID); 
		item.setAuctionStatus("CLOSED");
		auctionListRepo.save(item);
		
		return true;
	}
	
	public ArrayList<AuctionItem> getAllAuctions() {
		
		
		ArrayList<AuctionItem> all = (ArrayList<AuctionItem>) auctionListRepo.findAll();
		
		ArrayList<AuctionItem> openAuction = new ArrayList<AuctionItem>();
		
		for(AuctionItem auc : all) {
			if(auc.getAuctionStatus().equals("ACTIVE")) {
				openAuction.add(auc);
			}
		}
		
		return openAuction;
	}

}
