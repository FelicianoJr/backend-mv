package br.com.crud.mv.controller;

import br.com.crud.mv.dto.CreateEstablishmnetDto;
import br.com.crud.mv.dto.EmployeeDto;
import br.com.crud.mv.dto.EstablishmentDto;
import br.com.crud.mv.dto.UpdateEstablishmentDto;
import br.com.crud.mv.model.Establishment;
import br.com.crud.mv.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/establishment")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateEstablishmnetDto createEstablishmnetDto,
                                       UriComponentsBuilder uriComponentsBuilder) {

        final Establishment establishment = establishmentService.save(createEstablishmnetDto);
        UriComponents uriComponents = uriComponentsBuilder.path("/api/v1/establishment/{id}").buildAndExpand(establishment.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{id}")
    public EstablishmentDto update(@PathVariable Long id, @RequestBody UpdateEstablishmentDto updateEstablishmentDto) {
        return establishmentService.update(id, updateEstablishmentDto).converterDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        establishmentService.delete(id);
    }

    @GetMapping("/{id}")
    public EstablishmentDto findById(@PathVariable Long id) {
        return establishmentService.findById(id).converterDto();
    }

    @GetMapping("/all")
    public List<EstablishmentDto> all() {
        return establishmentService.findAll()
                .stream()
                .map(Establishment::converterDto)
                .collect(Collectors.toList());
    }
}
