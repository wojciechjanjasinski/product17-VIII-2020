package product_new.repository;

import org.springframework.stereotype.Repository;
import product_new.model.Product;
import product_new.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public ProductRepository() {
        listOfProducts.add(new Product("chleb na maślance", 3.99, Section.GROCERY));
        listOfProducts.add(new Product("masło 82", 4.49, Section.GROCERY));
        listOfProducts.add(new Product("blender", 169.99, Section.HOUSEHOLD));
        listOfProducts.add(new Product("robot kuchenny", 135.59, Section.HOUSEHOLD));
        listOfProducts.add(new Product("regał drewniany", 299.99, Section.OTHER));
        listOfProducts.add(new Product("kąpielówki", 159.99, Section.OTHER));
    }

    public List<Product> findAll() {
        return new ArrayList<>(listOfProducts);
    }

    public List<Product> findBySection(Section section) {
        return listOfProducts.stream()
                .filter(product -> product.getSection() == section)
                .collect(Collectors.toList());
    }

    public void save(Product product) {
        listOfProducts.add(product);
    }
    public double sumProductsPrices (Section section){
        return listOfProducts.stream()
                .filter(product -> product.getSection() == section)
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
