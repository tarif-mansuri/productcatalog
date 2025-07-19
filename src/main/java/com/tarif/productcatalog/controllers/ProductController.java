package com.tarif.productcatalog.controllers;

import com.tarif.productcatalog.dtos.productdtos.*;
import com.tarif.productcatalog.models.Product;
import com.tarif.productcatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    public ProductController(@Qualifier("dbservice") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
       Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.createProductResponseDto(product);
    }

    @GetMapping("/{id}")
    public GetProductResoponseDto getProduct(@PathVariable("id") Long productId) {
        Product product = productService.getProduct(productId);
        return GetProductResoponseDto.getProductDto(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProduct() {
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto responseDtos = new GetAllProductsResponseDto();
        responseDtos.setProducts(new ArrayList<>());
        for(Product product : products) {
            ResponseProductDto getProductDto = ResponseProductDto.getProductDto(product);
            responseDtos.getProducts().add(getProductDto);
        }
        return responseDtos;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return true;
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto patchProduct(@RequestBody PatchProductRequestDto patchProductRequestDto, @PathVariable("id") Long id) {
        Product product = productService.updateProduct(id, patchProductRequestDto.toProduct());
        return PatchProductResponseDto.toPatchProductResponseDto(product);
    }
}
