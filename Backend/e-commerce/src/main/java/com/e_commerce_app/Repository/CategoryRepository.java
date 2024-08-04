package com.e_commerce_app.Repository;

import com.e_commerce_app.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
