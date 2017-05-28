package learn.kubernetes.bid.inventory.bidinventory.dto;

public class BidRequest {

	private String auctionID;
	
	private int bidValue;
	
	private int userID;
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getAuctionID() {
		return auctionID;
	}

	public void setAuctionID(String auctionID) {
		this.auctionID = auctionID;
	}

	public int getBidValue() {
		return bidValue;
	}

	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}

}
