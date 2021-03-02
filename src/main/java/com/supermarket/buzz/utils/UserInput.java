package com.supermarket.buzz.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInput {

  public Map<String, Integer> acceptUserInput() {
    Map<String, Integer> items = new HashMap<String, Integer>();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Enter item you want to buy A, B, C, or D : ");
      String item = scanner.next();
      item = item.toUpperCase();
//      if (!isValidItem(item)) {
//        System.out.println("Invalid input ... Try again ... ");
//        continue;
//      } else {
//        item = item.toUpperCase();
//      }
      System.out.print("How many " + item + " you want to buy : ");
      String numberOfItemsEntered = scanner.next();
      int numberOfItems;
      if (!isNumeric(numberOfItemsEntered)) {
        System.out.println("Invalid input ... Try again ... ");
        continue;
      } else {
        numberOfItems = Integer.valueOf(numberOfItemsEntered);
      }
      System.out.println("items.get(item) = " + items.get(item));
      if (items.get(item) != null) {
        items.put(item, items.get(item).intValue() + numberOfItems);
      } else {
        items.put(item, numberOfItems);
      }
      System.out.println("As of now you have --- ");
      items.forEach((k, v) -> System.out.println("Item : " + k + ", taken : " + v));

      System.out.print("You want to add more item Yes/No ");
      String flag = scanner.next();
      if (!isValidInput(flag)) {
        System.out.println("Invalid input ... Try again ... ");
        continue;
      }
      if (flag.equalsIgnoreCase("No")) {
        break;
      }
    }
    return items;
  }

  protected boolean isNumeric(String str) {
    return (str == null || str.length() == 0) ? false : str.chars().allMatch(Character::isDigit);
  }

//  protected boolean isValidItem(String str) {
//    return (str != null && !str.trim().isEmpty()) ? true : false;
//  }

  protected boolean isValidInput(String str) {
    boolean flag;
    if (str == null || str.trim().isEmpty()
        || (!str.equalsIgnoreCase("Yes")
        && !str.equalsIgnoreCase("No"))) {
      flag = false;
    } else {
      flag = true;
    }
    return flag;
  }
}
