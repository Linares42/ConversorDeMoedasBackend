package com.portfolio.conversor.de.moedas.model.tabela;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tabela {

  public String code;
  public String codein;
  public String name;
  public String high;
  public String low;
  public String varBid;
  public String pctChange;
  public String bid;
  public String ask;
  public String timestamp;
  public String create_date;
}
