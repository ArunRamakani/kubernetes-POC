package learn.kubernetes.bid.inventory.bidinventory.repo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="auction_item")
public class AuctionItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "item_id")
	private String itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_discription")
	private String itemDiscription;
	@Column(name = "minimum_bid")
	private int minimumBid; 
	
	@Column(name = "bid_end_time")
	private Date bidEndTime;
	@Column(name = "auction_status")
	private String auctionStatus;
	
	@OneToMany
	@JoinColumn(name="item_id")
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


