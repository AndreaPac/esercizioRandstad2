package it.rand.demo.view;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/prodotto/{idProdotto}")
	public ResponseEntity<Prodotto> getProdottoById(@PathVariable(required = true) long idProdotto) {

		Optional<Prodotto> prodottoOpt = ps.getProdottoById(idProdotto);

		if (prodottoOpt.isPresent()) {
			return new ResponseEntity<>(prodottoOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/prodotto/descrizione/{descrizione}")

	public ResponseEntity<List<Prodotto>> getListaProdottiByDescrizioneLike(@PathVariable String descrizione) {
		List<Prodotto> listaProdotto = ps.getProdottobyDescrizione(descrizione);

		return new ResponseEntity<List<Prodotto>>(listaProdotto, HttpStatus.OK);

	}

}
