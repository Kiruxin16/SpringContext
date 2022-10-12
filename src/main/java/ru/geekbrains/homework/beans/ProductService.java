package ru.geekbrains.homework.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.Product;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;
    private Cart cart;

    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getProductList() {
        return productRepo.getProductList();
    }

    public Product getProductByID(long id){
        return productRepo.getByID(id);
    }

    public List<Product> getCartList() {
        return cart.getProducts();
    }

    public void addProductToCart(long id){
        cart.addProduct(productRepo.getByID(id));
    }

    public boolean disposeProduct(long id){
        if (cart.getProducts().stream().anyMatch(p ->p.getId()==id)){
            cart.disposeProduct(id);
            return true;
        }
        return false;
    }

}
