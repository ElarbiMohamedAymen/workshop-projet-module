package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String sujet;

    @OneToMany(mappedBy = "projet", fetch = FetchType.LAZY)
    private Set<ModulePrj> modulePrjs;
}
