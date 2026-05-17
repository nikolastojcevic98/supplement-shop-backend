package com.supplementshop.repository;

import com.supplementshop.model.SupplierOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderItemRepository extends JpaRepository<SupplierOrderItem, Integer> {
}