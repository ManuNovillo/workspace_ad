package net.azarquiel.cityapi.api;

import net.azarquiel.cityapi.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Short> {
}