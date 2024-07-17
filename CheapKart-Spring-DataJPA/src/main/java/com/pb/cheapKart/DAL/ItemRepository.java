package com.pb.cheapKart.DAL;

import org.springframework.data.repository.CrudRepository;

import com.pb.cheapKart.Entity.Item;

public interface ItemRepository extends CrudRepository<Item,Integer> {


} 
