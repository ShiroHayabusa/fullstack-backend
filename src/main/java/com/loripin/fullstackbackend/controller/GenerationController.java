package com.loripin.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loripin.fullstackbackend.model.Facelift;
import com.loripin.fullstackbackend.model.Generation;
import com.loripin.fullstackbackend.repository.FaceliftRepo;
import com.loripin.fullstackbackend.repository.GenerationRepo;
import com.loripin.fullstackbackend.repository.MakeRepo;
import com.loripin.fullstackbackend.repository.ModelRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class GenerationController {
    @Autowired
    GenerationRepo generationRepo;

    @Autowired
    ModelRepo modelRepo;

    @Autowired
    MakeRepo makeRepo;

    @Autowired
    FaceliftRepo faceliftRepo;

    @PostMapping("/catalog/{make}/{model}/addGeneration")
    Generation newGeneration(@RequestBody Generation newGeneration,
            @PathVariable String make,
            @PathVariable String model) {
        newGeneration.setMake(makeRepo.findByName(make));
        newGeneration.setModel(modelRepo.findByName(model));
        return generationRepo.save(newGeneration);
    }

    @GetMapping("/catalog/{make}/{model}/{generation}")
    List<Facelift> openModel(@PathVariable Long generation) {
        return faceliftRepo.findByGenerationId(generation);
                 }
}
