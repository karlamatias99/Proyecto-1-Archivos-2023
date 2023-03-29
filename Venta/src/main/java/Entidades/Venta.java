
package Entidades;

/**
 *
 * @author Usuario
 */
public class Venta {

    int numVenta;
    String sucursal;
    String vendedor;
    String cliente;
    String producto;
    double monto;
    String nombre;
    int total;

    public Venta() {
    }

    public Venta(int numVenta, String sucursal, String vendedor, String cliente, String producto, double monto, String nombre, int total) {
        this.numVenta = numVenta;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.producto = producto;
        this.monto = monto;
        this.nombre = nombre;
        this.total = total;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

  
    
    
   
}
