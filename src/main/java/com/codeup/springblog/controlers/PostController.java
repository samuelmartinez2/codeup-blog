package com.codeup.springblog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String postspage() {
        return ("/posts/index");
    }

    @RequestMapping(path = "/posts{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postpageid(@PathVariable long id) {
        return ("posts/view");
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String postcreateget() {
        return ("/posts/create");
    }

    @RequestMapping(path = "/posts/create")
    @ResponseBody
    public String postcreatepost() {
        return null;
    }

}
