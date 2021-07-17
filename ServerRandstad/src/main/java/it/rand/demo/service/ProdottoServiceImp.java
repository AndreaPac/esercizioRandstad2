package it.rand.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rand.demo.model.Prodotto;
import it.rand.demo.persistance.ProdottoRepository;

@Service
@Transactional
public class ProdottoServiceImp implements ProdottoService {

	@Autowired
	ProdottoRepository pr;

	@Override
	public List<Prodotto> addProdotto(Prodotto p) {
		if (p != null) {
			pr.save(p);
		}
		return getAllProdotto();

	}

	@Override
	public List<Prodotto> removeProdotto(Prodotto p) {
		if (p.getId() != null) {
			pr.deleteById(p.getId());
		}
		return getAllProdotto();
	}

	@Override
	public List<Prodotto> getAllProdotto() {

		return pr.findAll();
	}

	@Override
	public List<Prodotto> getByDescriptionLike(String s) {

		List<Prodotto> f = pr.findDescrizioneLike(s);
		return f;
	}

}
