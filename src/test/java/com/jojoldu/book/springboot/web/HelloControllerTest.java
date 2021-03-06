package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)    // ①
@WebMvcTest(controllers = HelloController.class)    // ②
public class HelloControllerTest {

    @Autowired  // ③
    private MockMvc mvc;    // ④

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))  // ⑤
                .andExpect(status().isOk())   // ⑥
                .andExpect(content().string(hello));    //⑦
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                    .param("name", name)    // ⑧
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    // ⑨
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}

/*
① @RunWith(SpringRunner.class)
- 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
- 여기서는 SpringRunner라는 스프링 실행자를 사용함
- 스프링 부트 테스트와 JUnit 사이에 연결자 역할
- JUnit : 자바 프로그래밍 언어용 유닛 테스트 프레임워크 

② @WebMvcTest
- 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
- 선언할 경우 @Controller. @ControllerAdvice 등을 사용할 수 있음
- @Service, @Component, @Repository 등은 사용 불가
- 여기서는 컨트롤러만 사용하기 때문에 선언함

③ Autowired
- 스프링이 관리하는 빈을 주입 받는다.

④ private MockMvc mvc
- 웹 API를 테스할 때 사용함
- 스프링 MVC 테스트의 시작점
- 이 클래스를 통해 HTTP, GET, POST 등에 대한 API 테스트가 가능함

⑤ mvc.perform(get("/hello"))
- MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
- 체이닝이 지원되어 아래와 같이 여러 검증을 이어서 선언할 수 있다.

⑥ .andExpect(status().isOk())
- mvc.perform의 결과를 검증한다.
- HTTP Header의 Status를 검증한다.
- 200, 400 등의 상태를 검증함
- 여기선 OK 즉, 200인지를 검증함

⑦ .andExpect(content().string(hello));
- mvc.perform의 결과를 검증한다.
- 응답 본문의 내용을 검증한다.
- Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.

⑧ param
- API 테스트할 때 사용될 파라미터를 설정한다.
- 단, 값은 String만 허용됨
- 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능함

⑨ jsonPath
- JSON 응답값을 필드별로 검증할 수 있는 메소드
- $를 기준으로 필드명을 명시함
- 여기서는 name과 amount를 검증하니 $.name, $.amount로 검증함
 */

