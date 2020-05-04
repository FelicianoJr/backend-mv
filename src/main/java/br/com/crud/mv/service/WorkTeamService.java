package br.com.crud.mv.service;

import br.com.crud.mv.dto.CreateWorkTeamDto;
import br.com.crud.mv.dto.UpdateWorkTeamDto;
import br.com.crud.mv.exception.NotFoundException;
import br.com.crud.mv.model.WorkTeam;
import br.com.crud.mv.repository.WorkTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTeamService {

    @Autowired
    private WorkTeamRepository workTeamRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EstablishmentService establishmentService;

    public WorkTeam save(CreateWorkTeamDto dto) {
        final WorkTeam workTeam = new WorkTeam();
        workTeam.update(employeeService.getOne(dto.getEmployeeId()), establishmentService.getOne(dto.getEstablishmentId()));
        return workTeamRepository.save(workTeam);
    }

    public WorkTeam update(Long id, UpdateWorkTeamDto dto) {
        final WorkTeam workTeam = findById(id);
        workTeam.update(employeeService.getOne(dto.getEstablishmentId()), establishmentService.getOne(dto.getEmployeeId()));
        return workTeamRepository.save(workTeam);
    }

    public void delete(Long id) {
        workTeamRepository.deleteById(id);
    }

    public WorkTeam findById(Long id) {
        return workTeamRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<WorkTeam> findAll() {
        return workTeamRepository.findAll();
    }
}
