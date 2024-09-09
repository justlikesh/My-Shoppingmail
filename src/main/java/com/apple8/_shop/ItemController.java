package com.apple8._shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")                //list 요청이들어오면 GET메서드
    String list(Model model){        //model 접시에 담아서

        List<Item> result = itemRepository.findAll();   //이테이블의 모든행을 가져와서 리스트에 담아준다
        System.out.println(result);

        model.addAttribute("items",result); //전달할 데이터 이름, 데이터
        var a = new Item();
        System.out.print(a.toString());
        return "list";
    }

    @GetMapping("/write")
    String write(){
        return "write";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title,
                   @RequestParam Integer price)  {
//        new ItemService().saveItem(title, price);       이런식으로 매번 api 요청마다 객체를 만들면 메모리적으로 비효율 적이다
        itemService.saveItem(title, price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model) throws Exception{
        throw new Exception();

//        Optional<Item> result = itemRepository.findById(id);     // id가 1인 행을 찾아온다
//        if(result.isPresent()){                                 // result 가 비어있을수도있으니 isPresent 로 예외처리 꼭해주기 !!!
//            model.addAttribute("data", result.get());
//            return "detail";
//        } else {
//            return "redirect://list";
//        }
    }
}