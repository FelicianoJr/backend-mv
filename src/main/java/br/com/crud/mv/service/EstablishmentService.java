package br.com.crud.mv.service;

import br.com.crud.mv.dto.CreateEstablishmnetDto;
import br.com.crud.mv.dto.UpdateEstablishmentDto;
import br.com.crud.mv.exception.NotFoundException;
import br.com.crud.mv.model.Establishment;
import br.com.crud.mv.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public Establishment save(CreateEstablishmnetDto createEstablishmnetDto) {
        final Establishment establishment = new Establishment(createEstablishmnetDto);
        return establishmentRepository.save(establishment);
    }

    public Establishment update(Long id, UpdateEstablishmentDto updateEstablishmentDto) {
        final Establishment establishment = findById(id);
        establishment.update(updateEstablishmentDto);
        return establishmentRepository.save(establishment);
    }

    public void delete(Long id) {
        establishmentRepository.deleteById(id);
    }

    public Establishment findById(Long id) {
        return establishmentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Establishment getOne(Long id) {
        return establishmentRepository.getOne(id);
    }


    public List<Establishment> findAll() {
        return establishmentRepository.findAll();
    }

}
