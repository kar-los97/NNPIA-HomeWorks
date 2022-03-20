package cz.upce.orm_jpa.controller;

import cz.upce.orm_jpa.dto.ProductDto;
import cz.upce.orm_jpa.entity.Product;
import cz.upce.orm_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(){
        return "error";
    }

    @GetMapping("/product")
    public String showAllProducts(Model model){
        model.addAttribute("productList",productRepository.findAll());
        return "product-list";
    }

    @GetMapping(value = {"/product/create", "/product/edit/{id}"})
    public String updateProductForm(Model model, @PathVariable(required = false) Integer id){
        if(id!=null){
            Product product = productRepository.getById(id);
            model.addAttribute("product", product);
        }else{
            model.addAttribute("product",new ProductDto());
        }
        return "product-form";
    }

    @GetMapping("product/detail/{id}")
    public String getProductDetail(@PathVariable int id, Model model){
        Product product = productRepository.getById(id);
        model.addAttribute("product",product);
        return "product-detail";
    }

    @PostMapping("/save-product")
    public String saveProduct(ProductDto productDto){
        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCost(productDto.getCost());
        product.setAvailability(productDto.isAvailability());

        productRepository.save(product);

        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        Product product = productRepository.getById(id);
        productRepository.delete(product);
        return "redirect:/";
    }



}
