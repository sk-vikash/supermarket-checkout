package com.supermarket.buzz.offer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.supermarket.buzz.item.Item;
import com.supermarket.buzz.item.ItemA;
import com.supermarket.buzz.item.ItemB;
import com.supermarket.buzz.item.ItemC;
import com.supermarket.buzz.item.ItemD;
import java.io.FileNotFoundException;
import org.junit.Test;

public class OfferTest {

  @Test
  public void givenItemAIsPurchasedWhenDiscountIsAppliedOnTheItem() throws FileNotFoundException {
    Item item = new ItemA(4);
    Offer offer = new Offer(item);
    assertThat("The price of Item purchased A should match and discount should be applied",
        offer.cost(), is(
            equalTo(180)));
  }

  @Test
  public void givenItemBIsPurchasedWhenDiscountIsAppliedOnTheItem() throws FileNotFoundException {
    Item item = new ItemB(3);
    Offer offer = new Offer(item);
    assertThat("The price of Item purchased B should match and discount should be applied",
        offer.cost(), is(
            equalTo(75)));
  }

  @Test
  public void givenItemCIsPurchasedWhenDiscountIsNotAppliedOnTheItem()
      throws FileNotFoundException {
    Item item = new ItemC(5);
    Offer offer = new Offer(item);
    assertThat("The price of Item purchased C should match and no discount applied",
        offer.cost(), is(equalTo(
            100)));
  }

  @Test
  public void givenItemDIsPurchasedWhenDiscountIsNotAppliedOnTheItem()
      throws FileNotFoundException {
    Item item = new ItemD(6);
    Offer offer = new Offer(item);
    System.out.println("offer.cost() = " + offer.cost());
    assertThat("The price of Item purchased D should match and no discount applied",
        offer.cost(), is(
            equalTo(90)));
  }
}