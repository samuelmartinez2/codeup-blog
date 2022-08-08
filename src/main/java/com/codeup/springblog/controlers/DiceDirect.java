package com.codeup.springblog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiceDirect {
    @GetMapping("/roll-dice")
    public String rolldice(){
        return"roll-dice";
    }
}
