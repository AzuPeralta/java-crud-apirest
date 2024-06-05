package com.azuperalta.apirest.apirest.Entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @Transient // Esto indica a JPA que este campo no debe ser mapeado a la base de datos
    private String nombreComercio;

    // Utilización de Set para asegurar que no haya duplicados y porque no importa
    // el orden.
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ComercioProducto> comercioProductos = new HashSet<>();

    // Getters y setters

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<ComercioProducto> getComercioProductos() {
        return comercioProductos;
    }

    public void setComercioProductos(Set<ComercioProducto> comercioProductos) {
        this.comercioProductos = comercioProductos;
    }
    public String getNombreComercio() {
        return nombreComercio;
    }

    public void setNombreComercio(String nombreComercio) {
        this.nombreComercio = nombreComercio;
    }
}
