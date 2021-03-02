package com.supermarket.buzz;

import com.supermarket.buzz.utils.UserInput;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import org.junit.Test;


public class SkuClientTest {

  private ByteArrayInputStream byteArrayInputStream;

  private void provideInput(String data) {
    byteArrayInputStream = new ByteArrayInputStream(data.getBytes());
    System.setIn(byteArrayInputStream);
  }

  @Test
  public void givenUserPurchasedItemFromUnit() throws FileNotFoundException {
    UserInput userInput = new UserInput();
    String inputItemA = "A" + System.lineSeparator() + "3" + System.lineSeparator() + "no";
    provideInput(inputItemA);
    SkuClient.main(null);
  }

  @Test
  public void givenUserPurchasedItemB() throws FileNotFoundException {
    UserInput userInput = new UserInput();
    String inputItemB = "B" + System.lineSeparator() + "14" + System.lineSeparator() + "no";
    provideInput(inputItemB);
    SkuClient.main(null);
  }

  @Test
  public void givenUserPurchasedItemC() throws FileNotFoundException {
    UserInput userInput = new UserInput();
    String inputItemC = "C" + System.lineSeparator() + "2" + System.lineSeparator() + "no";
    provideInput(inputItemC);
    SkuClient.main(null);
  }

  @Test
  public void givenUserPurchasedItemD() throws FileNotFoundException {
    UserInput userInput = new UserInput();
    String inputItemD = "D" + System.lineSeparator() + "6" + System.lineSeparator() + "no";
    provideInput(inputItemD);
    SkuClient.main(null);
  }
}