package br.com.crud.mv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WorkTeamDto {

    @JsonProperty("employee")
    private EmployeeDto employeeDto;

    @JsonProperty("establishment")
    private EstablishmentDto establishmentDto;

}
