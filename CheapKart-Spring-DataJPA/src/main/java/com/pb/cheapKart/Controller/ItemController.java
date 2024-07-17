package com.pb.cheapKart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.cheapKart.Entity.Item;
import com.pb.cheapKart.Service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
    
    @Autowired
    ItemService itemService;

    @GetMapping("/id/{id}")
    public Item getItemByID(@PathVariable int id) {
        
        return itemService.getItemByID(id);    
    }

    @PostMapping("/post")
    public void createItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Integer id, @RequestBody Item item) {
    boolean updated = itemService.updateItem(id, item);
        if (updated) {
            return ResponseEntity.ok("Item updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
    

}
