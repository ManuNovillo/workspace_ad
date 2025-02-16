package net.azarquiel.apialumnos.api;

import net.azarquiel.apialumnos.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {}
