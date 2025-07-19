package com.tarif.productcatalog.dtos.fakestoredtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class FakeStoreCreateProductRequestDto {
    private FakeStoreRequestProductDto fakeStoreRequestProductDto;

    public Product toProduct() {
        return fakeStoreRequestProductDto.toProduct();
    }

    public static FakeStoreCreateProductRequestDto toFakeStoreCreateProductRequestDto(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreRequestProductDto = new FakeStoreCreateProductRequestDto();
        fakeStoreRequestProductDto.setFakeStoreRequestProductDto(FakeStoreRequestProductDto.toFakeStoreRequestProductDto(product));
        return fakeStoreRequestProductDto;
    }
}
