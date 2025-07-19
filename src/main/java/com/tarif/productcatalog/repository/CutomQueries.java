package com.tarif.productcatalog.repository;

public interface CutomQueries {
    public static final String GET_ALL_PRODUCT = "select * from product p join  category1 c on p.id = c.id join subcategory sub on p.id = sub.id\" +\n" +
            "            \"where p.price> 100000";
}
