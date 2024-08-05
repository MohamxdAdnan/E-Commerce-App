import React from "react";
import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';

const ProductCard = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const username = queryParams.get('username');
    const token = queryParams.get('token');
  const [products, setProducts] = useState([]);

  console.log(username);
  console.log(token);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/products")
      .then((response) => setProducts(response.data))
      .catch((error) => console.error("Error fetching products:", error));
  }, []);

  return (
    <div class="d-flex">
      {products.map((product) => (
        <div class="card" style={{ width: 250 }}>
          <img class="card-img-top" src="..." alt="Product image" />
          <div class="card-body">
            <h5 class="card-title">{product.name}</h5>
            <p class="card-text">Product Desc...</p>
            <p class="card-text"> RS: {product.price}</p>
            <a href="#" class="btn btn-primary">
              + Add to Cart
            </a>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ProductCard;
