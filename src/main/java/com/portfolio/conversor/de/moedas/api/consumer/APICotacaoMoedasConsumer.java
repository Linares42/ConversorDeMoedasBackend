package com.portfolio.conversor.de.moedas.api.consumer;

import com.portfolio.conversor.de.moedas.model.moedas.Moedas;
import com.portfolio.conversor.de.moedas.model.tabela.Tabela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APICotacaoMoedasConsumer {

  @Value("${endpoint.last.moedas}")
  String endpointLastMoedas;

  @Value("${endpoint.grafico.moedas}")
  String endpointGraficoMoedas;

  @Autowired GenericConsumer genericConsumer;

  public Moedas retornaMoedas() {

    try {
      return (Moedas) genericConsumer.getObject(endpointLastMoedas, null, Moedas.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Tabela> retornaGraficoMoeda() {
    try {

      return genericConsumer.getList(
          endpointGraficoMoedas, null, new ParameterizedTypeReference<List<Tabela>>() {});
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
