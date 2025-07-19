package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Category;
import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class ResponseProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private String imageUrl;

    public static ResponseProductDto getProductDto(Product product) {
        ResponseProductDto getProductDto = new ResponseProductDto();
        getProductDto.setId(product.getId());
        getProductDto.setName(product.getName());
        getProductDto.setDescription(product.getDescription());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setCategoryName(product.getCategory().getName());
        getProductDto.setImageUrl(product.getImageurl());
        return getProductDto;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        product.setImageurl(imageUrl);
        return product;
    }
}
