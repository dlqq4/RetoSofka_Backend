package com.espacial.modelo;

import com.espacial.IAccionNaves.IAccion;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NaveNoTripulada extends NaveBase implements IAccion {

    @Column(name = "EMPUJE", length = 50, nullable = false)
    private Integer empuje;

    @Column(name = "VELOCIDAD", length = 50, nullable = false)
    private Integer velocidad;

    public NaveNoTripulada() {
    }

    public NaveNoTripulada(Long id, String nombre, String tipo, String pais, String combustible, Integer peso, String imagen, Integer empuje, Integer velocidad) {
        super(id, nombre, tipo, pais, combustible, peso, imagen);
        this.empuje = empuje;
        this.velocidad = velocidad;
    }


    public Integer getEmpuje() {
        return empuje;
    }

    public void setEmpuje(Integer empuje) {
        this.empuje = empuje;
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
        String objetivo = "Estudiar otros cuerpos celestes";
    }

    //METODO INTERFACE IACCION
    @Override
    public void acelerar() {
        String acelera = "Nave sin tripulacion acelerando";
    }

    //METODO INTERFACE IACCION
    @Override
    public void marcarRumbo() {
        String rumbo = "Rumbo a la Órbita de Marte";
    }

}
