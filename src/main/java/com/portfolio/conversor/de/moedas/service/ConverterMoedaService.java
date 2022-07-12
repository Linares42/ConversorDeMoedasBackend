package com.portfolio.conversor.de.moedas.service;

import com.portfolio.conversor.de.moedas.api.consumer.APICotacaoMoedasConsumer;
import com.portfolio.conversor.de.moedas.model.moedas.Moedas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterMoedaService {

  @Autowired APICotacaoMoedasConsumer apiCotacaoMoedasConsumer;

  public Double converterMoeda(String moeda, Double quantidade, boolean troca) {

    Moedas moedas = apiCotacaoMoedasConsumer.retornaMoedas();

    float cotacaoAlvo = 0.0f;

    switch (moeda) {
      case "USD":
        cotacaoAlvo = Float.parseFloat(moedas.getUSDBRL().getHigh());
        break;

      case "EUR":
        cotacaoAlvo = Float.parseFloat(moedas.getEURBRL().getHigh());
        break;

      case "BTC":
        cotacaoAlvo = Float.parseFloat(moedas.getBTCBRL().getHigh());
        break;
    }

    if (troca) return quantidade / cotacaoAlvo;

    return cotacaoAlvo * quantidade;
  }
}
