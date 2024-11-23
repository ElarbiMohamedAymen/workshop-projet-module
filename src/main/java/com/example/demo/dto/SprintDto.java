package com.example.demo.dto;

import com.example.demo.entities.Sprint;
import com.example.demo.enums.StatusEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprintDto {

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String titre;
    private StatusEnum status;
    private Long moduleId;

    public static SprintDto fromEntity(Sprint sprint) {
        return SprintDto.builder()
                .dateDebut(sprint.getDateDebut())
                .dateFin(sprint.getDateFin())
                .titre(sprint.getTitre())
                .status(sprint.getStatus())
                .build();
    }

    public static Sprint toEntity(SprintDto sprintDto) {
        return Sprint.builder()
                .dateDebut(sprintDto.getDateDebut())
                .dateFin(sprintDto.getDateFin())
                .titre(sprintDto.getTitre())
                .status(sprintDto.getStatus())
                .build();
    }
}
