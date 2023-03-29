
package Entidades;

/**
 *
 * @author Usuario
 */
public class Trabajador {
    
    String codigo;
    String nombre;
    String pass;
    int rol;
    String sucursal;

    public Trabajador() {
    }

    public Trabajador(String codigo, String nombre, String pass, int rol, String sucursal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pass = pass;
        this.rol = rol;
        this.sucursal = sucursal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
    
}
