package com.tarif.productcatalog.dtos.fakestoredtos;

import com.tarif.productcatalog.models.Category;
import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class FakeStoreRequestProductDto {
    private String title;
    private String description;
    private Category category;
    private double price;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setImageurl(image);
        product.setCategory(category);
        product.setPrice(price);
        product.setDescription(description);
        product.setName(title);
        return product;
    }

    public static FakeStoreRequestProductDto toFakeStoreRequestProductDto(Product product) {
        FakeStoreRequestProductDto fakeStoreRequestProductDto = new FakeStoreRequestProductDto();
        fakeStoreRequestProductDto.setCategory(product.getCategory());
        fakeStoreRequestProductDto.setDescription(product.getDescription());
        fakeStoreRequestProductDto.setPrice(product.getPrice());
        fakeStoreRequestProductDto.setImage(product.getImageurl());
        fakeStoreRequestProductDto.setTitle(product.getName());
        return fakeStoreRequestProductDto;
    }
}
