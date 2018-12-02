package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Item;

public interface ItemService {
	
	public void addItem(Item c);
    public List<Item> listItems();
    public void deleteItem(Item c);
    public void updateItem(Item c);
    public void testLog();
}
