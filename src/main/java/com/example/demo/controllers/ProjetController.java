package com.example.demo.controllers;

import com.example.demo.dto.ProjetDto;
import com.example.demo.exceptions.ProjetNotFoundException;
import com.example.demo.services.IProjetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projet")
@Log
public class ProjetController {

    private final IProjetService projetService;

    @PostMapping("/add")
    public ResponseEntity<ProjetDto> addProjet(@RequestBody final ProjetDto projetDto) {
        return new ResponseEntity<>(projetService.addProjet(projetDto), HttpStatus.CREATED); // 201 Created
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<ProjetDto> getProjetById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<>(projetService.getProjetById(id), HttpStatus.OK); // 200 OK
        } catch (ProjetNotFoundException e) {
            log.info(String.format("Projet with id = %s not found", id));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 NOT_FOUND
        }
    }

    @GetMapping("/lister")
    public ResponseEntity<List<ProjetDto>> getAllProjets() {
        return new ResponseEntity<>(projetService.getAllProjets(), HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteProjetById(@PathVariable("id") final Long id) {
        try {
            projetService.deleteProjetById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProjetNotFoundException e) {
            log.info(String.format("Projet with id = %s not found", id));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 NOT_FOUND
        }
    }
}
