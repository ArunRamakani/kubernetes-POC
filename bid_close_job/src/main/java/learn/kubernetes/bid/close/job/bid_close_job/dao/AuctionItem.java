package learn.kubernetes.bid.close.job.bid_close_job.dao;

import java.util.Date;
import java.util.List;

public class AuctionItem {
	

	private String itemId;
	private String itemName;
	private String itemDiscription;
	private int minimumBid; 
	private Date bidEndTime;
	private String auctionStatus;
	
	private List<BidHistory> bidHistory;
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDiscription() {
		return itemDiscription;
	}

	public void setItemDiscription(String itemDiscription) {
		this.itemDiscription = itemDiscription;
	}

	public int getMinimumBid() {
		return minimumBid;
	}

	public void setMinimumBid(int minimumBid) {
		this.minimumBid = minimumBid;
	}

	public Date getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public String getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}

	public List<BidHistory> getBidHistory() {
		return bidHistory;
	}

	public void setBidHistory(List<BidHistory> bidHistory) {
		this.bidHistory = bidHistory;
	}

}


