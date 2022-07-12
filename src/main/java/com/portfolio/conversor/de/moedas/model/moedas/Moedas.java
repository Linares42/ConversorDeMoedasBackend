package com.portfolio.conversor.de.moedas.model.moedas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moedas {

  @JsonProperty("USDBRL")
  public USDBRL uSDBRL;

  @JsonProperty("EURBRL")
  public EURBRL eURBRL;

  @JsonProperty("BTCBRL")
  public BTCBRL bTCBRL;
}
