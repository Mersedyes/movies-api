package com.codeup.fortran_movies_api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//    @GetMapping("/hello") //defines a method that should be invoked when a GET request is received for the specified URI
//    @ResponseBody //tells Spring that whatever is returned from this method should be the body of our response
//    public String sayHello(@PathVariable String name){
//        return "Hello," + name + "!";

    @GetMapping("/increment/{number}")
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
}
