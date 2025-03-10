package net.azarquiel.japoapi.repositories;

import net.azarquiel.japoapi.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato, Short> {
}