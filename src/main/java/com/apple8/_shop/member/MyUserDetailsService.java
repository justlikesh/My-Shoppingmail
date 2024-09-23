package com.apple8._shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            DB에서 username을 가진 유저를 찾아와서
//            return new User(유저아이디, 비번, 권한) 해주세요
        var result = memberRepository.findAllByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("그런 아이디 없어용");
        }
        var user = result.get();
        List<GrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("일반유저"));
        return new User(user.getUsername(),user.getPassword(), authorities);
    }

}