package net.azarquiel.apiesqui.api;

import net.azarquiel.apiesqui.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository<Estacion, Short> {
}