package it.rand.demo.service;

import java.util.List;
import java.util.Optional;

import it.rand.demo.model.Prodotto;

public interface ProdottoService {

	List<Prodotto> addProdotto(Prodotto p);

	List<Prodotto> removeProdotto(Prodotto p);

	List<Prodotto> getAllProdotto();

	List<Prodotto> getProdottobyDescrizione(String s);

	Optional<Prodotto> getProdottoById(Long idProdotto);

}
