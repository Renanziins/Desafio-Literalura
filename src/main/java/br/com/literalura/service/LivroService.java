package br.com.literalura.service;

import br.com.literalura.model.LivroResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroService {

    private static final String URL_API = "https://gutendex.com/books/";
    private final ConsumoApi consumoApi;
    private final ObjectMapper objectMapper;

    public LivroService() {
        this.consumoApi = new ConsumoApi();
        this.objectMapper = new ObjectMapper();
    }

    public LivroResponse buscarLivros() {
        try {
            String json = consumoApi.obterDados(URL_API);
            return objectMapper.readValue(json, LivroResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar livros da API", e);
        }
    }
}
