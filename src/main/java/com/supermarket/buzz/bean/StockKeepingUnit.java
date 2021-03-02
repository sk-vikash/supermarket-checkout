package com.supermarket.buzz.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockKeepingUnit {

  @CsvBindByPosition(position = 0)
  private String itemName;

  @CsvBindByPosition(position = 1)
  private int actualPrice;

  @CsvBindByPosition(position = 2)
  private int numberOfItemEligibleForDiscount;

  @CsvBindByPosition(position = 3)
  private int discountedPrice;

  public int getDiscountedPrice() {
    return (numberOfItemEligibleForDiscount * actualPrice - discountedPrice);
  }
}
