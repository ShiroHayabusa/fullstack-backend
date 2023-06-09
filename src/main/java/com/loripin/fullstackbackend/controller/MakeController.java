package com.loripin.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loripin.fullstackbackend.exception.UserNotFoundException;
import com.loripin.fullstackbackend.model.Make;
import com.loripin.fullstackbackend.model.Model;
import com.loripin.fullstackbackend.repository.MakeRepo;
import com.loripin.fullstackbackend.repository.ModelRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class MakeController {
    @Autowired
    private MakeRepo makeRepo;

    @Autowired
    private ModelRepo modelRepo;

    @PostMapping("/catalog/addMake")
    Make newMake(@RequestBody Make newMake) {
        return makeRepo.save(newMake);
    }

    @GetMapping("/catalog")
    List<Make> getAllMakes() {
        return makeRepo.findAllByOrderByNameAsc();
    }

    @GetMapping("/catalog/{make}")
    List<Model> openMake(@PathVariable String make) {
        return modelRepo.findByMakeNameOrderByName(make);
    }

    @GetMapping("/makeUpdate/{id}")
    Make getMakeById(@PathVariable Long id) {
        return makeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/makeUpdate/{id}")
    Make updateMake(@RequestBody Make newMake, @PathVariable Long id) {
        return makeRepo.findById(id)
                .map(make -> {
                    make.setName(newMake.getName());
                    return makeRepo.save(make);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/make/{id}")
    String deleteMake(@PathVariable Long id) {
        if (!makeRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        makeRepo.deleteById(id);
        return "Make with id " + id + " has been deleted success";
    }
    
}
