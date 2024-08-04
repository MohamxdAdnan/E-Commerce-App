package com.e_commerce_app.Repository;

import com.e_commerce_app.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
