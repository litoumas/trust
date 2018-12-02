package com.trust.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.model.Item;
import com.trust.app.service.ItemService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "ItemBean")
@ViewScoped
public class ItemBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5784179662988612898L;

	@ManagedProperty("#{itemService}")
	@Getter
	@Setter
	private ItemService itemService;
	
	List<Item> items;
	
	
	public List<Item> getListItems() {
		if(items==null)
		{
			items=itemService.listItems();
		}
		return items;
	}
	
}
