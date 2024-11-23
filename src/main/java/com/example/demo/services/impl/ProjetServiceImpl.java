package com.example.demo.services.impl;

import com.example.demo.dto.ProjetDto;
import com.example.demo.entities.Projet;
import com.example.demo.exceptions.ProjetNotFoundException;
import com.example.demo.repositories.ProjetRepository;
import com.example.demo.services.IProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements IProjetService {

    private final ProjetRepository projetRepository;

    @Override
    public ProjetDto addProjet(ProjetDto projetDto) {
        Projet projet = projetDto.toEntity();
        return ProjetDto.toDto(projetRepository.saveAndFlush(projet));
    }

    @Override
    public ProjetDto getProjetById(Long id) throws ProjetNotFoundException {
        Projet foundedProjet = projetRepository.findById(id)
                .orElseThrow(() -> new ProjetNotFoundException(String.format("Projet with id = %s not found", id)));
        return ProjetDto.toDto(foundedProjet);
    }

    @Override
    public List<ProjetDto> getAllProjets() {
        //return projetRepository.findAll().stream().map(ProjetDto::toDto).toList(); // Java 21 and above
        return projetRepository.findAll().stream().map(ProjetDto::toDto).collect(Collectors.toList()); // < Java 21
    }

    @Override
    public void deleteProjetById(Long id) throws ProjetNotFoundException {
        getProjetById(id);
        projetRepository.deleteById(id);
    }
}
