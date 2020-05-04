package br.com.crud.mv.model;

import br.com.crud.mv.dto.WorkTeamDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "work_team")
@Getter
@EqualsAndHashCode(of = "{id}")
@NoArgsConstructor
public class WorkTeam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public void update(Employee employee, Establishment establishment) {
        this.employee = employee;
        this.employee.update(establishment);
    }

    public WorkTeamDto converterDto() {
        final WorkTeamDto workTeamDto = new WorkTeamDto();
        workTeamDto.setEmployeeDto(employee.converterDto());
        return workTeamDto;
    }
}
