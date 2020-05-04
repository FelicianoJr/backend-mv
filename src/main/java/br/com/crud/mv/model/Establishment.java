package br.com.crud.mv.model;

import br.com.crud.mv.dto.CreateEstablishmnetDto;
import br.com.crud.mv.dto.EstablishmentDto;
import br.com.crud.mv.dto.UpdateEstablishmentDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "establishment")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "{id}")
public class Establishment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public Establishment(CreateEstablishmnetDto createEstablishmnetDto) {
        this.name = createEstablishmnetDto.getName();
        this.address = createEstablishmnetDto.getAddress();
    }

    public Establishment update(UpdateEstablishmentDto updateEstablishmentDto) {
        this.name = updateEstablishmentDto.getName();
        this.address = updateEstablishmentDto.getAddress();
        return this;
    }

    public EstablishmentDto converterDto() {
        EstablishmentDto establishmentDto = new EstablishmentDto();
        establishmentDto.setId(this.id);
        establishmentDto.setName(this.name);
        establishmentDto.setAddress(this.address);
        return establishmentDto;
    }
}
