package com.codeup.springblog.controlers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Product;
import com.codeup.springblog.models.Toy;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @GetMapping("/posts/{id}")
    public String viewOnePost(@PathVariable long id, Model model) {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        boolean loggedIn = !(user instanceof AnonymousAuthenticationToken);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("singlePost", postDao.getById(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostPage(Model model) {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (currentUser.getId() == postDao.getById(id).getUser().getId()) {

//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User test= userDao.getById(currentUser.getId());
//        System.out.println("this is the current user "+ test);
        model.addAttribute("title", "Create Post");
        model.addAttribute("post", new Post());
        return "/posts/create";
//        } else
//            return "redirect:/login";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
//        post.setUser(userDao.getById(1L));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(currentUser);
        postDao.save(post);
        emailService.prepareAndSend(post, "Post saved");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditPost(Model model, @PathVariable long id) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(currentUser.getId() == postDao.getById(id).getUser().getId()) {
            model.addAttribute("title", "Edit Post");
            model.addAttribute("post", postDao.getById(id));
            return "posts/create";

        } else{
            return "redirect:/login";
        }
    }

    @PostMapping("/posts/{id}/edit")
    public String submitEditForm(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postToEdit = postDao.getById(id);

        postToEdit.setTittle(title);
        postToEdit.setBody(body);
        postToEdit.setUser(currentUser);

        postDao.save(postToEdit);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post postToDelete = postDao.getById(id);
        postDao.delete(postToDelete);
        return "redirect:/posts";
    }
}

//    @PostMapping("/posts")
//    public String singleAd(Long singleAd, Model model) {
////        if (singleAd != null) {
//            Post post = postDao.getById(singleAd);
//            model.addAttribute("post", post);
////        }
//        return "/posts/show";
//    }


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



