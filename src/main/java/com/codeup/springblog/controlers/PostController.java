package com.codeup.springblog.controlers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Product;
import com.codeup.springblog.models.Toy;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController {
    private final EmailService emailService;
    private PostRepository postDao;
    private UserRepository userDao;
    @Value("$spring.mail.from")
    private String from;

    public PostController(EmailService emailService, PostRepository postDao, UserRepository userDao) {
        this.emailService = emailService;
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping("/posts")
    public String viewAllPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post(1L, "test 1", "test body 1"));
//        posts.add(new Post(2L, "test 2", "test body 2"));
//        model.addAttribute("posts", posts);
        return "/posts/index";
    }
//    public String ViewAllUser(Model model) {
//        model.addAttribute("user", userDao.findAll());
//        return "/users/index";
//    }

    @PostMapping("/posts")
    public String singleAd(Long singleAd, Model model) {
        if (singleAd != null) {
            Post post = postDao.getById(singleAd);
            model.addAttribute("post", post);
        }
        return "/posts/show";
    }

//    @GetMapping("posts/create")
//    public String showPostForm(Model model) {
//        model.addAttribute("user", userDao.findAll());
//        return "posts/create";
//    }

//    @PostMapping("/post/")
//    public String deleteAd(Long deleteAd, Model model) {
//        Post post = postDao.delete(singleAd("post",post));
//        model.addAttribute("post", post);

//        public String deleteAds(@RequestParam(name = "tittle") String tittle,@RequestParam(name = "body") String body) {
//            postDao.delete(tittle, body);
//    return"/posts/index";
//}
//    ????????????? this is one way to do it.?????????????????????
//        @GetMapping("/posts/create")
//        public String createPostPage(Model model) {
//        model.addAttribute("users", userDao.findAll());
//        return "/posts/create";
//}
//        @PostMapping("/posts/create")
//        public String savePost(@RequestParam(name = "user") Long id,@RequestParam(name = "body") String body, @RequestParam(name = "tittle") String tittle) {
////            postDao.save(new Post(tittle, body));
////            return "redirect:/posts";
//            Post newPost = new Post(tittle,body,userDao.getById(id));
//            postDao.save(newPost);
//            return "redirect:/posts";
//        }
//    ????????????????this is the other way to do it wth Model binding???????????????????????

    @GetMapping("/posts/create")
    public String createPostPage(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
//        post.setUser(userDao.getById(1L));
        System.out.println(from);
        postDao.save(post);
        emailService.prepareAndSend(userDao.findByUsername("123"), "this is to test the email functionality!", "How are you doing? This is my third attempt at doing did. I had to hard code a user i already had in order for it to work.");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editProduct(Model model, @PathVariable long id) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("post", postDao.getById(id));
        return "posts/create";
    }


//        public String createPost(String tittle, String body) {
////            if (tittle != null && body != null)
//            {
//                postDao.save(new Post(tittle, body));
//            }
//            return "redirect:/posts";
//        }
//
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    @ResponseBody
//    public String postspage() {
//        return ("/posts/index");
//    }
//
//    @RequestMapping(path = "/posts{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String postpageid(@PathVariable long id) {
//        return ("posts/view");
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String postcreateget() {
//        return ("/posts/create");
//    }
//
//    @RequestMapping(path = "/posts/create")
//    @ResponseBody
//    public String postcreatepost() {
//        return null;

    }

