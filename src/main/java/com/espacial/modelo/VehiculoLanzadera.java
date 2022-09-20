package com.espacial.modelo;


import com.espacial.IAccionNaves.IAccion;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VehiculoLanzadera extends NaveBase implements IAccion {

    @Column(name="EMPUJE",length = 50, nullable = false)
    private Integer empuje;
    @Column(name="POTENCIA",length = 50, nullable = false)
    private Integer potencia;

    @Column(name="CARGA",length = 50, nullable = false)
    private Integer carga;


    public VehiculoLanzadera() {
    }

    public VehiculoLanzadera(Long id, String nombre, String tipo,String pais, String combustible, Integer peso, String imagen, Integer empuje, Integer potencia, Integer carga) {
        super(id, nombre, tipo, pais, combustible, peso, imagen);
        this.empuje = empuje;
        this.potencia = potencia;
        this.carga = carga;

    }

    public Integer getEmpuje () {
        return empuje;
    }

    public void setEmpuje(Integer empuje) {
        this.empuje = empuje;
    }


    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    //METODO CLASE PADRE ABSTRACTA
    @Override
    public void mision() {
        String objetivo = "Lanzar carga útil al espacio!";
    }

    //METODO INTERFACE IACCION
    @Override
    public void acelerar() {
        String acelera = "Vehículo de Lanzadera fuerza máxima!";
    }

    //METODO INTERFACE IACCION
    @Override
    public void marcarRumbo() {
        String rumbo = "Rumbo a la Órbita";
    }
}
