package net.azarquiel.japoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin

public class Controller {

    // Inyección de dependencias.
    // Este controlador necesita el repository
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private EstacionRepository estacionRepository;

    // Welcome de nuestra api por ejemplo
    @GetMapping(value = "/", produces = "text/html")
    public String get() {
        return
    }

    @GetMapping("/provincias")
    public List<Provincia> getProvincias() {
        return provinciaRepository.findAll();
    }

    @GetMapping(value = "/estaciones")
    public List<Estacion> getEstaciones() {
        return estacionRepository.findAll();
    }

    @GetMapping(value = "/estaciones/provincia/{id}")
    public List<Estacion> getEstacionesByProvincia(@PathVariable Short id) {
        return estacionRepository.getEstacionesByProvincia(id);
    }
}