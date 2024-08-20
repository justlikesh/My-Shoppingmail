package com.apple8._shop.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{

    Page<Item> findPageBy(Pageable page);  // 이 테이블에서 X개만 가져오는 함수

}
