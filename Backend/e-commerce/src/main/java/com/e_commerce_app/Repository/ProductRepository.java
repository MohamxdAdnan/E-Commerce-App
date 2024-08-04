package com.e_commerce_app.Repository;

import com.e_commerce_app.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.PrimitiveIterator;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
