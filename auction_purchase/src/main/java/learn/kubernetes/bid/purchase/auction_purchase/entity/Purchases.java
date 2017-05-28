package learn.kubernetes.bid.purchase.auction_purchase.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="purchases")
public class Purchases {
	
	
	@Id
	@Column(name = "trans_id")
	private String transID;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "item_id")
	private String itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_discription")
	private String itemDiscription;
	
	
	@Column(name = "purchase_value")
	private int purchaseValue;
	
	
	public int getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(int purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

}

