package com.app.techStoreApp.controller;

import com.app.techStoreApp.model.Product;
import com.app.techStoreApp.model.ProductType;
import com.app.techStoreApp.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("types", ProductType.values());
        return "newProduct";
    }

    @PostMapping("/product")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "newProduct";
        }
        productRepository.save(product);
        return "/";
    }
}
