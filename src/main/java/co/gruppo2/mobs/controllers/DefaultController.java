package co.gruppo2.mobs.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class DefaultController {

    @GetMapping("")
    public String defaultMsg(){
        return "welcome in the MOBS Api!";
    }
}
