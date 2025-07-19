package com.tarif.productcatalog.repository;

import com.tarif.productcatalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //--> this method is used for Create product as well as update products

    //find all products whose subcategory name is somthing
   // List<Product> findByCategory_SubCategory_Surname(String surname);

//    @Query("select p from Product p where p.category.subCategory.surname = : surName")
//    List<Product> blablabla(@Param("surName") String surName);

    @Query("select p1 from Product p1 where p1.price<:myPrice")
    List<Product> prodcutWhosPriceIsLessThan(@Param("myPrice") Double myPrice);


    @Query(value = CutomQueries.GET_ALL_PRODUCT, nativeQuery = true)
    List<Product> getProductsByRawSQL();

    @Query(value = CutomQueries.GET_ALL_PRODUCT, nativeQuery = true)
    List<Product> getProductsByRawSQLwww();


}
