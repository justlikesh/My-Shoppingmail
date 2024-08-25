package com.apple8._shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity     // 이두개의 어노테이션을 붙이면 스프링 시큐리티의 설정을 만질수 잇다.
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();        // 스프링이 가져가서 Bean 으로 만들어줌
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    //어떤 페이지를 로그인 검사할지 설정가능
        http.csrf((csrf)-> csrf.disable());           //csrf = 다른 사이트에서도 우리의 api 요청을 받을수있다  이걸방지하는게 csrf.disable() 옵션
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()       // 로그인 여부 상관없이 항상 허용,    ** = 모든 url
        );
        return http.build();
    }
}
