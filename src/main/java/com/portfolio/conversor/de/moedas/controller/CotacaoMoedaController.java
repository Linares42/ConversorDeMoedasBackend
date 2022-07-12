package com.portfolio.conversor.de.moedas.controller;

import com.portfolio.conversor.de.moedas.service.ConverterMoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CotacaoMoedaController {

  @Autowired ConverterMoedaService converterMoedaService;

  @GetMapping("/converter/{moeda}/{quantidade}")
  public ResponseEntity<?> getLastMoeda(
      @PathVariable String moeda,
      @PathVariable Double quantidade,
      @RequestParam(required = false) boolean troca) {

    return new ResponseEntity<>(
        converterMoedaService.converterMoeda(moeda, quantidade, troca), HttpStatus.OK);
  }
}
