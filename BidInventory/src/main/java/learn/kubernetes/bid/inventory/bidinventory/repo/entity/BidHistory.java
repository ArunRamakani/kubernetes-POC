package learn.kubernetes.bid.inventory.bidinventory.repo.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bid_history")
public class BidHistory {

	
	@Id
	@Column(name = "trans_id")
	private String transID;
	
	@Column(name = "item_id")
	private String itemId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "bid_value")
	private int bidValue;
	@Column(name = "bid_time")
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

