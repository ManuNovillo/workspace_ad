package net.azarquiel.apiesquiparafront.repositories;

import net.azarquiel.apiesquiparafront.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstacionRepository extends JpaRepository<Estacion, Short> {
    @Query("SELECT e FROM Estacion e WHERE e.provincia.id = :id")
    List<Estacion> getEstacionesByProvincia(@Param("id") int id);
}