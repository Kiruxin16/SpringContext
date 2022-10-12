package ru.geekbrains.homework.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.homework.Product;
import ru.geekbrains.homework.beans.ProductService;
import ru.geekbrains.homework.config.ContextConfig;

public class ConsoleLoop {

    public AnnotationConfigApplicationContext context ;

    public void start(){
        System.out.println(
                "Список команд: "+
                "\n /prodlst - вывести список продуктов в магазине"+
                "\n /cartlist -вывести список продуктов в корзине"+
                "\n /fndbyid n -найти продукт в магазине по id(n)"+
                "\n /addtocart n -добавить продукт в корзину по id(n)"+
                "\n /remfromcart n - удалить продукт из корзины по (id)");

        context=new AnnotationConfigApplicationContext(ContextConfig.class);
        ProductService productService = context.getBean(ProductService.class);
        ConsoleReader reader =new ConsoleReader();
        while (true){
            Responce responce =reader.readCommand();

            if (responce.getCommand().equals(API.PRODLIST)){
                for(Product p: productService.getProductList()){
                    System.out.println(p);
                }
            }else if (responce.getCommand().equals(API.CARTLIST)) {
                if(productService.getCartList().isEmpty()){
                    System.out.println("Пока нет товаров в корзине");
                }else for(Product p:productService.getCartList()){
                    System.out.println(p);
                }

            }else if (responce.getCommand().equals(API.FINDPRODUCTBYID)&&responce.getId()!=0) {
                Product p = productService.getProductByID(responce.getId());
                if(p!=null){
                    System.out.println(p);
                }else System.out.println("Товара с таким номером нет в списке");
            }else if (responce.getCommand().equals(API.ADDTOCART)&&responce.getId()!=0) {
                Product p = productService.getProductByID(responce.getId());
                if(p!=null){
                    productService.addProductToCart(p.getId());
                    System.out.println(p+" добавлен в корзину");
                }else System.out.println("Товара с таким номером нет в списке");


            }else if (responce.getCommand().equals(API.REMFROMCART)&&responce.getId()!=0) {
                Product p = productService.getProductByID(responce.getId());
                if(p!=null){
                    if(productService.disposeProduct(p.getId())){
                        System.out.println(p+" удален из корзины");
                    }else{
                        System.out.println("такого товара нет в корзине");
                    }

                }else System.out.println("Товара с таким номером нет в списке");
            }else if (responce.getCommand().equals(API.QUIT)){ break;}

            else {
                System.out.println("неизвестная комманда");
            }

        }

    }
}
