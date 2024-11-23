package com.example.demo.services;

import com.example.demo.dto.ProjetDto;
import com.example.demo.exceptions.ProjetNotFoundException;

import java.util.List;

public interface IProjetService {

    ProjetDto addProjet(ProjetDto projetDto);

    ProjetDto getProjetById(Long id) throws ProjetNotFoundException;

    List<ProjetDto> getAllProjets();

    void deleteProjetById(Long id) throws ProjetNotFoundException;
}
