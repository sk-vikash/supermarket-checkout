package com.supermarket.buzz.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StockKeepingUnit {

  private String itemName;

  private int actualPrice;

  private int numberOfItemEligibleForDiscount;

  private int discountedPrice;

  public int getDiscountedPrice() {
    return (numberOfItemEligibleForDiscount * actualPrice - discountedPrice);
  }
}
