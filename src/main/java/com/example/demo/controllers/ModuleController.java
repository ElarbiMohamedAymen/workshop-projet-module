package com.example.demo.controllers;

import com.example.demo.dto.ModuleDto;
import com.example.demo.exceptions.ModuleNotFoundException;
import com.example.demo.exceptions.ProjetNotFoundException;
import com.example.demo.services.IModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/module")
@Log
public class ModuleController {

    private final IModuleService moduleService;

    @PostMapping("/add")
    public ResponseEntity<ModuleDto> addModule(@RequestBody final ModuleDto moduleDto) {
        try {
            return new ResponseEntity<>(moduleService.addModule(moduleDto), HttpStatus.CREATED); // 201 Created
        } catch (ProjetNotFoundException e) {
            log.info(String.format("Projet with id = %s not found", moduleDto.getProjetId()));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<ModuleDto> getModuleById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<>(moduleService.getModuleById(id), HttpStatus.OK); // 200 OK
        } catch (ModuleNotFoundException e) {
            log.info(String.format("Module with id = %s not found", id));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 NOT_FOUND
        }
    }

    @GetMapping("/lister")
    public ResponseEntity<List<ModuleDto>> getAllProjets() {
        return new ResponseEntity<>(moduleService.getAllModules(), HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteModuleById(@PathVariable("id") final Long id) {
        try {
            moduleService.deleteModuleById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ModuleNotFoundException e) {
            log.info(String.format("Module with id = %s not found", id));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 NOT_FOUND
        }
    }
}
