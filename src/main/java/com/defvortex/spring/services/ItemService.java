package com.defvortex.spring.services;

import com.defvortex.spring.entitys.Item;
import com.defvortex.spring.entitys.User;
import com.defvortex.spring.repositories.ItemRepository;
import com.defvortex.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public Item getById(Long id) {
        return itemRepository.getItemById(id);
    }

    public List<Item> getListOfItems() {
        return itemRepository.getListOfItems();
    }
}
