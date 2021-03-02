package com.supermarket.buzz;


import com.supermarket.buzz.utils.PriceCalculator;
import java.io.FileNotFoundException;

public class SkuClient {

  public static void main(String[] args) throws FileNotFoundException {
    PriceCalculator priceCalculator = new PriceCalculator();
    System.out.println("Total Bill = " + priceCalculator.aggregateTotalPriceOfItem());
  }

}
