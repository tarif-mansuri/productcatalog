package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class GetProductResoponseDto {
    private ResponseProductDto product;

    public static GetProductResoponseDto getProductDto(Product product) {
        GetProductResoponseDto productResoponseDto = new GetProductResoponseDto();
        productResoponseDto.setProduct(ResponseProductDto.getProductDto(product));
        return productResoponseDto;
    }

    public Product toProduct() {
        return product.toProduct();
    }
}
