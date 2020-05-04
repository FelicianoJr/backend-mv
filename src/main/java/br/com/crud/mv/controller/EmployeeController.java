package br.com.crud.mv.controller;

import br.com.crud.mv.dto.CreateEmployeeDto;
import br.com.crud.mv.dto.EmployeeDto;
import br.com.crud.mv.dto.UpdateEmployeeDto;
import br.com.crud.mv.model.Employee;
import br.com.crud.mv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateEmployeeDto createEmployeeDto, UriComponentsBuilder componentsBuilder) {
        final Employee employee = employeeService.save(createEmployeeDto);
        UriComponents uriComponents = componentsBuilder.path("/api/v1/employee/{id}").buildAndExpand(employee.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable Long id, @RequestBody UpdateEmployeeDto updateEmployeeDto) {
        return employeeService.update(id, updateEmployeeDto).converterDto();
    }

    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable Long id) {
        return employeeService.findById(id).converterDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/all")
    public List<EmployeeDto> all() {
        return employeeService.findAll()
                .stream()
                .map(Employee::converterDto)
                .collect(Collectors.toList());
    }


}
