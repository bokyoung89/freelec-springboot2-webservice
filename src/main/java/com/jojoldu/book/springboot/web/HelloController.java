package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON으로 반환하는 컨트톨러로 만들어줌.
//@ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌.
@RestController
public class HelloController {

    @GetMapping("/hello")   //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어줌.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // ①
                                     @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);
    }
}

/*
* ①RequestParam
* - 외부에서 API를 넘긴 파라미터를 가져오는 어노테이션
* - 여기서는 외부에서 name (@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에
*   저장하게 된다.
*/