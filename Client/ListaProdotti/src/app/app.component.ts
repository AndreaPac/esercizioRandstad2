import { Component } from '@angular/core';
import { Prodotto } from './prodotto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ProdottoRequest } from './prodotti-request';
import { ProdottoResponse } from './prodotti-response';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  prodotto = new Prodotto();
  prodotti: Prodotto[] = [];
  ;


constructor(private http : HttpClient) { }

  addProdotto() {
    if (this.prodotto.id != null && this.prodotto.descrizione != null && this.prodotto.prezzo != null) {
      ;
      let req = new ProdottoRequest();
      req.prodotto = this.prodotto;
      let ox: Observable<ProdottoResponse> = this.http
        .post<ProdottoResponse>("http://localhost:8080/addProdotto",
          req);
      ox.subscribe(r => {
        this.prodotti = r.listaProdotti;
      });
      this.prodotto = new Prodotto();
    }
  }
  removeProdotto(p: Prodotto) {
    let req = new ProdottoRequest();
    req.prodotto = p;
    let oss = this.http.post<ProdottoResponse>("http://localhost:8080/removeProdotto", req);
    oss.subscribe(r => {
      this.prodotti = r.listaProdotti;
    });
  }
}


function addProdotto() {
  throw new Error('Function not implemented.');
}

