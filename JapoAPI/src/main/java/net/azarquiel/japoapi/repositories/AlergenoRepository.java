package net.azarquiel.japoapi.repositories;

import net.azarquiel.japoapi.model.Alergeno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlergenoRepository extends JpaRepository<Alergeno, Short> {
}