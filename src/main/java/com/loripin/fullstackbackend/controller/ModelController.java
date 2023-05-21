package com.loripin.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loripin.fullstackbackend.model.Generation;
import com.loripin.fullstackbackend.model.Model;
import com.loripin.fullstackbackend.repository.GenerationRepo;
import com.loripin.fullstackbackend.repository.MakeRepo;
import com.loripin.fullstackbackend.repository.ModelRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class ModelController {
    @Autowired
    private ModelRepo modelRepo;

    @Autowired
    private MakeRepo makeRepo;

    @Autowired
    private GenerationRepo generationRepo;

    @GetMapping("/catalog/{make}/{model}")
    List<Generation> openModel(@PathVariable String make,
                    @PathVariable String model) {
        return generationRepo.findByMakeNameAndModelName(make, model);
                 }

    @PostMapping("/catalog/{make}/addModel")
    Model newModel(@RequestBody Model newModel, @PathVariable String make) {
        newModel.setMake(makeRepo.findByName(make));
        return modelRepo.save(newModel);
    }
}
