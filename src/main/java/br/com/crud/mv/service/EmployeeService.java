package br.com.crud.mv.service;

import br.com.crud.mv.dto.CreateEmployeeDto;
import br.com.crud.mv.dto.UpdateEmployeeDto;
import br.com.crud.mv.exception.NotFoundException;
import br.com.crud.mv.model.Employee;
import br.com.crud.mv.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(CreateEmployeeDto createEmployeeDto) {
        final Employee employee = new Employee(createEmployeeDto);
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, UpdateEmployeeDto updateEmployeeDto) {
        final Employee employee = findById(id);
        employee.update(updateEmployeeDto);
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Employee getOne(Long id) {
        return employeeRepository.getOne(id);
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
