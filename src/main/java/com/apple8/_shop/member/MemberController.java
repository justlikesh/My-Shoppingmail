package com.apple8._shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;      // 남이 만든 클래스의 객체를 DI로 쓰고시으면 @Bean 으로 쓰기

    @GetMapping("/register")
    String register(){
        return "register";
    }

    @PostMapping("/member")
    String addMember(@RequestParam String username,
                     @RequestParam String password,
                     @RequestParam String displayName){
        Member member = new Member();
        member.setUsername(username);
        String hash = passwordEncoder.encode(password);  //password 해싱
        member.setPassword(hash);
        member.setDisplayName(displayName);
        memberRepository.save(member);  //save() 메소드는 새로운 엔티티를 저장하거나, 기존 엔티티를 업데이트하는 작업을 수행합니다.
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login(){
        var result = memberRepository.findAllByUsername("sdf");
        System.out.println(result.get().getDisplayName());
        return "login";
    }
}
