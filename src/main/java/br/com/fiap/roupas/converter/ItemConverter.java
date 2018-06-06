package br.com.fiap.roupas.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.filter.ItemFilter;
import br.com.fiap.roupas.model.Item;

@Service
public class ItemConverter {

	public Item filterToEntity(ItemFilter itemFilter) {
		Item item = new Item();
		BeanUtils.copyProperties(itemFilter, item);
		return item;
	}
	
}
