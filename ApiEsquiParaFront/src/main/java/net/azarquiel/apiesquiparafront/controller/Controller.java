package net.azarquiel.apiesquiparafront.controller;

import net.azarquiel.apiesquiparafront.model.Estacion;
import net.azarquiel.apiesquiparafront.model.Provincia;
import net.azarquiel.apiesquiparafront.repositories.EstacionRepository;
import net.azarquiel.apiesquiparafront.repositories.ProvinciaRepository;
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
        return "<h1 style='text-align: center; background-color: #0000c0; " +
                "color: #C0C0FF;'>" +
                "Welcome to Api with SpringBoot - PacoPul</h1>";
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