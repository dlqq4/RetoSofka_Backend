package com.espacial.repositorio;


import com.espacial.modelo.NaveTripulada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripuladaRepositorio extends NaveBaseRepositorio <NaveTripulada, Long>{

    List<NaveTripulada> findByNombre(String nombre);

    List<NaveTripulada> findByPais(String pais);

    //QUERY CON JPQL- AL FINAL NO LA PONGO EN USO
    @Query(value = "SELECT p FROM NaveTripulada p WHERE p.nombre LIKE %:filtro%")
    List<NaveTripulada> busqueda(@Param("filtro") String filtro);

}
