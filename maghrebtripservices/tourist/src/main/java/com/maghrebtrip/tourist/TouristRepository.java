package com.maghrebtrip.tourist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TouristRepository extends JpaRepository<Tourist, Integer> {
    Optional<Tourist> findByEmail(String email);
}
