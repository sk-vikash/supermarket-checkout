package com.supermarket.buzz.utils;

public class SpecialOfferCalculator {

  public int calculatePriceOfItem(int numberOfItem, int actualPrice, int discountIndex,
      int discountPrice) {

    int price = 0;
    int counter = 0;

    while (numberOfItem > 0) {
      ++counter;
      if (counter == discountIndex) {
        price = price + actualPrice - discountPrice;
        counter = 0;
      } else {
        price = price + actualPrice;
      }
      --numberOfItem;
    }
    return price;
  }
}
