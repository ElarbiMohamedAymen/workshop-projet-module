package com.example.demo.dto;

import com.example.demo.entities.Projet;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDto {

    private String titre;
    private String sujet;

    public Projet toEntity() {
        return Projet.builder()
                .sujet(this.getSujet())
                .titre(this.getTitre())
                .build();
    }

    public static ProjetDto toDto(Projet entity) {
        return ProjetDto.builder()
                .sujet(entity.getSujet())
                .titre(entity.getTitre())
                .build();
    }

}
