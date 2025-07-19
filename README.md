API Payload structure

1. Create a product
    [POST]http://localhost:8080/products

            Payload:
            
                {
                "product": {
                    "name": "Iphone 15",
                    "description": "this is a smart Phone",
                    "price": 190000,
                    "categoryName":"iphones",
                    "imageUrl": "http://example.com"
                }
            }


2. Get all products

  [GET]http://localhost:8080/products


3. Get product by id

  [GET]http://localhost:8080/products/{product_id}

4. Patch a product

  [PATCH]http://localhost:8080/products/{product_id}

    Payload: Pass any field that you want to patch, for example here i am patching categoryName

    {
    "product": {
        "categoryName": "TShirt"
        }
    }
    

5.  Delete by id

  [DELETE]http://localhost:8080/products/{product_id}

6. Update product

  [PUT]http://localhost:8080/products

    Payload:

    {
    "product": {
        "id": 52,
        "name": "IPhone52",
        "description": "this is pink color smartphone",
        "price": 52000,
        "categoryName":"iPhone",
        "imageUrl": "http://example.com"
    }
}
  

