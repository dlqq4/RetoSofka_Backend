package com.espacial.repositorio;

import com.espacial.modelo.NaveBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


@NoRepositoryBean //DE ESTA INTERFACE NO SE PUEDEN CREAR INSTANCIAS
public interface NaveBaseRepositorio <E extends NaveBase, Long extends Serializable> extends JpaRepository<E, Long> {
    //RECIBE DOS TIPOS E QUE EXTIENDE DE BASENAVE
    //LUEGO ESTA INTERFACE EXTIENDE DE JPA REPOSITORY
}


