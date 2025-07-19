package com.tarif.productcatalog.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    private String categoryType;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> featuredProducts;
}
