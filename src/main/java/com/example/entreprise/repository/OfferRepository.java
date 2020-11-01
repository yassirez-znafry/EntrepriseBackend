package com.example.entreprise.repository;

import com.example.entreprise.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByUsername(String username);
}
