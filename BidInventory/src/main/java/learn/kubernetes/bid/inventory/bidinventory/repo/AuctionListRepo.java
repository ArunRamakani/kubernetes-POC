package learn.kubernetes.bid.inventory.bidinventory.repo;




import org.springframework.data.repository.CrudRepository;

import learn.kubernetes.bid.inventory.bidinventory.repo.entity.AuctionItem;


public interface AuctionListRepo extends CrudRepository<AuctionItem, String> {
	
}
