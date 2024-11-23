package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ModulePrj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;

    @ManyToOne
    private Projet projet;

    @OneToMany(mappedBy = "module")
    private Set<Sprint> sprints;
}
