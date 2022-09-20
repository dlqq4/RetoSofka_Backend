package com.espacial.repositorio;


import com.espacial.modelo.NaveTripulada;
import com.espacial.modelo.VehiculoLanzadera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoLanzaderaRepositorio extends NaveBaseRepositorio <VehiculoLanzadera, Long>{

    List<VehiculoLanzadera> findByPais(String pais);


}
