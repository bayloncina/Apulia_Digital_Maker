package seriea;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the giocatore database table.
 * 
 */
@Entity
@NamedQuery(name="Giocatore.findAll", query="SELECT g FROM Giocatore g")
public class Giocatore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	private String cognome;

	private String nome;

	@Column(name="squadra_name")
	private String squadraName;

	public Giocatore() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSquadraName() {
		return this.squadraName;
	}

	public void setSquadraName(String squadraName) {
		this.squadraName = squadraName;
	}

}