package seriea;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/squadre")
public class SerieAController {
	@Autowired
	private SquadraDao squadraDao;

	@Autowired
	private GiocatoreDao giocatoreDao;

	// Visualizzare tutte le squadre
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Squadra> getSquadre() {
		return squadraDao.listAll();
	}

	// Visualizzare tutti i giocatori di una determinata squadra
	@GetMapping(path = "/{nomeTeam}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Giocatore> getGiocatori(@PathVariable("nomeTeam") String nomeTeam) {
		return giocatoreDao.findBySquadraName(nomeTeam);
	}

    //Aggiungere un giocatore solo se la squadra a cui appartiene esiste in database
	@PostMapping(path = "/Giocatore", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addGiocatori(@RequestBody Giocatore giocatore) {

		try {
			giocatoreDao.addGiocatore(giocatore);
			return ResponseEntity.created(null).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	//aggiungere squadra
	@PostMapping(path = "/Squadra", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addSquadra(@RequestBody Squadra squadra) {

		squadraDao.addSquadra(squadra);
		return ResponseEntity.created(null).build();
	}
    //cancellare giocatore
	@DeleteMapping(path = "/Giocatore/{id}")
	public void deleteGiocatore(@PathVariable Integer id) {
		giocatoreDao.deleteGiocatore(id);

	}
}
