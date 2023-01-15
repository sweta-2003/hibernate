package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
   /*post method */
    public Product saveproduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveproducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product>getProducts(){
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return repository.findByName(name);
    }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed successfully"+id;
    }

    public Product updateProduct(Product product){
       Product  existingProduct=repository.findById(product.getId()).orElse(null);
       existingProduct.setName(product.getName());
       existingProduct.setId(product.getId());
       existingProduct.setPrice(product.getPrice());
       existingProduct.setQuantity(product.getQuantity());
       return repository.save(existingProduct);
    }
}
