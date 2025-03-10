package net.azarquiel.japoapi.controller;

import net.azarquiel.japoapi.model.Alergeno;
import net.azarquiel.japoapi.model.Categoria;
import net.azarquiel.japoapi.model.Plato;
import net.azarquiel.japoapi.repositories.AlergenoRepository;
import net.azarquiel.japoapi.repositories.CategoriaRepository;
import net.azarquiel.japoapi.repositories.PedidoRepository;
import net.azarquiel.japoapi.repositories.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/japoapi")
public class Controller {

    // Inyección de dependencias.
    // Este controlador necesita el repository
    @Autowired
    private AlergenoRepository alergenoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PlatoRepository platoRepository;

    // Welcome de nuestra api por ejemplo
    @GetMapping(value = "", produces = "text/html")
    public String get() {
        return """
                <h1>WELCOME</h1>
                """;
    }

    @GetMapping("/platos")
    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }

    @GetMapping(value = "/alergenos")
    public List<Alergeno> getEstaciones() {
        return alergenoRepository.findAll();
    }

    @GetMapping(value = "/categorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }
}