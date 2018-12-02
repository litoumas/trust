package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.ItemDAO;
import com.trust.app.model.Item;


@Service
@ManagedBean(name = "itemService")
@SessionScoped
public class ItemServiceImpl implements ItemService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	private ItemDAO itemDAO;

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	@Transactional
	public void addItem(Item c) {
		this.itemDAO.addItem(c);
	}

	@Override
	@Transactional
	public List<Item> listItems() {
		return this.itemDAO.listItems();
	}

	@Override
	@Transactional
	public void deleteItem(Item c) {
		this.itemDAO.deleteItem(c);
	}

	@Override
	@Transactional
	public void updateItem(Item c) {
		this.itemDAO.updateItem(c);
	}

	@Override
	public void testLog() {
		
	}

}