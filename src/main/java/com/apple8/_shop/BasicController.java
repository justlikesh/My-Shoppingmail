package com.apple8._shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Controller  // 요리사 라는 뜻
public class BasicController {
    @RequestMapping(value = "/dd", method = RequestMethod.GET)
    String hello(){
        return "index";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "피싱사이트에요";
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    @ResponseBody
    String date() {
        return LocalDateTime.now().toString();
    }


}
