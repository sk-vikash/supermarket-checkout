package com.supermarket.buzz.utils;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Map;
import org.junit.Test;

public class UserInputTest {

  private ByteArrayInputStream byteArrayInputStream;

  private void provideInput(String data) {
    byteArrayInputStream = new ByteArrayInputStream(data.getBytes());
    System.setIn(byteArrayInputStream);
  }

  @Test
  public void givenUserHasToPurchaseItemFromUnitThenUserShouldBePromptedWithConsole() {
    UserInput userInput = new UserInput();
    String input = "A" + System.lineSeparator() + "3" + System.lineSeparator() + "No";

    provideInput(input);
    Map<String, Integer> acceptUserInputMap = userInput.acceptUserInput();
    assertThat("The entered user input should match",
        acceptUserInputMap.get("A"), is(equalTo(
            3)));
  }

  @Test
  public void givenUserHasToPurchaseMultipleItemFromUnitInAnyOrderThenUserShouldBePromptedWithConsole() {
    UserInput userInput = new UserInput();
    String input = "A" + System.lineSeparator() + "3" + System.lineSeparator() + "Yes"
        + System.lineSeparator() + "B" + System.lineSeparator() + "2" + System.lineSeparator()
        + "Yes"
        + System.lineSeparator() + "C" + System.lineSeparator() + "3" + System.lineSeparator()
        + "Yes"
        + System.lineSeparator() + "A" + System.lineSeparator() + "6" + System.lineSeparator()
        + "Yes"
        + System.lineSeparator() + "D" + System.lineSeparator() + "5" + System.lineSeparator()
        + "Yes"
        + System.lineSeparator() + "B" + System.lineSeparator() + "8" + System.lineSeparator()
        + "No";

    provideInput(input);

    Map<String, Integer> acceptUserInputMap = userInput.acceptUserInput();
    assertThat("The entered user input item A should match with actual",
        acceptUserInputMap.get("A"), is(
            equalTo(9)));

    assertThat("The entered user input item B should match with actual",
        acceptUserInputMap.get("B"), is(
            equalTo(10)));

    assertThat("The entered user input item C should match with actual",
        acceptUserInputMap.get("C"), is(
            equalTo(3)));

    assertThat("The entered user input item D should match with actual",
        acceptUserInputMap.get("D"), is(
            equalTo(5)));
  }


  @Test
  public void givenUserHasToPurchaseItemFromUnitThenUserEnteredInCorrectNumberOfItemFromConsole() {
    UserInput userInput = new UserInput();
    String input = "A" + System.lineSeparator() + "S45D" + System.lineSeparator() +
        "A" + System.lineSeparator() + "2" + System.lineSeparator() + "No";

    provideInput(input);
    Map<String, Integer> acceptUserInputMap = userInput.acceptUserInput();
    assertThat("The entered invalid number of item",
        acceptUserInputMap.get("A"), is(
            equalTo(2)));
  }

  @Test
  public void givenUserHasToPurchaseItemFromUnitThenUserEnteredInCorrectItem() {
    UserInput userInput = new UserInput();
    String input = "" + System.lineSeparator() +
        "D" + System.lineSeparator() + "4" + System.lineSeparator() + "No";

    provideInput(input);
    Map<String, Integer> acceptUserInputMap = userInput.acceptUserInput();
    assertThat(
        "The user entered invalid item then application should user re-enter the item correctly",
        acceptUserInputMap.get("D"), is(
            equalTo(4)));
  }

  @Test
  public void givenUserHasToPurchaseItemFromUnitThenUserEnteredInCorrectOptionToPurchaseAnotherItemFromConsole() {
    UserInput userInput = new UserInput();
    String input = "B" + System.lineSeparator() + "2" + System.lineSeparator() + "X3%$"
        + System.lineSeparator() + "B" + System.lineSeparator() + "8" + System.lineSeparator()
        + "No";

    provideInput(input);
    Map<String, Integer> acceptUserInputMap = userInput.acceptUserInput();
    assertThat("The entered user input should match with the item entered",
        acceptUserInputMap.get("B"), is(
            equalTo(10)));
  }


  @Test
  public void givenAInputFromConsoleThenCheckIfEnteredNumberOfItemDaetailsIsCorrectOrNot() {
    UserInput userInput = new UserInput();
    assertThat("The entered user input for number of item should be valid if it is number",
        userInput.isNumeric("A"), is(
            false));
    assertThat("The entered user input should match with the item entered",
        userInput.isNumeric("1"), is(
            true));
    assertThat("The entered user input should match with the item entered",
        userInput.isNumeric(" "), is(
            false));
    assertThat("The entered user input should match with the item entered",
        userInput.isNumeric(null), is(
            false));
  }

  @Test
  public void givenAInputFromConsoleThenCheckIfEnteredDetailsIsEitherYesOrNo() {
    UserInput userInput = new UserInput();
    assertThat("The entered user input for number of item should be valid if it is number",
        userInput.isValidInput("Yes"), is(
            true));
    assertThat("The entered user input should match with the item entered",
        userInput.isValidInput("yEs"), is(
            true));
    assertThat("The entered user input should match with the item entered",
        userInput.isValidInput("No"), is(
            true));
    assertThat("The entered user input should match with the item entered",
        userInput.isValidInput(null), is(
            false));
    assertThat("The entered user input should match with the item entered",
        userInput.isValidInput("null"), is(
            false));
    assertThat("The entered user input should match with the item entered",
        userInput.isValidInput("X5R"), is(
            false));
  }
}