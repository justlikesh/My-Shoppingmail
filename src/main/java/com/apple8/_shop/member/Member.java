package com.apple8._shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // id 값이 하나씩 증가
    private Integer id;

    @Column(unique = true)    // 중복 허용 X
    private String username;
    private String displayName;
    private String password;
}
