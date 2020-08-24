package product_new.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import product_new.model.Product;
import product_new.model.Section;
import product_new.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    @ResponseBody
    String find(@RequestParam(required = false) Section section){
        List<Product> result;
        if (section == null){
            result = productRepository.findAll();
            double sumProductsPrices = productRepository.sumProductsPrices();
            return result + " " + sumProductsPrices + " PLN ";
        }else {
            result = productRepository.findBySection(section);
            double sumProductsSectionPrices = productRepository.sumProductsSectionPrices(section);
            System.out.println(sumProductsSectionPrices);
            return result.stream()
                    .map(Product::toString)
                    .collect(Collectors.joining("<br/>")) + " " + sumProductsSectionPrices + " PLN ";
        }
    }

    @PostMapping("/products/add")
    String add(@RequestParam String name, @RequestParam double price, @RequestParam Section section){
        productRepository.save(new Product(name, price, section));
        return "redirect:/products";
    }
}
