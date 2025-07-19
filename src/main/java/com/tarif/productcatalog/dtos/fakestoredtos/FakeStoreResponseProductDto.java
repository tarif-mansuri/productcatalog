package com.tarif.productcatalog.dtos.fakestoredtos;

import com.tarif.productcatalog.models.Category;
import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class FakeStoreResponseProductDto {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private double price;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);
        product.setImageurl(image);
        return product;
    }

    public static FakeStoreResponseProductDto toFakeStoreResponseProductDto(Product product) {
        FakeStoreResponseProductDto fakeStoreResponseProductDto = new FakeStoreResponseProductDto();
        fakeStoreResponseProductDto.setId(product.getId());
        fakeStoreResponseProductDto.setTitle(product.getName());
        fakeStoreResponseProductDto.setDescription(product.getDescription());
        fakeStoreResponseProductDto.setCategory(product.getCategory());
        fakeStoreResponseProductDto.setPrice(product.getPrice());
        fakeStoreResponseProductDto.setImage(product.getImageurl());
        return fakeStoreResponseProductDto;
    }
}
