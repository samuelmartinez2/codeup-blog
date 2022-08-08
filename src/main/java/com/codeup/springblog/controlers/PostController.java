package com.codeup.springblog.controlers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Tag;
import com.codeup.springblog.models.Toy;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.TagRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;
    private TagRepository tagDao;

    public PostController(PostRepository postDao, UserRepository userDao, TagRepository tagDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.tagDao = tagDao;
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
        @GetMapping("/posts/create")
        public String createPostPage(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "/posts/create";
}

        @PostMapping("/posts/create")
        public String savePost(@RequestParam(name = "user") Long id,@RequestParam(name = "body") String body, @RequestParam(name = "tittle") String tittle) {
//            postDao.save(new Post(tittle, body));
//            return "redirect:/posts";
            Post newPost = new Post(tittle,body,userDao.getById(id));
            postDao.save(newPost);
            return "redirect:/posts";
        }
    @GetMapping("/tag/create")
    public String createTag(Model model) {
        model.addAttribute("tags", tagDao.findAll());
        return "/tags/create";
    }
    @PostMapping("/posts/create")
    public String savePost(@RequestParam(name = "user") Long id,@RequestParam(name = "body") String body, @RequestParam(name = "tittle") String tittle,@RequestParam(name ="tag") List tags_id) {
//            postDao.save(new Post(tittle, body));
//            return "redirect:/posts";
        Post newPost = new Post(tittle,body,userDao.getById(id),tagDao.getById(tags_id));
        postDao.save(newPost);
        return "redirect:/posts";
    }
    // added this coment so i can commit on new branch//






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

