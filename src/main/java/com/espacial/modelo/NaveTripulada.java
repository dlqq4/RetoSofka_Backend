package com.espacial.modelo;

import com.espacial.IAccionNaves.IAccion;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity //Defino la entidad con la anotación @Entity
public class NaveTripulada extends NaveBase implements IAccion {


    @Column(name = "PERSONAS", length = 50, nullable = false)
    private Integer Personas;

    @Column(name = "VELOCIDAD", length = 50, nullable = false)
    private Integer velocidad;



    public NaveTripulada() {
    }

    public NaveTripulada(Long id, String nombre, String tipo, String pais, String combustible, Integer peso, String imagen, Integer Personas, Integer velocidad) {
        super(id, nombre, tipo, pais, combustible, peso, imagen);
        this.Personas = Personas;
        this.velocidad = velocidad;

    }

    public Integer getPersonas() {
        return Personas;
    }

    public void setPersonas(Integer Personas) {
        this.Personas = Personas;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }



    //METODO CLASE PADRE ABSTRACTA
    @Override
    public void mision() {
        String objetivo = "Realizar tareas de reparación";
    }

    //METODO INTERFACE IACCION
    @Override
    public void acelerar() {
        String acelera = "Nave tripulada esta acelerando!";
    }

    //METODO INTERFACE IACCION
    @Override
    public void marcarRumbo() {
        String rumbo = "Espacio exterior";
    }

}