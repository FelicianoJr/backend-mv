package br.com.crud.mv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateWorkTeamDto {

    @JsonProperty("employeeId")
    private Long employeeId;

    @JsonProperty("establishmentId")
    private Long establishmentId;
}
