package com.devofure.ch;

import com.devofure.ch.list.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class SourceContent {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Map<String, Item> ITEM_MAP = new HashMap<>();

    static {
            addItem("0", new Item("List and items", "different type of list and items"));
            addItem("1", new Item("Tabs", "tabs examples"));
    }

    private static void addItem(String id, Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(id, item);
    }
}
