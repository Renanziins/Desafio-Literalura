package br.com.literalura.controller;

import br.com.literalura.model.Autor;
import br.com.literalura.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @PostMapping
    public Autor salvarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
}
