package com.jwt.implementation.controller;/*
package com.sheryians.major.controller;


import com.sheryians.major.dto.ProductDto;
import com.sheryians.major.repository.UserRepository;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public ProductService productService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/admin")
    public String AdminHome(){

        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String Categories(Model model){
        model.addAttribute("categories",categoryService.getAllCat());
        return "categories";
    }


    @PostMapping("/admin/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category")Category category){
        categoryService.postCategoriesAdd(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoriesAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
         categoryService.deleteCat(id);
         return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<Category> category = categoryService.getCatById(id);
        if(category.isPresent()){
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        else return "404";
    }

    //productSection
    @GetMapping("/admin/products")
    public String Products(Model model){
        model.addAttribute("products" ,productService.getAllProducts());
        return "products";
    }

   */
/* @PostMapping("/admin/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category")Category category){
        categoryService.postCategoriesAdd(category);
        return "redirect:/admin/categories";
    }*//*


    @GetMapping("/admin/products/add")
    public String getProductAdd(Model model, ProductDto dto){
       // ProductDto product= dto.getId();
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categories",categoryService.getAllCat());
        return "productsAdd";
    }





}
*/
