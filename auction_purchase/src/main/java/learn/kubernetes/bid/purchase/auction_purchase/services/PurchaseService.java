package learn.kubernetes.bid.purchase.auction_purchase.services;


public interface PurchaseService {
	
	public void updatePurchase(int user_id, String item_id, String item_name, String item_discription, int purchase_value);
	
	public String[] getPurchaseList(int user_id);

}
