package co.ucentral.gestor.tareas.metodologias.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectBoardDTO {
    private List<ProjectColumnDTO> columns;
}