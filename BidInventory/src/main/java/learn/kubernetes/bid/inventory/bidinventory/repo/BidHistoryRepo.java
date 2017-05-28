package learn.kubernetes.bid.inventory.bidinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import learn.kubernetes.bid.inventory.bidinventory.repo.entity.BidHistory;

public interface BidHistoryRepo extends JpaRepository<BidHistory,String>{
	
	@Query("SELECT bidValue FROM BidHistory where itemId = :item_id ORDER BY bidValue") 
	Integer[] bidHistoryForAuction(@Param("item_id") String item_id);
}
