package br.com.crud.mv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EstablishmentDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY, value="id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;
}
