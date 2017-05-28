package learn.kubernetes.bid.purchase.auction_purchase.services;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.kubernetes.bid.purchase.auction_purchase.entity.Purchases;
import learn.kubernetes.bid.purchase.auction_purchase.repo.PurchaseListRepo;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	
	
	@Autowired
    private PurchaseListRepo purchaseListRepo;

	@Override
	public void updatePurchase(int user_id, String item_id, String item_name, String item_discription, int purchase_value) {
		// TODO Auto-generated method stub
		
		Purchases purchase = new Purchases();
		
		purchase.setTransID(UUID.randomUUID().toString());
		purchase.setItemName(item_name);
		purchase.setItemId(item_id);
		purchase.setItemDiscription(item_discription);
		purchase.setUserId(user_id);
		purchase.setPurchaseValue(purchase_value);
		purchaseListRepo.save(purchase);
	}

	@Override
	public String[] getPurchaseList(int user_id) {
		// TODO Auto-generated method stub
		
		String[] arr = purchaseListRepo.getPurchases(user_id);
		
//		
//		if (arr.length > 0) {
//			Purchases[] arrPur = new Purchases[arr.length] ;
//			
//			 for(int i = 0; i < arr.length; i++){
//				 String[] pur = arr[i].split(",");
//				 
//				 Purchases singlePur = new Purchases();
//				 singlePur.setItemName(pur[0]);
//				 singlePur.setItemDiscription(pur[1]);
//				 singlePur.setPurchaseValue(Integer.parseInt(pur[2]));
//			 }
//			 
//		return arrPur;
//		}
		return arr;
	}

}
