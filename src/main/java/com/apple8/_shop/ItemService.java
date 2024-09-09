package com.apple8._shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {                      // 비즈니스 로직을 담는 클래스는 Service 라고 부른다

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){

        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }


}
