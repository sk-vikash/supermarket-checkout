package com.supermarket.buzz.item;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ItemATest {

  ItemA itemA = new ItemA(5);

  @Test
  public void givenNumberOfItemPurchasedFromByUserThenSameNumberOfItemShouldBeAdded() {
    assertThat("The number of Item purchased A should match",
        itemA.itemPurchased, is(
            equalTo(5)));
  }

  @Test
  public void givenDifferentItemsInTheUnitItemAShouldHaveInitialCostSetToZeroWhenThereWasNoPurchase()
      throws FileNotFoundException {
    assertThat("The initial Item A cost should be set to zero when there is no purchase ",
        itemA.cost(), is(
            equalTo(0)));
  }
}