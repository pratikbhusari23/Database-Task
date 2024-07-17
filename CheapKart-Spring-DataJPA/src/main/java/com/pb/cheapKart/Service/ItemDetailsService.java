package com.pb.cheapKart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.cheapKart.DAL.ItemDetailsRepository;
import com.pb.cheapKart.Entity.ItemDetails;

@Service
public class ItemDetailsService {

    @Autowired
    ItemDetailsRepository itemDetailsRepository;

    public void deleteItemDetails(int id) {
        
        itemDetailsRepository.deleteById(id);
    }

    public List<ItemDetails> getItemDetailsForPrice(double price) {
    
        return itemDetailsRepository.findByPriceGreaterThan(price);
    }

    public List<ItemDetails> getItemDetailsForCategory(String category) {
        
        return itemDetailsRepository.findByCategoryOrderByPrice(category);
    
    }
    
}
