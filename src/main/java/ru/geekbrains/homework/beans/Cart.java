package ru.geekbrains.homework.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> products ;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getByID(long id){
        return products.stream().filter(p ->p.getId()==id).findFirst().orElseThrow();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void disposeProduct(long id){
        products.remove(getByID(id));

    }


}
