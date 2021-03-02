package com.supermarket.buzz.utils;

public class SpecialOfferCalculator {

  public int calculatePriceOfItem(int numberOfItem, int actualPrice, int discountIndex,
      int discountPrice) {

    int sum = 0;
    int counter = 0;

    while (numberOfItem > 0) {
      ++counter;
      if (counter == discountIndex) {
        sum = sum + actualPrice - discountPrice;
        counter = 0;
      } else {
        sum = sum + actualPrice;
      }
      --numberOfItem;
    }
    return sum;
  }
}
