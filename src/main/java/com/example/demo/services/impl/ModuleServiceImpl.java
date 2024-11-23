package com.example.demo.services.impl;

import com.example.demo.dto.ModuleDto;
import com.example.demo.dto.ProjetDto;
import com.example.demo.entities.ModulePrj;
import com.example.demo.entities.Projet;
import com.example.demo.exceptions.ModuleNotFoundException;
import com.example.demo.exceptions.ProjetNotFoundException;
import com.example.demo.repositories.ModuleRepository;
import com.example.demo.services.IModuleService;
import com.example.demo.services.IProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements IModuleService {

    private final ModuleRepository moduleRepository;
    private final IProjetService projetService;


    @Override
    public ModuleDto addModule(ModuleDto moduleDto) throws ProjetNotFoundException {
        ModulePrj modulePrj = ModuleDto.toEntity(moduleDto); // transform dto to entity
        ProjetDto projetDto = projetService.getProjetById(moduleDto.getProjetId()); // get project by id
        Projet projet = projetDto.toEntity(); // transform projet to entity

        modulePrj.setProjet(projet);
        modulePrj = moduleRepository.save(modulePrj);
        return ModuleDto.fromEntity(modulePrj);
    }

    @Override
    public ModuleDto getModuleById(Long id) throws ModuleNotFoundException {
        ModulePrj modulePrj = moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);
        return ModuleDto.fromEntity(modulePrj);
    }

    @Override
    public List<ModuleDto> getAllModules() {
        List<ModulePrj> modulePrjs = moduleRepository.findAll();
        return modulePrjs.stream().map(ModuleDto::fromEntity).toList(); // Java 21 or Above
    }

    @Override
    public void deleteModuleById(Long id) throws ModuleNotFoundException {
        getModuleById(id);
        moduleRepository.deleteById(id);

    }
}
