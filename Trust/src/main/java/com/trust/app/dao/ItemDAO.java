package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Item;

public interface ItemDAO {
	public void addItem(Item p);
    public List<Item> listItems();
    public void deleteItem(Item item);
    public void updateItem(Item item);
}
