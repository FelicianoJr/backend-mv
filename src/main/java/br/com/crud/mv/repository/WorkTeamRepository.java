package br.com.crud.mv.repository;

import br.com.crud.mv.model.WorkTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTeamRepository extends JpaRepository<WorkTeam, Long> {
}
