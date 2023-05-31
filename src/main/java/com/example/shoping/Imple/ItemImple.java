package com.example.shoping.Imple;

import com.example.shoping.dto.ItemsDto;
import com.example.shoping.entities.Items;
import com.example.shoping.entities.User;
import com.example.shoping.repositories.ItemRepository;
import com.example.shoping.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemImple implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ItemsDto createItem(ItemsDto itemsDto) {
        Items items=this.modelMapper.map(itemsDto, Items.class);
        Items createdItem=this.itemRepository.save(items);
        return this.modelMapper.map(createdItem,ItemsDto.class);

    }

    @Override
    public ItemsDto updateStock(Integer quantity, Integer itemId) {
        Items items=this.itemRepository.findById(itemId).orElseThrow();
        items.setStockQuantity(quantity);
        Items newItem=this.itemRepository.save(items);
        return this.modelMapper.map(newItem,ItemsDto.class);
    }

    @Override
    public ItemsDto updateItem(Integer itemId, ItemsDto itemsDto) {
        Items items=this.itemRepository.findById(itemId).orElseThrow();
        items.setStockQuantity(itemsDto.getStockQuantity());
        items.setName(itemsDto.getName());
        items.setDescription(itemsDto.getDescription());
        Items newItem=this.itemRepository.save(items);
        return this.modelMapper.map(newItem,ItemsDto.class);
    }

    @Override
    public void deleteItemById(Integer itemId) {
        Items items=this.itemRepository.findById(itemId).orElseThrow();
        this.itemRepository.delete(items);
    }

    @Override
    public ItemsDto getItemById(Integer itemId) {
        Items items=this.itemRepository.findById(itemId).orElseThrow();
        return this.modelMapper.map(itemId,ItemsDto.class);
    }

    @Override
    public List<ItemsDto> getAllItems() {
        List<Items> items=this.itemRepository.findAll();
        List<ItemsDto> itemsDtos=items.stream().map((item)->this.modelMapper.map(item,ItemsDto.class)).collect(Collectors.toList());
        return itemsDtos;
    }

    @Override
    public List<ItemsDto> getAllItemsByUser(User user) {
        List<Items> items=this.itemRepository.findByUser(user);
        List<ItemsDto> itemsDtos=items.stream().map((item)->this.modelMapper.map(item,ItemsDto.class)).collect(Collectors.toList());
        return itemsDtos;
    }
}
