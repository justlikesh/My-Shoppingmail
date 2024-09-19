package com.apple8._shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list")                //list 요청이들어오면 GET메서드
    String list(Model model){        //model 접시에 담아서

        List<Item> result = itemRepository.findAll();   //이테이블의 모든행을 가져와서 리스트에 담아준다
        System.out.println(result);

        model.addAttribute("items",result); //전달할 데이터 이름, 데이터
        var a = new Item();
        System.out.print(a.toString());
        return "list";


    }
}
