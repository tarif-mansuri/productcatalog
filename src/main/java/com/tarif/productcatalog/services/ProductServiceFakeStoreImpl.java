package com.tarif.productcatalog.services;

import com.tarif.productcatalog.dtos.fakestoredtos.FakeStoreCreateProductRequestDto;
import com.tarif.productcatalog.dtos.fakestoredtos.FakeStoreCreateProductResponseDto;
import com.tarif.productcatalog.dtos.fakestoredtos.FakeStoreResponseProductDto;
import com.tarif.productcatalog.dtos.fakestoredtos.FakeStoreGetAllProductsDto;
import com.tarif.productcatalog.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("fakestoreService")
public class ProductServiceFakeStoreImpl implements ProductService {
    private RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = FakeStoreCreateProductRequestDto.toFakeStoreCreateProductRequestDto(product);
        FakeStoreCreateProductResponseDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreCreateProductRequestDto, FakeStoreCreateProductResponseDto.class);
        return responseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetAllProductsDto[] responseDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreGetAllProductsDto[].class);

        List<FakeStoreGetAllProductsDto> responseList = Stream.of(responseDtos).toList();
        List<Product> products = new ArrayList<>();

        for (FakeStoreGetAllProductsDto fakeStoreGetAllProductsDto : responseList) {
            products.add(fakeStoreGetAllProductsDto.toProduct());
        }
        return products;
    }

    @Override
    public Product getProduct(Long productId) {
        FakeStoreResponseProductDto fakeStoreGateProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+ productId, FakeStoreResponseProductDto.class);
        return fakeStoreGateProductDto.toProduct();
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        restTemplate.delete("https://fakestoreapi.com/products/"+ productId);
    }
}
