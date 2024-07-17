package com.pb.cheapKart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.cheapKart.DAL.ItemRepository;
import com.pb.cheapKart.Entity.Item;

import jakarta.transaction.Transactional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    
    public Item getItemByID(int id) {
        return itemRepository.findById(id).get();
    }

    @Transactional
    public void createItem(Item item) {

        itemRepository.save(item);
    
    }

    @Transactional
    public boolean updateItem(Integer id, Item newItem) {
        return itemRepository.findById(id).map(item -> {
            item.setName(newItem.getName());
            item.setDescription(newItem.getDescription());
            // Set other fields you want to update based on newItem
            itemRepository.save(item);
            return true;
        }).orElse(false);
    }

    @Transactional
    public void deleteItem(int id) {
        
        itemRepository.deleteById(id);        
    
    }

    public List<Item> getAllItems() {

        List<Item> itemList = new ArrayList<>();
        itemRepository.findAll().forEach(item -> itemList.add(item));
        return itemList;
    
    }



    

}
