package iu.edu.lukemeng.c322spring2024homework2.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HomeController {
    @GetMapping("/")
    public String greetings(){
        return "Welcome to the inventory management service";
    }


}
