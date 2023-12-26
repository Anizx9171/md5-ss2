package com.ra.ss2.controller;

import com.ra.ss2.model.entity.Product;
import com.ra.ss2.model.service.category.CategoryService;
import com.ra.ss2.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/product")
    public String productTB(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/product";
    }

    @RequestMapping("/category")
    public String categoryTB() {
        return "category/category";
    }

    @GetMapping("/add-product")
    public String navigateAddProduct(Model model) {
        model.addAttribute("product", new Product());
        System.out.println(categoryService.findAll().size());
        model.addAttribute("categories", categoryService.findAll());
        return "product/add-product";
    }

    @PostMapping("/add-product")
    public String addNewProduct(@ModelAttribute("product") Product product) {
        if (productService.saveOrUpdate(product)) {
            return "redirect:/product";
        }
        return "redirect:/add-product";
    }

    @GetMapping("/edit-product/{id}")
    public String navigateEditProduct(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/product";
        }
        model.addAttribute("product", product);
        System.out.println(categoryService.findAll().size());
        model.addAttribute("categories", categoryService.findAll());
        return "product/edit-product";
    }

    @PostMapping("/edit-product/{id}")
    public String editProduct(@ModelAttribute("product") Product product) {
        if (productService.saveOrUpdate(product)) {
            return "redirect:/product";
        }
        return "redirect:/edit-product";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
