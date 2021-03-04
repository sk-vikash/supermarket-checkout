package com.supermarket.buzz.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInput {

  public Map<String, Integer> acceptUserInput() {
    Map<String, Integer> items = new HashMap<String, Integer>();
    Scanner scanner = new Scanner(System.in);
    boolean check = true;
    while (true) {
      System.out.print("Enter item you want to buy A, B, C, or D: ");
      String item = scanner.next();
      item = item.toUpperCase();
      System.out.print("How many " + item + " you want to buy: ");
      String numberOfItemsEntered = scanner.next();
      int numberOfItems;
      if (!isNumeric(numberOfItemsEntered)) {
        System.out.println("Invalid input ... Try again ... ");
        continue;
      } else {
        numberOfItems = Integer.valueOf(numberOfItemsEntered);
      }
      if (items.get(item) != null) {
        items.put(item, items.get(item).intValue() + numberOfItems);
      } else {
        items.put(item, numberOfItems);
      }
      System.out.println("\nAs of now you have --- ");
      items.forEach((k, v) -> System.out.println("Item : " + k + ", taken : " + v));
      System.out.println();
      while (true) {
        System.out.print("You want to add more item Yes/No: ");
        String flag = scanner.next();
        if (flag.equalsIgnoreCase("Yes")) {
          break;
        } else if (flag.equalsIgnoreCase("No")) {
          check = false;
          break;
        } else {
          System.out.println("Invalid input ... Try again ... ");
          continue;
        }
      }
      if (!check) {
        break;
      }
    }
    return items;
  }

  protected boolean isNumeric(String str) {
    return (str == null || str.length() == 0) ? false : str.chars().allMatch(Character::isDigit);
  }

}
