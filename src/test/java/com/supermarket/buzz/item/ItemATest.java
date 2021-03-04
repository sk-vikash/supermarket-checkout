package com.supermarket.buzz.item;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.supermarket.buzz.bean.StockKeepingUnit;
import java.io.FileNotFoundException;
import java.util.Map;
import org.junit.Test;

public class ItemATest {

  ItemA itemA = new ItemA(5);

  @Test
  public void givenNumberOfItemAPurchasedByUserThenSameNumberOfItemShouldBeAdded() {
    assertThat("The number of Item purchased A should match",
        itemA.itemPurchased, is(
            equalTo(5)));
  }

  @Test
  public void givenSuperMarketUnitDataInAJsonWhenLoadedToApplicationThenEnsureDataIsCorrectlyLoaded()
      throws FileNotFoundException {
    Map<String, StockKeepingUnit> stringStockKeepingUnitMap = itemA.getStockKeepingUnitDetails();
    stringStockKeepingUnitMap
        .forEach((k, v) -> System.out.println("Item TEST : " + k + ", taken TEST: " + v));
    assertThat("The actual price of Item A present in the unit ",
        stringStockKeepingUnitMap.get("A").getActualPrice(), is(
            equalTo(50)));
    assertThat("The number of item A eligible which is for discount",
        stringStockKeepingUnitMap.get("A").getNumberOfItemEligibleForDiscount(), is(
            equalTo(3)));
    assertThat("The discounted price of Item A present in the unit ",
        stringStockKeepingUnitMap.get("A").getActualPrice(), is(
            equalTo(50)));

    assertThat("The actual price of Item B present in the unit ",
        stringStockKeepingUnitMap.get("B").getActualPrice(), is(
            equalTo(30)));
    assertThat("The number of item B eligible which is for discount",
        stringStockKeepingUnitMap.get("B").getNumberOfItemEligibleForDiscount(), is(
            equalTo(2)));
    assertThat("The discounted price of Item B present in the unit ",
        stringStockKeepingUnitMap.get("B").getActualPrice(), is(
            equalTo(30)));

    assertThat("The actual price of Item C present in the unit ",
        stringStockKeepingUnitMap.get("C").getActualPrice(), is(
            equalTo(20)));
    assertThat("The number of item C eligible which is for discount",
        stringStockKeepingUnitMap.get("C").getNumberOfItemEligibleForDiscount(), is(
            equalTo(0)));
    assertThat("The discounted price of Item C present in the unit ",
        stringStockKeepingUnitMap.get("C").getActualPrice(), is(
            equalTo(20)));

    assertThat("The actual price of Item D present in the unit ",
        stringStockKeepingUnitMap.get("D").getActualPrice(), is(
            equalTo(15)));
    assertThat("The number of item D eligible which is for discount",
        stringStockKeepingUnitMap.get("D").getNumberOfItemEligibleForDiscount(), is(
            equalTo(0)));
    assertThat("The discounted price of Item D present in the unit ",
        stringStockKeepingUnitMap.get("D").getActualPrice(), is(
            equalTo(15)));
  }

  @Test
  public void givenDifferentItemsInTheUnitItemAShouldHaveInitialCostSetToZeroWhenThereWasNoPurchase()
      throws FileNotFoundException {
    assertThat("The initial Item A cost should be set to zero when there is no purchase ",
        itemA.cost(), is(
            equalTo(0)));
  }
}