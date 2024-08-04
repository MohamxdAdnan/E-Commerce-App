package com.e_commerce_app.Repository;

import com.e_commerce_app.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaerItemRepository extends JpaRepository<CartItem,Long> {
}
