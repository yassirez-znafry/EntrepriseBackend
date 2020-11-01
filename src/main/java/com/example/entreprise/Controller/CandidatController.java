package com.example.entreprise.Controller;

import com.example.entreprise.dto.CandidatRequest;
import com.example.entreprise.dto.OfferDto;
import com.example.entreprise.model.Candidat;
import com.example.entreprise.service.CandidatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
public class CandidatController {
    private final CandidatService candidatService;

    @RequestMapping(value = "/api/candidat", method = RequestMethod.POST)
    public ResponseEntity<Candidat> createCandidat(@RequestBody CandidatRequest candidatRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatService.save(candidatRequest));
    }

    @RequestMapping(value = "/api/candidat/{id}", method = RequestMethod.GET)
    public Optional<Candidat> getCandidat(@PathVariable Long id){
        return candidatService.getCandidat(id);
    }


    @RequestMapping(value = "/api/candidat/by-offer/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidat>> getCandidatByOffer(@PathVariable @RequestBody Long id){
        return status(HttpStatus.OK).body(candidatService.getCandidatByOffer(id));
    }


    @RequestMapping(value = "/api/candidat/by-offeror/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Candidat>> getCandidatByOffer(@PathVariable @RequestBody String username){
        return status(HttpStatus.OK).body(candidatService.getCandidatByOfferor(username));
    }


}
