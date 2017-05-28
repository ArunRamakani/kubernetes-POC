package learn.kubernetes.bid.close.job.bid_close_job.dao;

import java.util.Date;

public class BidHistory {


	private String transID;
	private String itemId;
	private int userId;
	private int bidValue;
	private Date bidTime;
	
	public String getTransID() {
		return transID;
	}
	public void setTransID(String transID) {
		this.transID = transID;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBidValue() {
		return bidValue;
	}
	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}
	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	
	
	
	
}

