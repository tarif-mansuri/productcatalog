package com.tarif.productcatalog.dtos.productdtos;

import lombok.Data;

import java.util.List;

@Data
public class GetAllProductsResponseDto {
    private List<ResponseProductDto> products;
}
