/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String codigo;
    private double precio;
    private String nombre;
    private int cantidad;
    private String tipo;
    private boolean disponibilidad;

    public Filtro() {
    }

    public Filtro(int id, String codigo, double precio, String nombre, int cantidad, String tipo, boolean disponibilidad) {
        this.id = id;
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public Filtro(String codigo, double precio, String nombre, int cantidad, String tipo, boolean disponibilidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }
    
    public Filtro(double precio, String nombre, int cantidad, String tipo, boolean disponibilidad){
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }
    
    public boolean getDisponibilidad(){
        return disponibilidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
}
