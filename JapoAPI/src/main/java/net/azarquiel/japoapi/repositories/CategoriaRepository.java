package net.azarquiel.japoapi.repositories;

import net.azarquiel.japoapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {
}