package com.example.entreprise.Controller;


import com.example.entreprise.dto.OfferDto;
import com.example.entreprise.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers/")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity createOffer(@RequestBody OfferDto offerDto) {
        offerService.createOffer(offerDto);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<OfferDto>> showAllOffers() {
        return new ResponseEntity<>(offerService.showAllOffers(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OfferDto> getSingleOffer(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(offerService.readSingleOffer(id), HttpStatus.OK);
    }
}
