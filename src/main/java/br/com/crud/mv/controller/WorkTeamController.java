package br.com.crud.mv.controller;

import br.com.crud.mv.dto.CreateWorkTeamDto;
import br.com.crud.mv.dto.UpdateWorkTeamDto;
import br.com.crud.mv.dto.WorkTeamDto;
import br.com.crud.mv.model.WorkTeam;
import br.com.crud.mv.service.WorkTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/work-team")
public class WorkTeamController {

    @Autowired
    private WorkTeamService workTeamService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateWorkTeamDto createWorkTeamDto, UriComponentsBuilder componentsBuilder) {
        final WorkTeam workTeam = workTeamService.save(createWorkTeamDto);
        UriComponents uriComponents = componentsBuilder.path("/api/v1/work-team/{id}").buildAndExpand(workTeam.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{id}")
    public WorkTeamDto update(@PathVariable Long id, @RequestBody UpdateWorkTeamDto updateWorkTeamDto) {
        return workTeamService.update(id, updateWorkTeamDto).converterDto();
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        workTeamService.delete(id);
    }

    @GetMapping("/all")
    public List<WorkTeamDto> all() {
        return workTeamService.findAll()
                .stream()
                .map(WorkTeam::converterDto)
                .collect(Collectors.toList());
    }

}
