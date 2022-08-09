package com.codeup.springblog.controlers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Product;
import com.codeup.springblog.repositories.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productsDao;

    public ProductController(ProductRepository productDao){
        this.productsDao = productDao;

    }
    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productsDao.findAll());
//        System.out.println(productsDao.getProductByName("Oil - Safflower").getPrice());
        List<Product> searchProducts = productsDao.getProductByName("oil");
//productsDao.save(new Post), // ???this will help for exercise?????//
        // productsDao.save(new Product(51, "New Balance Shoes",
        for (Product product : searchProducts ) {
            System.out.println(product.getName());
        }
        return "products/index";
    }

    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product",new Product());
        return "products/create";
    }
    @PostMapping("/products/create")
    public String create(@ModelAttribute Product product){
        productsDao.save(product);
        return "redirect:/products";
    }

    @GetMapping("products/edit/{id}")
    public String editProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productsDao.getById(id));
        return "products/create";
    }

}
