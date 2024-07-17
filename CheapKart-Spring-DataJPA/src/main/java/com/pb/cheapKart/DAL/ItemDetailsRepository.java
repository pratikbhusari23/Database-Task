package com.pb.cheapKart.DAL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pb.cheapKart.Entity.ItemDetails;

public interface ItemDetailsRepository extends JpaRepository<ItemDetails,Integer> {


    List<ItemDetails> findByPriceGreaterThan(double price);

    @Query("Select itd from ItemDetails itd where itd.category =?1 order by itd.price desc")
    List<ItemDetails> findByCategoryOrderByPrice(String category);
    
} 