package com.example.entreprise.service;

import com.example.entreprise.dto.CandidatRequest;
import com.example.entreprise.dto.OfferDto;
import com.example.entreprise.model.Candidat;
import com.example.entreprise.repository.CandidatRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j

public class CandidatService {
    private final CandidatRepository candidatRepository;
    private final OfferService offerService;


    @Transactional
    public Candidat save(CandidatRequest candidatRequest) {
        Candidat candidat = new Candidat();
        candidat.setDisponibilite(candidatRequest.getDisponibilite());
        candidat.setEmail(candidatRequest.getEmail());
        candidat.setName(candidatRequest.getName());
        candidat.setTarif(candidatRequest.getTarif());
        candidat.setTele(candidatRequest.getTele());
        candidat.setOfferId(candidatRequest.getOfferId());
        return candidatRepository.save(candidat);
    }

    @Transactional
    public Optional<Candidat> getCandidat(Long id){
        return candidatRepository.findById(id);
    }

    @Transactional
    public List<Candidat> getCandidatByOffer(Long id){
        return candidatRepository.findByOfferId(id);
    }


    @Transactional
    public List<Candidat> getCandidatByOfferor(String username){
        List<Candidat> candidats = new ArrayList<Candidat>();
        List<OfferDto> offerDtos = offerService.readByUsername(username);
        offerDtos.forEach(offerDto -> 
                candidats.addAll(getCandidatByOffer(offerDto.getId()))
                );
        return candidats;
    }


}
