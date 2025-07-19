package com.tarif.productcatalog.services;

import com.tarif.productcatalog.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProduct(Long productId);
    public Product updateProduct(Long productId, Product product);
    public void deleteProduct(Long productId);
}
