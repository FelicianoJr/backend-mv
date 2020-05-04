package br.com.crud.mv.model;

import br.com.crud.mv.dto.CreateEmployeeDto;
import br.com.crud.mv.dto.EmployeeDto;
import br.com.crud.mv.dto.EstablishmentDto;
import br.com.crud.mv.dto.UpdateEmployeeDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "{id}")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    public Employee(CreateEmployeeDto createEmployeeDto) {
        this.name = createEmployeeDto.getName();
        this.address = createEmployeeDto.getAddress();
    }

    public void update(UpdateEmployeeDto updateEmployeeDto) {
        this.name = updateEmployeeDto.getName();
        this.address = updateEmployeeDto.getAddress();
    }

    public void update(Establishment establishment) {
        this.establishment = establishment;
    }

    public EmployeeDto converterDto() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(this.id);
        employeeDto.setName(this.name);
        employeeDto.setAddress(this.address);
        if (this.establishment != null) {
            EstablishmentDto establishmentDto = new EstablishmentDto();
            establishmentDto.setAddress(this.establishment.getAddress());
            establishmentDto.setName(this.establishment.getName());
            establishmentDto.setId(this.establishment.getId());
            employeeDto.setEstablishment(establishmentDto);
        }
        return employeeDto;
    }
}
