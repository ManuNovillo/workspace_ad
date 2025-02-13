package net.azarquiel.apialumnos.controller;

import net.azarquiel.apialumnos.api.AlumnoRepository;
import net.azarquiel.apialumnos.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping(value = "/", produces = "text/html")
    public String get() {
        return "<h1>Hola</h1>";
    }

    @GetMapping("/alumnos")
    public List<Alumno> getAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/alumno/{id}")
    public Alumno show(@PathVariable Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @PostMapping("/alumno")
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/alumno/{id}")
    public Alumno update(@RequestBody Alumno alumno, @PathVariable Long id) {
        Alumno alumnoActual = alumnoRepository.findById(id).orElse(null);
        if (alumnoActual != null) {
            alumnoActual.setNombre(alumno.getNombre());
            alumnoActual.setApellidos(alumno.getApellidos());
            alumnoActual.setCurso(alumno.getCurso());
            alumnoActual.setNotas(alumno.getNotas());
        }
        return alumnoRepository.save(alumno);
    }

    @DeleteMapping("/alumno/{id}")
    public void delete(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
    }
}
