package learn.kubernetes.bid.inventory.bidinventory.service;

import java.util.ArrayList;

import learn.kubernetes.bid.inventory.bidinventory.dto.BidRequest;
import learn.kubernetes.bid.inventory.bidinventory.repo.entity.AuctionItem;

public interface AuctionService {

	public Boolean placeBid(BidRequest bidObject);
	
	public Boolean close(String itemID);

	public ArrayList<AuctionItem> getAllAuctions();

}
