package com.apple8._shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity              // 영속적으로 저장되고 관리되는 객체를 가리킨다
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)    //알아서 id 증가 시켜준다
    private Integer id;

//    @Column(nullable = false)   //@Column()으로 컬럼에 제약설정 가능 외우지말고 필요하면 찾아쓰자
    private String title;        //title 이라는 세로줄(컬럼) 을 추가한것
    private Integer price;
}
