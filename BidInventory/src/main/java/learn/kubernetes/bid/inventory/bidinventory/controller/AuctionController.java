package learn.kubernetes.bid.inventory.bidinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import learn.kubernetes.bid.inventory.bidinventory.dto.BidRequest;
import learn.kubernetes.bid.inventory.bidinventory.repo.entity.AuctionItem;
import learn.kubernetes.bid.inventory.bidinventory.service.AuctionService;

@RestController
@RequestMapping("/auction")
public class AuctionController {
	
	
	@Autowired
	private AuctionService auctionService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuctionController.class);

	
	@ApiOperation(value = "Place a bit for the auction", notes = "Place a bit for the auction with auction id and bid value", response = Boolean.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Bid Places") })
	@RequestMapping(value = "/bid",method = RequestMethod.POST)
	public Boolean bid(@RequestBody BidRequest bidObject){
		LOGGER.info("Request for placing an bid for an auction");
		return auctionService.placeBid(bidObject);
	}
	
	
	@ApiOperation(value = "Close an auction", notes = "Close an auction auction id", response = Boolean.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Bid Places") })
	@RequestMapping(value = "/close/{itemId}",method = RequestMethod.GET)
	public Boolean closeOffer(@PathVariable String itemId) {
		LOGGER.info("Request for placing an bid for an auction");
		return auctionService.close(itemId);
	}
	
	
	@ApiOperation(value = "Get the list of active auctions", notes = "Get the list of active auctions", response = ArrayList.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Bid Places") })
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ArrayList<AuctionItem> getAuctionList(){
		LOGGER.info("Request for placing an bid for an auction");
		return auctionService.getAllAuctions();
	}
}
