package com.supermarket.buzz.utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecialOfferCalculatorTest {

  @Test
  public void givenDiscountOnItemWhenMultipleItemIsPurchasedThenDiscountedPriceShouldBeApplied() {
    SpecialOfferCalculator specialOfferCalculator = new SpecialOfferCalculator();
    int price = specialOfferCalculator.calculatePriceOfItem(10, 100, 3, 200);
    assertThat("The item price when discount is applied on multiple purchase",
        price, is(
            equalTo(400)));
  }

  @Test
  public void givenNoDiscountOnItemWhenMultipleItemIsPurchasedThenAcutalShouldBeApplied() {
    SpecialOfferCalculator specialOfferCalculator = new SpecialOfferCalculator();
    int price = specialOfferCalculator.calculatePriceOfItem(10, 100, 0, 0);
    assertThat("The item price when NO discount is given on multiple purchase",
        price, is(
            equalTo(1000)));
  }
}