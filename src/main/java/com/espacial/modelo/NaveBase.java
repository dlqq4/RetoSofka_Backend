package com.espacial.modelo;

import javax.persistence.*;


@MappedSuperclass
public abstract class NaveBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NOMBRE", length = 50, nullable = false)
    private String nombre;
    @Column (name="TIPO", length = 50, nullable = false)
    private String tipo;

    @Column (name="PAIS", length = 50, nullable = false)
    private String pais;

    @Column (name="COMBUSTIBLE", length = 50, nullable = false)
    private String combustible;

    @Column (name="PESO", length = 50, nullable = false)
    private Integer peso;

    @Column (name="IMAGEN", length = 100, nullable = false)
    private String imagen;


    public NaveBase() {
    }

    public NaveBase(Long id, String nombre, String tipo, String pais, String combustible, Integer peso, String imagen) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.pais = pais;
        this.combustible = combustible;
        this.peso = peso;
        this.imagen = imagen;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    //Metodo abstracto
    public abstract void mision();


}



