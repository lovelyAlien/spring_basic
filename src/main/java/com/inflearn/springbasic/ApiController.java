package com.inflearn.springbasic;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {



    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloMvc(@RequestParam(value="name", required=false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @Setter
    @Getter
    static class Hello{
        private String name;

    }
}
