package seriea;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the squadra database table.
 * 
 */
@Entity
@NamedQuery(name="Squadra.findAll", query="SELECT s FROM Squadra s")
public class Squadra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	private String citta;

	private String nomesquadra;

	public Squadra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getNomesquadra() {
		return this.nomesquadra;
	}

	public void setNomesquadra(String nomesquadra) {
		this.nomesquadra = nomesquadra;
	}

}