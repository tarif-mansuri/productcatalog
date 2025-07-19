package com.tarif.productcatalog.repository;

import com.tarif.productcatalog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
    Category save(Category category);
}
