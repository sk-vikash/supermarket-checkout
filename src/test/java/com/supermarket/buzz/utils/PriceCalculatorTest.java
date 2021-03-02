package com.supermarket.buzz.utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes=PriceCalculator.class)
public class PriceCalculatorTest {

  private ByteArrayInputStream byteArrayInputStream;

  private void provideInput(String data) {
    byteArrayInputStream = new ByteArrayInputStream(data.getBytes());
    System.setIn(byteArrayInputStream);
  }

  @Test
  public void gienWhenNoItemsArePurchasedThemAggregatedTotalPriceOfItem()
      throws FileNotFoundException {
    PriceCalculator priceCalculator = new PriceCalculator();

    String inputItem =
        "A" + System.lineSeparator() + "0" + System.lineSeparator() + "no";
    provideInput(inputItem);

    int price = priceCalculator.aggregateTotalPriceOfItem();

    assertThat("The item price when on no item is purchased",
        price, is(
            equalTo(0)));
  }

  @Test
  public void gienWhenSingleItemsArePurchasedThenAggregatedTotalPriceOfItem()
      throws FileNotFoundException {
    PriceCalculator priceCalculator = new PriceCalculator();

    String inputItem =
        "A" + System.lineSeparator() + "3" + System.lineSeparator() + "no";
    provideInput(inputItem);

    int price = priceCalculator.aggregateTotalPriceOfItem();

    assertThat("The item price when single item is purchased",
        price, is(
            equalTo(130)));
  }

  @Test
  public void gienWhenMlutipleItemsArePurchasedThenAggregatedTotalPriceOfItem()
      throws FileNotFoundException {
    PriceCalculator priceCalculator = new PriceCalculator();

    String inputItem =
        "A" + System.lineSeparator() + "3" + System.lineSeparator() + "yes" + System.lineSeparator()
            +
            "B" + System.lineSeparator() + "1" + System.lineSeparator() + "yes" + System
            .lineSeparator() +
            "C" + System.lineSeparator() + "2" + System.lineSeparator() + "yes" + System
            .lineSeparator() +
            "A" + System.lineSeparator() + "5" + System.lineSeparator() + "yes" + System
            .lineSeparator() +
            "D" + System.lineSeparator() + "9" + System.lineSeparator() + "no";
    provideInput(inputItem);

    int price = priceCalculator.aggregateTotalPriceOfItem();

    assertThat("The item price when multiple items are purchased",
        price, is(
            equalTo(565)));
  }

  @Test
  public void gienWhenMlutipleItemsArePurchasedAndFewItemsNotInTheUnitThenAggregatedTotalPriceOfItems()
      throws FileNotFoundException {
    PriceCalculator priceCalculator = new PriceCalculator();

    String inputItem =
        "F" + System.lineSeparator() + "3" + System.lineSeparator() + "yes" + System.lineSeparator()
            +
            "F" + System.lineSeparator() + "1" + System.lineSeparator() + "yes" + System
            .lineSeparator() +
            "X" + System.lineSeparator() + "2" + System.lineSeparator() + "yes" + System
            .lineSeparator() +
            "A" + System.lineSeparator() + "5" + System.lineSeparator() + "yes" + System
            .lineSeparator() +
            "D" + System.lineSeparator() + "9" + System.lineSeparator() + "no";
    provideInput(inputItem);

    int price = priceCalculator.aggregateTotalPriceOfItem();

    assertThat(
        "The item price when multiple items are purchased along with items not present in unit then ignore the unavaliable items from pricing",
        price, is(
            equalTo(365)));
  }
}