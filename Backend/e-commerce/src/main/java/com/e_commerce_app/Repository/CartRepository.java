package com.e_commerce_app.Repository;

import com.e_commerce_app.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
