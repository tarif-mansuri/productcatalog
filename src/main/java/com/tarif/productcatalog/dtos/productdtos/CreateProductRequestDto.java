package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class CreateProductRequestDto {
    private RequestProductDto product;

    public Product toProduct() {
        return product.toProduct();
    }

    public CreateProductRequestDto toCreateProductRequestDto(Product product) {
        CreateProductRequestDto requestDto = new CreateProductRequestDto();
        requestDto.setProduct(RequestProductDto.toRequestProductDto(product));
        return requestDto;
    }
}
