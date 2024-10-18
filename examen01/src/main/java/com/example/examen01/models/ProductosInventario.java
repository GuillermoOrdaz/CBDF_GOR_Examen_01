package com.example.examen01.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos_inventario")
public class ProductosInventario {
   @Id
   private String id;
   private String nombre;
   private int cantidadStock;
   private float precioCompra;
   private  float precioVenta;
   
   public ProductosInventario () {}

    public ProductosInventario(String id, String nombre, int cantidadStock, float precioCompra, float precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

}
