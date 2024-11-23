package com.example.demo.dto;

import com.example.demo.entities.ModulePrj;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Sprint;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {

    private String titre;
    private Long projetId;

    public static ModulePrj toEntity(ModuleDto moduleDto) {
        return ModulePrj.builder()
                .titre(moduleDto.getTitre())
                .build();
    }

    public static ModuleDto fromEntity(ModulePrj modulePrj) {
        return ModuleDto.builder()
                .titre(modulePrj.getTitre())
                .build();
    }

}
