package com.example.shoping.controller;

import java.util.*;
import com.example.shoping.dto.ItemsDto;
import com.example.shoping.dto.UserDto;
import com.example.shoping.entities.User;
import com.example.shoping.repositories.UserRepository;
import com.example.shoping.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("api/items")
public class ItemsController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/")
    public ResponseEntity<ItemsDto> createItem(@RequestBody ItemsDto itemsDto){
        ItemsDto itemsDto1=this.itemService.createItem(itemsDto);
        return ResponseEntity.ok(itemsDto1);
    }
    @PutMapping("/stock/{itemId}/quantity/{quantity}")
    public ResponseEntity<ItemsDto> updateStockItem(@PathVariable Integer itemId, @PathVariable Integer quantity){
        ItemsDto itemsDto1=this.itemService.updateStock(quantity,itemId);
        return ResponseEntity.ok(itemsDto1);
    }
    @PutMapping("/{itemId}")
    public ResponseEntity<ItemsDto> updateItem(@PathVariable Integer itemId,@RequestBody ItemsDto itemsDto ){
        ItemsDto itemsDto1=this.itemService.updateItem(itemId,itemsDto);
        return ResponseEntity.ok(itemsDto1);
    }
    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Integer itemId){
        this.itemService.deleteItemById(itemId);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/")
    public ResponseEntity<List<ItemsDto>> getAllItems(){
        return ResponseEntity.ok(this.itemService.getAllItems());
    }
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable Integer itemId){
        return ResponseEntity.ok(this.itemService.getItemById(itemId));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ItemsDto>> getItemsofUser(@PathVariable String userId){
        User user=this.userRepository.findById(userId).orElseThrow();
        return ResponseEntity.ok(this.itemService.getAllItemsByUser(user));
    }
}
