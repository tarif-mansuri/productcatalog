package com.tarif.productcatalog.dtos.fakestoredtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class FakeStoreGetAllProductsDto {
    private FakeStoreResponseProductDto fakeStoreGateProductDto;

    public Product toProduct() {
        return fakeStoreGateProductDto.toProduct();
    }

    public static FakeStoreGetAllProductsDto toFakeStoreGetAllProductsDto(Product product) {
        FakeStoreGetAllProductsDto fakeStoreGetAllProductsDto = new FakeStoreGetAllProductsDto();
        fakeStoreGetAllProductsDto.setFakeStoreGateProductDto(FakeStoreResponseProductDto.toFakeStoreResponseProductDto(product));
        return fakeStoreGetAllProductsDto;
    }
}
