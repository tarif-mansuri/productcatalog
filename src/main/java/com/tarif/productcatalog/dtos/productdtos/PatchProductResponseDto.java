package com.tarif.productcatalog.dtos.productdtos;

import com.tarif.productcatalog.models.Product;
import lombok.Data;

@Data
public class PatchProductResponseDto {
    private ResponseProductDto product;

    public Product toProduct(){
        return product.toProduct();
    }

    public static PatchProductResponseDto toPatchProductResponseDto(Product product){
        PatchProductResponseDto patchProductResponseDto = new PatchProductResponseDto();
        patchProductResponseDto.setProduct(ResponseProductDto.getProductDto(product));
        return patchProductResponseDto;
    }
}
