package learn.kubernetes.bid.purchase.auction_purchase.dao;

public class PurchaseRequest {
	
	private int    user_id;
	private String  item_id;
	private String  item_name;
	private String  item_discription;
	private int  purchase_value;
	
	public int getPurchase_value() {
		return purchase_value;
	}
	public void setPurchase_value(int purchase_value) {
		this.purchase_value = purchase_value;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_discription() {
		return item_discription;
	}
	public void setItem_discription(String item_discription) {
		this.item_discription = item_discription;
	}
	
}

