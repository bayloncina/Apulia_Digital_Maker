package seriea;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GiocatoreRepository extends JpaRepository<Giocatore, Integer> {
	
	List<Giocatore>findBySquadraName(String nomeTeam);
	
	
	 
	
	

}
