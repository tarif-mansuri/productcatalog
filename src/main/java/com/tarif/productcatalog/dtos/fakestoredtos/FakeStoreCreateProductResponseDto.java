package com.tarif.productcatalog.dtos.fakestoredtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class FakeStoreCreateProductResponseDto {
    private FakeStoreResponseProductDto fakeStoreResponseProductDto;

    public Product toProduct() {
        return fakeStoreResponseProductDto.toProduct();
    }

    public static FakeStoreCreateProductResponseDto toFakeStoreCreateProductResponseDto(Product product) {
        FakeStoreCreateProductResponseDto fakeStoreResponseProductDto = new FakeStoreCreateProductResponseDto();
        fakeStoreResponseProductDto.setFakeStoreResponseProductDto(FakeStoreResponseProductDto.toFakeStoreResponseProductDto(product));
        return fakeStoreResponseProductDto;
    }
}
