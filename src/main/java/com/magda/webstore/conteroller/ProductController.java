package com.magda.webstore.conteroller;

import com.magda.webstore.domain.Product;
import com.magda.webstore.domain.repository.ProductRepository;
import com.magda.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}
