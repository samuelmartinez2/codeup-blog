package com.codeup.springblog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

//    @GetMapping("/")
//    @ResponseBody
//    public String hello() {
//        return "<h1>This is the math page!</h1>";
//    }

    @GetMapping("/add/{num}/and/{num2}")
    @ResponseBody
    public String addNumber(@PathVariable int num,@PathVariable int num2) {
        String add = String.format("The number %d plus %d is %d", num ,num2 ,(num + num2));
//        String numSquared = String.format("The number %d squared is %d.", num, (int) (Math.pow(num, 2)));
//        String fizzBuzzEval = String.format("The number %d when run through FizzBuzz would print %s", num, fizzBuzzEvaluation(num));
        return String.format("<h3>%s</h3>", add);
    }

    @GetMapping("/subtract/{num}/from/{num2}")
    @ResponseBody
    public String subtractNumber(@PathVariable int num, @PathVariable int num2) {
        String subtract = String.format("The number %d minus %d is %d", num2,num, (num2 - num));
        return String.format("<h3>%s</h3>", subtract);
    }

    @GetMapping("/multiply/{num}/and/{num2}")
    @ResponseBody
    public String multiplyNumber(@PathVariable int num, @PathVariable int num2) {
        String multiply = String.format("the number %d multiplied by %d is %d", num, num2, (num * num2));
        return String.format("<h3>%s</h3>", multiply);
    }

    @GetMapping("/divide/{num}/by/{num2}")
    @ResponseBody
    public String divideNumber(@PathVariable int num, @PathVariable int num2) {
        String divide = String.format("the number %d devided by %d is %d", num, num2, (num /num2));
        return String.format("<h3>%s</h3>", divide);
    }

}
