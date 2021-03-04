package com.supermarket.buzz.bean;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StockKeepingUnitTest {

  StockKeepingUnit stockKeepingUnit = new StockKeepingUnit();

  @Before
  public void setUp() {
    stockKeepingUnit = new StockKeepingUnit();
    stockKeepingUnit.setItemName("A");
    stockKeepingUnit.setActualPrice(30);
    stockKeepingUnit.setNumberOfItemEligibleForDiscount(3);
    stockKeepingUnit.setDiscountedPrice(70);
  }

  @Test
  public void givenStockKeepingUnitBeanWhenReferncedThenBeanShouldReturnCorrectDetails() {
    assertThat("The Item present in the unit",
        stockKeepingUnit.getItemName(), is(
            equalTo("A")));
    assertThat("The Item present in the unit has actual price",
        stockKeepingUnit.getActualPrice(), is(
            equalTo(30)));
    assertThat("The Item present in the unit is eligible for discount when",
        stockKeepingUnit.getNumberOfItemEligibleForDiscount(), is(
            equalTo(3)));
    assertThat("The Item present in the unit has a discount price",
        stockKeepingUnit.getDiscountedPrice(), is(
            equalTo(20)));
  }

  @Test
  public void givenStockKeepingUnitBeanWhenReferencedThenBeanShouldDisplayCorrectInfromationOfUnit() {
    assertThat("The stock unit Item detail matches",
        stockKeepingUnit.toString(), is(
            equalTo(
                "StockKeepingUnit(itemName=A, actualPrice=30, numberOfItemEligibleForDiscount=3, discountedPrice=20)")));
  }
}