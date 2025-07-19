package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class PatchProductRequestDto {
    private RequestProductDto product;

    public Product toProduct(){
        return product.toProduct();
    }

    public static PatchProductRequestDto toPatchProductRequestDto(Product product){
        PatchProductRequestDto patchProductRequestDto = new PatchProductRequestDto();
        patchProductRequestDto.setProduct(RequestProductDto.toRequestProductDto(product));
        return patchProductRequestDto;
    }
}
