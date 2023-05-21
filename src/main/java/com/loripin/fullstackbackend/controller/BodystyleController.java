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
import com.loripin.fullstackbackend.model.Trim;
import com.loripin.fullstackbackend.repository.BodystyleRepo;
import com.loripin.fullstackbackend.repository.GenerationRepo;
import com.loripin.fullstackbackend.repository.TrimRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class BodystyleController {
    @Autowired
    BodystyleRepo bodystyleRepo;
    @Autowired
    GenerationRepo generationRepo;
    @Autowired
    TrimRepo trimRepo;

    @PostMapping("/catalog/{make}/{model}/{generation}/addBodystyle")
    Bodystyle newBodystyle(@RequestBody Bodystyle newBodystyle,
            @PathVariable Long generation) {
        newBodystyle.setGeneration(generationRepo.findById(generation).get());
        return bodystyleRepo.save(newBodystyle);
    }

    @GetMapping("/catalog/{make}/{model}/{generation}/{facelift}/{bodystyle}")
    List<Trim> openBodystyle(@PathVariable Long bodystyle) {
        return trimRepo.findByBodystyleId(bodystyle);
                 }
}
