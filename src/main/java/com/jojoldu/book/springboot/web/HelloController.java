package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON으로 반환하는 컨트톨러로 만들어줌.
//@ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌.
@RestController
public class HelloController {

    @GetMapping("/hello")   //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어줌.
    public String hello(){
        return "hello";
    }
}
