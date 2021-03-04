package com.supermarket.buzz.offer;

import com.supermarket.buzz.item.Item;
import com.supermarket.buzz.utils.SpecialOfferCalculator;
import java.io.FileNotFoundException;

public class Offer extends Item {

  Item item;

  public Offer(Item item) {
    this.item = item;
  }

  @Override
  public int cost() throws FileNotFoundException {
    return new SpecialOfferCalculator().calculatePriceOfItem(item.totalItemPurchased(),
        item.getStockKeepingUnitDetails().get(item.getDescription()).getActualPrice(),
        item.getStockKeepingUnitDetails().get(item.getDescription())
            .getNumberOfItemEligibleForDiscount(),
        item.getStockKeepingUnitDetails().get(item.getDescription()).getDiscountedPrice());
  }
}