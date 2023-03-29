/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Bodega {

    String id ;
    String producto ;
    String cant_prod;
    String nombreProd;
    int precio;

    public Bodega() {
    }

    public Bodega(String id, String producto, String cant_prod, String nombreProd, int precio) {
        this.id = id;
        this.producto = producto;
        this.cant_prod = cant_prod;
        this.nombreProd = nombreProd;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCant_prod() {
        return cant_prod;
    }

    public void setCant_prod(String cant_prod) {
        this.cant_prod = cant_prod;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
