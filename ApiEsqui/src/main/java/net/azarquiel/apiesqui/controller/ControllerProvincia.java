package net.azarquiel.apiesqui.controller;

import net.azarquiel.apiesqui.api.ProvinciaRepository;
import net.azarquiel.apiesqui.model.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/apiesqui")
public class ControllerProvincia {

    // Inyección de dependencias.
    // Este controlador necesita el repository
    @Autowired
    ProvinciaRepository repositoryProvincia;
    // Welcome de nuestra api por ejemplo
    @GetMapping(value = "/", produces = "text/html")
    public String get() {
        return """
                <h1 style='text-align: center; background-color: #0000c0; color: #C0C0FF;'>
                    Welcome to Api with SpringBoot - PacoPul
                </h1>
               """;
    }

    @GetMapping(value = "/provincias")
    public List<Provincia> getProvincias() {
        return repositoryProvincia.findAll();
    }

    @GetMapping(value = "/provincia/{id}")
    public Provincia getProvinciaById(@PathVariable short id) {
        return repositoryProvincia.findById(id).orElse(null);
    }
}
