package it.rand.demo.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.rand.demo.model.Prodotto;
import it.rand.demo.service.ProdottoService;

@RestController
@CrossOrigin("*")
public class ProdottoController {
	@Autowired
	ProdottoService ps;

	@RequestMapping("/get-all-prodotti")
	@ResponseBody
	public List<Prodotto> getAllProdotto() {
		System.out.println("Siamo in getAllProdotto!");
		return ps.getAllProdotto();
	}

	@RequestMapping("/add-prodotto")
	@ResponseBody
	public List<Prodotto> addProdotto(@RequestBody Prodotto p) {
		System.out.println("Siamo in addProdotto!");
		return ps.addProdotto(p);
	}

	@RequestMapping("/remove-prodotto")
	@ResponseBody
	public List<Prodotto> removeProdotto() {
		System.out.println("Siamo in removeProdotto!");
		return ps.getAllProdotto();
	}

	@RequestMapping("/get-prodotto-by-like/{s}")
	@ResponseBody
	public List<Prodotto> getProdottoByLike(@PathVariable String s) {
		System.out.println("Siamo in getProdottoByLike!");
		return ps.getByDescriptionLike(s);
	}
}
