package br.com.crud.mv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateEstablishmentDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;
}
