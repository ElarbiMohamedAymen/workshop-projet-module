package com.example.demo.services;

import com.example.demo.dto.ModuleDto;
import com.example.demo.exceptions.ModuleNotFoundException;
import com.example.demo.exceptions.ProjetNotFoundException;

import java.util.List;

public interface IModuleService {

    ModuleDto addModule(ModuleDto moduleDto) throws ProjetNotFoundException;

    ModuleDto getModuleById(Long id) throws ModuleNotFoundException;

    List<ModuleDto> getAllModules();

    void deleteModuleById(Long id) throws ModuleNotFoundException;

}
