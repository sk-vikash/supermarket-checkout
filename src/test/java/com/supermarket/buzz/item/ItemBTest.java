package com.supermarket.buzz.item;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ItemBTest {

  ItemB itemB = new ItemB(15);

  @Test
  public void givenNumberOfItemBPurchasedByUserThenSameNumberOfItemShouldBeAdded() {
    assertThat("The number of Item B purchased should match",
        itemB.itemPurchased, is(
            equalTo(15)));
  }

  @Test
  public void givenDifferentItemsInTheUnitItemBShouldHaveInitialCostSetToZeroWhenThereWasNoPurchase()
      throws FileNotFoundException {
    assertThat("The initial Item B cost should be set to zero when there is no purchase ",
        itemB.cost(), is(
            equalTo(0)));
  }
}