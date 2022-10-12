package ru.geekbrains.homework.beans;


import org.springframework.stereotype.Component;
import ru.geekbrains.homework.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepo {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1,"Soccer вall",800),
                new Product(2,"Jump rope", 600),
                new Product(3,"Punching bag",12000),
                new Product(4,"Barbell",20000),
                new Product(5,"Dumbell",8000)
        ));
    }

    public Product getByID(long id){
        return products.stream().filter(p ->p.getId()==id).findFirst().orElseThrow();
    }

    public List<Product> getProductList(){
        return  products;
    }


}
