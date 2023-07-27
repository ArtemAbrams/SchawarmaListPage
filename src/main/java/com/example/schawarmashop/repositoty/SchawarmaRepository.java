package com.example.schawarmashop.repositoty;

import com.example.schawarmashop.domain.entity.Schawarma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchawarmaRepository extends JpaRepository<Schawarma, Long> {
}
