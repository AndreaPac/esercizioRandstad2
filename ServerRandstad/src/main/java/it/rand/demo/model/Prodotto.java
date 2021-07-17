package it.rand.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prodotto {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String descrizione;
	@Column
	private long prezzo;

	public Prodotto(Long id, String descrizione, long prezzo) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public Prodotto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public long getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(long prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}

}
