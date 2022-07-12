package com.portfolio.conversor.de.moedas.api.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@Component
public class GenericConsumer {

  @Autowired private WebClient.Builder webClientBuilder;

  public Object getObject(String path, String query, Class<?> classType)
      throws UnsupportedEncodingException {

    return webClientBuilder
        .build()
        .get()
        .uri(Objects.requireNonNull(formatURI(path, query)))
        .retrieve()
        .bodyToMono(classType)
        .block();
  }

  public <T> List<T> getList(
      String path, String query, ParameterizedTypeReference<List<T>> typeReference)
      throws UnsupportedEncodingException {
    return webClientBuilder
        .build()
        .get()
        .uri(Objects.requireNonNull(formatURI(path, query)))
        .retrieve()
        .bodyToMono(typeReference)
        .block();
  }

  private URI formatURI(String path, String query) throws UnsupportedEncodingException {
    String urlDecode =
        URLDecoder.decode(path + (query == null ? "" : query), StandardCharsets.UTF_8.name());

    try {

      URL url = new URL(urlDecode);
      return new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
