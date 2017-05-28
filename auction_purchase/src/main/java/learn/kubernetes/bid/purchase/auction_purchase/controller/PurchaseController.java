package learn.kubernetes.bid.purchase.auction_purchase.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import learn.kubernetes.bid.purchase.auction_purchase.dao.PurchaseRequest;
import learn.kubernetes.bid.purchase.auction_purchase.services.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);

	
	
	
	@ApiOperation(value = "Update purchase details", notes = "Update purchase details", response = Boolean.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "updated") })
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Boolean bid(@RequestBody PurchaseRequest object){
		LOGGER.info("Request for update an auction purchase");
		purchaseService.updatePurchase(object.getUser_id(), object.getItem_id(), object.getItem_name(), object.getItem_discription(), object.getPurchase_value());
		return true;
	}
	
	
	
	@ApiOperation(value = "Get the list of active auctions", notes = "Get the list of active auctions", response = ArrayList.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Bid Places") })
	@RequestMapping(value = "/list/{userId}",method = RequestMethod.GET)
	public String[] getAuctionList(@PathVariable int userId){
		LOGGER.info("Request for placing an bid for an auction");
		return purchaseService.getPurchaseList(userId);
	}

}
