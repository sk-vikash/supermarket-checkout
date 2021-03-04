package com.supermarket.buzz.item;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ItemCTest {

  ItemC itemC = new ItemC(6);

  @Test
  public void givenNumberOfItemCPurchasedByUserThenSameNumberOfItemShouldBeAdded() {
    assertThat("The number of Item C purchased should match",
        itemC.itemPurchased, is(
            equalTo(6)));
  }

  @Test
  public void givenDifferentItemsInTheUnitItemCShouldHaveInitialCostSetToZeroWhenThereWasNoPurchase()
      throws FileNotFoundException {
    assertThat("The initial Item C cost should be set to zero when there is no purchase ",
        itemC.cost(), is(
            equalTo(0)));
  }
}