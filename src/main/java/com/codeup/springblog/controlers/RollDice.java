package com.codeup.springblog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@Controller
public class RollDice {
    //    @GetMapping("/roll-dice")
//    public String guessNumberForm() {
//        return "roll-dice";
//    }
//    @GetMapping("/roll-dice/{n}")
//    public String GuessNumberSubmission(@RequestParam(name ="number") String info, Model model) {
//        model.addAttribute("number", String.format("I see you picked %s.", info));
//        return "roll-dice";
//    }
    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String RandomNumber(@PathVariable int n) {
        Random ranNum = new Random();

        int RandomNumber = ranNum.nextInt(6) + 1;
        System.out.println(ranNum);
        System.out.println(RandomNumber);
        if (n == RandomNumber) {

            return "<h1>Good job, you got it</h1>";
        } else {
            return "<h1>Sorry you got it wrong</h1>";
        }
    }
}