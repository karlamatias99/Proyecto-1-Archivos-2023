
package Entidades;

/**
 *
 * @author Usuario
 */
public class DetalleVenta {
    int idDetalle;
    int idVenta;
    String producto;
    int cantidad;
    double precio;
    double descuento;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalle, int idVenta, String producto, int cantidad, double precio, double descuento) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    
}

