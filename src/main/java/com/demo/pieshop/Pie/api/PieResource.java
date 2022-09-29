package com.demo.pieshop.Pie.api;

import com.demo.pieshop.Pie.model.Pie;
import com.demo.pieshop.Pie.repository.PieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/pie")
public class PieResource {

    // pie repo initialization

    private final PieRepository pieRepository;

    @Autowired
    public PieResource(PieRepository pieRepository) {
        this.pieRepository = pieRepository;
    }

    // pie api controller services

    @GetMapping
    public ResponseEntity<List<Pie>> getAllPies() {
        try {
            List<Pie> allPies = new ArrayList<>(pieRepository.findAll());
            return new ResponseEntity<>(allPies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{pieId}")
    public ResponseEntity<Pie> getPieById(@PathVariable("pieId") Long pieId) {
        Optional<Pie> pieToRetrieve = pieRepository.findById(pieId);
        return pieToRetrieve
                .map(pie -> new ResponseEntity<>(pie, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
