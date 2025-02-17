package net.azarquiel.apiesqui.api;

import net.azarquiel.apiesqui.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Short> {
}