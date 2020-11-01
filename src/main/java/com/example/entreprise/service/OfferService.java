package com.example.entreprise.service;

import com.example.entreprise.dto.OfferDto;
import com.example.entreprise.exception.OfferNotFoundException;
import com.example.entreprise.model.Offer;
import com.example.entreprise.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import static java.util.stream.Collectors.toList;


import java.time.Instant;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private AuthService authService;
    @Autowired
    private OfferRepository offerRepository;


    @Transactional
    public void createOffer(OfferDto offerDto) {
        Offer offer= mapFromDtoToOffer(offerDto);
        offerRepository.save(offer);
    }

    @Transactional
    public List<OfferDto> showAllOffers() {
        List<Offer> posts = offerRepository.findAll();
        return posts.stream().map(this::mapFromOfferToDto).collect(toList());
    }

    @Transactional
    public OfferDto readSingleOffer(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new OfferNotFoundException("For id " + id));
        return mapFromOfferToDto(offer);
    }

    @Transactional
    public List<OfferDto> readByUsername(String username){
        return  offerRepository.findByUsername(username).stream()
                .map(this::mapFromOfferToDto)
                .collect(toList());

    }


    private Offer mapFromDtoToOffer(OfferDto offerDto) {
        Offer offer = new Offer();
        offer.setTitle(offerDto.getTitle());
        offer.setCompetance(offerDto.getCompetance());
        offer.setMission(offerDto.getMission());
        offer.setProfil(offerDto.getProfil());
        offer.setQualities(offerDto.getQualities());
        offer.setTitle(offerDto.getTitle());
        offer.setType(offerDto.getType());
        offer.setDateCrea(Instant.now());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        offer.setUsername(loggedInUser.getUsername());
        return offer;
    }

    private OfferDto mapFromOfferToDto(Offer offer) {
        OfferDto offerDto = new OfferDto();
        offerDto.setId(offer.getId());
        offerDto.setCompetance(offer.getCompetance());
        offerDto.setMission(offer.getMission());
        offerDto.setProfil(offer.getProfil());
        offerDto.setQualities(offer.getQualities());
        offerDto.setUsername(offer.getUsername());
        offerDto.setTitle(offer.getTitle());
        offerDto.setType(offer.getType());
        return offerDto;
    }


}
