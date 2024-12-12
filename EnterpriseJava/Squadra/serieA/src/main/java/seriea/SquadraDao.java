package seriea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class SquadraDao {
	@Autowired
	 private SquadraRepository repo;
	
	public List<Squadra> listAll() {
        return repo.findAll();
    }

	public void addSquadra(Squadra squadra) {
		repo.save(squadra);
		
	}
	

}
