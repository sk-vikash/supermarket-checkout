package com.supermarket.buzz.item;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.supermarket.buzz.bean.StockKeepingUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Item {

  public int itemPurchased = 0;
  public String itemDescription = null;

  public String getDescription() {
    return itemDescription;
  }

  public int totalItemPurchased() {
    return itemPurchased;
  }

  public int cost() throws FileNotFoundException {
    return 0;
  }

  /**
   * This Code is to read JSON data
   *
   * @return Map containing SKU data, where map of the key is Item name.
   * @throws FileNotFoundException Ref https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/#opencsv---convert-csv-file-to-object
   */
  public Map<String, StockKeepingUnit> getStockKeepingUnitDetails() throws FileNotFoundException {
    Map<String, StockKeepingUnit> stringListMap = null;
    Gson gson = new Gson();
    File directory = new File("src/main/resources/data.json");
    String fileName = directory.getAbsolutePath();
    Reader reader = new FileReader(fileName);
    List<StockKeepingUnit> stockKeepingUnitList = gson
        .fromJson(reader, new TypeToken<List<StockKeepingUnit>>() {
        }.getType());
    stringListMap = new HashMap<>();
    for (StockKeepingUnit stockKeepingUnits : stockKeepingUnitList) {
      stringListMap.put(stockKeepingUnits.getItemName(), stockKeepingUnits);
    }
    return stringListMap;
  }
}
