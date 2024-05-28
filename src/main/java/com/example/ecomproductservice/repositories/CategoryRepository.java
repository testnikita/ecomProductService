package com.example.ecomproductservice.repositories;

import com.example.ecomproductservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    Optional<Category> findById(UUID uuid);

    @Override
    List<Category> findAllById(Iterable<UUID> uuids);
}
