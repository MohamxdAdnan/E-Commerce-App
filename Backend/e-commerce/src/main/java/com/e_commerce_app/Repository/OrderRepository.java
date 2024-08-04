package com.e_commerce_app.Repository;

import com.e_commerce_app.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
