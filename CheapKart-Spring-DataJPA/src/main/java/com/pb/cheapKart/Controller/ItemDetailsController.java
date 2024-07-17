package com.pb.cheapKart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.cheapKart.Entity.ItemDetails;
import com.pb.cheapKart.Service.ItemDetailsService;

@RestController
@RequestMapping("/itemDetails")
public class ItemDetailsController {
    
    @Autowired
    ItemDetailsService itemDetailsService;

    @DeleteMapping("/id/{id}")
    public String deleteItemDetails(@PathVariable int id) {

        itemDetailsService.deleteItemDetails(id);   
        return "Item details deleted Successfully for id: "+id+"!";
    }

    @GetMapping("/price/{price}")
    
    public List<ItemDetails> getItemDetailsForPriceGreaterThan(@PathVariable double price) {

        return itemDetailsService.getItemDetailsForPrice(price);
        
    }

    @GetMapping("/category/{category}")
    public List<ItemDetails> getItemDetailsForCategory(@PathVariable String category) {
    
        return itemDetailsService.getItemDetailsForCategory(category);
    }
}
