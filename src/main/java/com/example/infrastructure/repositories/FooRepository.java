package com.example.infrastructure.repositories;

import com.example.infrastructure.repositories.data.FooEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<FooEntity, String> {
}
