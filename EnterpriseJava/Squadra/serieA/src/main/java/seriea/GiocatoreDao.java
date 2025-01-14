package seriea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GiocatoreDao {
	@Autowired
	private GiocatoreRepository repo;
	@Autowired
	private SquadraRepository repoTeam;

	public List<Giocatore>findBySquadraName(String nomeTeam) {
		return repo.findBySquadraName(nomeTeam);
	}

	public List<Giocatore> listAll() {
		return repo.findAll();
	}

	public void addGiocatore(Giocatore giocatore) throws Exception {
		if (repoTeam.existsByNomesquadra(giocatore.getSquadraName())) {
			repo.save(giocatore);
		} else {
			throw new Exception("Squadra Inesistente");
		}
	}

	public void deleteGiocatore(Integer id) {
		repo.deleteById(id);
	}
}

