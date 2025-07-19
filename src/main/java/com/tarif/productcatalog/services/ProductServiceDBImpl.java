package com.tarif.productcatalog.services;

import com.tarif.productcatalog.models.Category;
import com.tarif.productcatalog.models.Product;
import com.tarif.productcatalog.repository.CategoryRepository;
import com.tarif.productcatalog.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbservice")
public class ProductServiceDBImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepositorys) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepositorys;
    }
    @Override
    public Product createProduct(Product product) {
        String categoryName = product.getCategory().getName();
        Optional<Category> findByName = categoryRepository.findByName(categoryName);

        if (findByName.isEmpty()) {
            Category category = new Category();
            category.setName(product.getCategory().getName());
            Category categoryToBeSaved = categoryRepository.save(category);
            product.setCategory(category);
        }else{
            Category category = findByName.get();
            List<Product> products = category.getProducts();
            product.setCategory(category);

        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        Optional<Product> ProductOpt = productRepository.findById(productId);
        if(ProductOpt.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        return ProductOpt.get();
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Product> ProductOpt = productRepository.findById(productId);
        if(ProductOpt.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        Product productToBeUpdate = ProductOpt.get();
        if(product.getName()!=null){
            productToBeUpdate.setName(product.getName());
        }
        if(product.getDescription()!=null){
            productToBeUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            productToBeUpdate.setPrice(product.getPrice());
        }
        if(product.getCategory().getName()!=null){
            Optional<Category> findByName = categoryRepository.findByName(product.getCategory().getName());
            if(findByName.isEmpty()){
                Category category = new Category();
                category.setName(product.getCategory().getName());
                Category categoryToBeSaved = categoryRepository.save(category);
                productToBeUpdate.setCategory(categoryToBeSaved);
            }else{
                productToBeUpdate.setCategory(findByName.get());
            }
        }
        if(product.getId()!=null){
            productToBeUpdate.setId(productId);
        }
        return productRepository.save(productToBeUpdate);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
