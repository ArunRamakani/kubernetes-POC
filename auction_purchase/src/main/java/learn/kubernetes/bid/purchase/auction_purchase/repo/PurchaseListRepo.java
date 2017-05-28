package learn.kubernetes.bid.purchase.auction_purchase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import learn.kubernetes.bid.purchase.auction_purchase.entity.Purchases;


public interface PurchaseListRepo extends JpaRepository<Purchases,Long>{
	
	@Query("SELECT p.itemName, p.itemDiscription, p.purchaseValue  FROM Purchases p where p.userId = :user_id") 
	String[] getPurchases(@Param("user_id") int user_id);
}


