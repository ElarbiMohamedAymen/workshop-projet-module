package com.example.demo.entities;

import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String titre;
    private StatusEnum status;

    @ManyToOne
    private ModulePrj module;
}
