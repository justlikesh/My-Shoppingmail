package com.apple8._shop.item;

import com.apple8._shop.member.Member;
import com.apple8._shop.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final MemberRepository memberRepository;

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
    String detail(@PathVariable Integer id, Model model) {
//        throw new Exception();

        Optional<Item> result = itemRepository.findById(id);     // id가 1인 행을 찾아온다
        if(result.isPresent()){                                 // result 가 비어있을수도있으니 isPresent 로 예외처리 꼭해주기 !!!
            model.addAttribute("data", result.get());
            return "detail";
        } else {
            return "redirect://list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Integer id, Model model){

        Optional<Item> result = itemRepository.findById(id);          //optional 이기때문에 item 또는 텅 빈값이 나올수 있따.
        if (result.isPresent()){
            model.addAttribute("data", result.get());
            return "edit";
        } else {
            return "redirect://list";
        }
    }

    @PostMapping("/edit")
    String editItem(@RequestParam String title,
                    @RequestParam Integer price,
                    @RequestParam Integer id){
        Item item = new Item();                  // 서버가 모르는 정보는 유저에게 보내라고하거나, DB조회해보거나
        item.setId(id);                            //id가 1인 값이 없으면 새로만들어주고 있으면 이값들로 수정해준다
        item.setTitle(title);                    // jpa 의 대표적인 방법
        item.setPrice(price);
        itemRepository.save(item);

        return "redirect:/list";
    }

    @PostMapping("/test1")
    String test1(@RequestBody Map<String, Object> body){
        System.out.println(body);
        return "redirect:/list";
    }

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Integer id){
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");    //ajax 로 데이터 주고받을때는 redirect 가 안된다
    }

    @GetMapping("/test2")
    String deleteItem(){
        var result = new BCryptPasswordEncoder().encode("문자~~");    // 랜덤문자로 저장해서 변환하는것을 해싱 이라고한다
        System.out.println(result);
        return "redirect:/list";
    }

    @GetMapping("/list/page/{abc}")
    String getListPage(Model model, @PathVariable Integer abc){
        Page<Item> result = itemRepository.findPageBy(PageRequest.of(abc-1,5));  // 몇번째 페이지, 페이지당 몇개 페이지는 0부터 시작
        model.addAttribute("items", result);

        return "list";
    }

//    @GetMapping("/list/page/2")
//    String getListPage2(Model model){
//        Page<Item> result = itemRepository.findPageBy(PageRequest.of(1,5));  // 몇번째 페이지, 페이지당 몇개 페이지는 0부터 시작
//        model.addAttribute("items", result);
//
//        return "list";
//    }







}