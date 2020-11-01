package com.example.entreprise.repository;

import com.example.entreprise.model.Candidat;
import com.example.entreprise.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    List<Candidat> findByOfferId(Long id);
}
