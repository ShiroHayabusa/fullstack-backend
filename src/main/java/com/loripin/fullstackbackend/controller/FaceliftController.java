package com.loripin.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loripin.fullstackbackend.model.Bodystyle;
import com.loripin.fullstackbackend.model.Facelift;
import com.loripin.fullstackbackend.repository.BodystyleRepo;
import com.loripin.fullstackbackend.repository.FaceliftRepo;
import com.loripin.fullstackbackend.repository.GenerationRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class FaceliftController {
    @Autowired
    GenerationRepo generationRepo;

    @Autowired
    FaceliftRepo faceliftRepo;

    @Autowired
    BodystyleRepo bodystyleRepo;

    @PostMapping("/catalog/{make}/{model}/{generation}/addFacelift")
    Facelift newFacelift(@RequestBody Facelift newFacelift,
            @PathVariable Long generation) {
        newFacelift.setGeneration(generationRepo.findById(generation).get());
        return faceliftRepo.save(newFacelift);
    }

    @GetMapping("/catalog/{make}/{model}/{generation}/{facelift}")
    List<Bodystyle> openFacelift(@PathVariable Long facelift) {
        return bodystyleRepo.findByFaceliftId(facelift);
    }
}
