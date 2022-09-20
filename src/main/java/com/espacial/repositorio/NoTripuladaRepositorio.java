package com.espacial.repositorio;

import com.espacial.modelo.NaveNoTripulada;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoTripuladaRepositorio extends NaveBaseRepositorio <NaveNoTripulada, Long>{

    List<NaveNoTripulada> findByPais(String pais);



}
