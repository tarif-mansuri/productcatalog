package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Category;
import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class RequestProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String categoryName;
    private String imageUrl;

    public Product toProduct(){
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

    public static RequestProductDto toRequestProductDto(Product product){
        RequestProductDto requestProductDto = new RequestProductDto();
        requestProductDto.setId(product.getId());
        requestProductDto.setName(product.getName());
        requestProductDto.setDescription(product.getDescription());
        requestProductDto.setPrice(product.getPrice());
        requestProductDto.setCategoryName(product.getCategory().getName());
        requestProductDto.setImageUrl(product.getImageurl());
        return requestProductDto;
    }
}
