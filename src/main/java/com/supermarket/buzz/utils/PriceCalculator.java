package com.supermarket.buzz.utils;

import com.supermarket.buzz.item.Item;
import com.supermarket.buzz.item.ItemA;
import com.supermarket.buzz.item.ItemB;
import com.supermarket.buzz.item.ItemC;
import com.supermarket.buzz.item.ItemD;
import com.supermarket.buzz.offer.Offer;
import java.io.FileNotFoundException;
import java.util.Map;

public class PriceCalculator {

  public int aggregateTotalPriceOfItem() throws FileNotFoundException {
    UserInput userInput = new UserInput();
    Map<String, Integer> items = userInput.acceptUserInput(); //this line get stuck
    int total_bill = 0;
    if (items.get("A") != null) {
      Item itemA = new ItemA(items.get("A").intValue());
      itemA = new Offer(itemA);
      System.out.println("A cost = " + itemA.cost());
      total_bill = itemA.cost();
    }

    if (items.get("B") != null) {
      Item itemB = new ItemB(items.get("B").intValue());
      itemB = new Offer(itemB);
      System.out.println("B Cost = " + itemB.cost());
      total_bill = total_bill + itemB.cost();
    }

    if (items.get("C") != null) {
      Item itemC = new ItemC(items.get("C").intValue());
      itemC = new Offer(itemC);
      System.out.println("C cost = " + itemC.cost());
      total_bill = total_bill + itemC.cost();
    }

    if (items.get("D") != null) {
      Item itemD = new ItemD(items.get("D").intValue());
      itemD = new Offer(itemD);
      System.out.println("D cost = " + itemD.cost());
      total_bill = total_bill + itemD.cost();
    }
    return total_bill;
  }
}
