package com.apple8._shop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findAllByUsername(String username);
            //Derived query methods
            //findAllByUsername 은 다찾아오기 findByUsername 하나만 찾아오기
            // Username 컬럼에 username 데이터가 들어있는 행을 찾아오는 함수
            // 못찾을 수 도 있으니까 Optional 로 데이터 타입 씌우기
}
