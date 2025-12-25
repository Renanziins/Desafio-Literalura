package br.com.literalura.dto;

import java.util.List;

public class RespostaLivrosDTO {
    private List<LivroDTO> livros;

    public List<LivroDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroDTO> livros) {
        this.livros = livros;
    }
}
