package com.codeup.springblog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/1")
    @ResponseBody
    public String startpage() {
        return "<h1>This is the landing page</h1>";
    }
}
