package cz.upce.orm_jpa.repository;

import cz.upce.orm_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
