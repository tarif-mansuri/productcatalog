package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class CreateProductResponseDto {
    private ResponseProductDto product;

    public static CreateProductResponseDto createProductResponseDto(Product product) {
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
        createProductResponseDto.setProduct(ResponseProductDto.getProductDto(product));
        return createProductResponseDto;
    }

    public Product toProduct() {
        return product.toProduct();
    }
}
