package net.azarquiel.apiesqui.controller;

import net.azarquiel.apiesqui.api.EstacionRepository;
import net.azarquiel.apiesqui.api.ProvinciaRepository;
import net.azarquiel.apiesqui.model.Estacion;
import net.azarquiel.apiesqui.model.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/apiesqui")
public class ControllerEstacion {

    // Inyección de dependencias.
    // Este controlador necesita el repository
    @Autowired
    EstacionRepository repositoryEstacion;
    @GetMapping(value = "/estaciones")
    public List<Estacion> getEstaciones() {
        return repositoryEstacion.findAll();
    }

    @GetMapping(value = "/estacion/{id}")
    public Estacion getEstacionById(@PathVariable short id) {
        return repositoryEstacion.findById(id).orElse(null);
    }
}
