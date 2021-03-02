package com.supermarket.buzz.item;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ItemDTest {

  ItemD itemD = new ItemD(11);

  @Test
  public void givenNumberOfItemPurchasedFromByUserThenSameNumberOfItemShouldBeAdded() {
    assertThat("The number of Item purchased D should match",
        itemD.itemPurchased, is(
            equalTo(11)));
  }

  @Test
  public void givenDifferentItemsInTheUnitItemDShouldHaveInitialCostSetToZeroWhenThereWasNoPurchase()
      throws FileNotFoundException {
    assertThat("The initial Item D cost should be set to zero when there is no purchase ",
        itemD.cost(), is(
            equalTo(0)));
  }
}