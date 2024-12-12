package seriea;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadraRepository extends JpaRepository <Squadra, Integer>{

	boolean existsByNomesquadra(String squadraName);

}
