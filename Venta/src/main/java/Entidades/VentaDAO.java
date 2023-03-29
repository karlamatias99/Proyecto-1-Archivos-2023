package Entidades;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class VentaDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Venta v = new Venta();
    int r;

    @Override
   public boolean agregar(Object[] o) {

        String sql = "INSERT INTO controlventas.venta(sucursal,vendedor,cliente,producto,monto_venta)VALUES(?,?,?,?,?)";
        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.setObject(4, o[4]);
            ps.setObject(5, o[5]);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;

    }

    //Metodo para registrar el detalle de la venta.
    public boolean RegistrarDetalle(Object[] o) {
        String sql = "INSERT INTO controlventas.detalleventa(idventa,idprod,cantidad,precio,descuento)VALUES(?,?,?,?,?)";
        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.setObject(4, o[4]);
            ps.setObject(5, o[5]);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;

    }

    //Metodo para generar el numero de venta.
    public int NumVenta() throws SQLException {
        con = cn.Conectar();
        ps = con.prepareStatement("SELECT num_venta FROM controlventas.venta WHERE num_venta = (SELECT MAX(num_venta)FROM controlventas.venta)");
        rs = ps.executeQuery();
        rs.next();
        r = rs.getInt("num_venta");
        return r;
    }

    //Metodo para actualizar la cantidad de productos o Stock en una tienda 
    public boolean ActualizarStock(int cant, String codigo, String sucursal) {
        String sql = "UPDATE controlventas.inventario SET stock=? WHERE producto=? AND sucursal=?";
        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, codigo);
            ps.setString(3, sucursal);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //metodo para listar los productos que generaron mas ingresos  
    public List MasIngresos() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT venta.producto, producto.nombreproducto, "
                + "SUM(venta.monto_venta) FROM controlventas.venta JOIN controlventas.producto ON "
                + "venta.producto = producto.codigo_producto GROUP BY venta.producto, producto.nombreproducto "
                + "ORDER BY SUM(venta.monto_venta)DESC LIMIT 10;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta ve = new Venta();
                ve.setProducto(rs.getString(1));
                ve.setNombre(rs.getString(2));
                ve.setMonto(rs.getDouble(3));

                lista.add(ve);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //metodo para listar los clientes que mas ganancias generan  
    public List ClientesGanancias() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT venta.cliente, cliente.nombre, SUM(venta.monto_venta)"
                + " FROM controlventas.venta JOIN controlventas.cliente ON venta.cliente = cliente.nit "
                + "GROUP BY venta.cliente, cliente.nombre ORDER BY SUM(venta.monto_venta)DESC LIMIT 10;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                //Cliente c = new Cliente();
                VC.setCliente(rs.getString(1));
                VC.setNombre(rs.getString(2));
                VC.setMonto(rs.getDouble(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //metodo para listar las sucursales que mas ganancias generan   
    public List SucursalIngresos() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT venta.sucursal, sucursal.nombreTienda, "
                + "SUM(venta.monto_venta) FROM controlventas.venta "
                + "JOIN controltiendas.sucursal ON venta.sucursal = sucursal.codigo_tienda "
                + "GROUP BY venta.sucursal, sucursal.nombreTienda ORDER BY SUM(venta.monto_venta) DESC;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                VC.setSucursal(rs.getString(1));
                VC.setNombre(rs.getString(2));
                VC.setMonto(rs.getDouble(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //metodo para listar las sucursales que mas ganancias generan   
    public List SucursalVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT venta.sucursal, sucursal.nombreTienda, "
                + "COUNT(*) as total FROM controlventas.venta JOIN controltiendas.sucursal "
                + "ON venta.sucursal = sucursal.codigo_tienda GROUP BY venta.sucursal, sucursal.nombreTienda ORDER BY COUNT(*) DESC;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                VC.setSucursal(rs.getString(1));
                VC.setNombre(rs.getString(2));
                VC.setTotal(rs.getInt(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }
    
    //metodo para listar las sucursales que mas ganancias generan   
     public List EmpleadoIngresos() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT venta.vendedor, empleado.nombre, "
                + "SUM(venta.monto_venta) AS Total_Ventas FROM controlventas.venta "
                + "JOIN controlpersonal.empleado ON venta.vendedor = empleado.codigo_empleado "
                + "GROUP BY venta.vendedor, empleado.nombre ORDER BY SUM(venta.monto_venta)DESC LIMIT 3;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                VC.setVendedor(rs.getString(1));
                VC.setNombre(rs.getString(2));
                VC.setMonto(rs.getDouble(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }
     
    //metodo para listar las sucursales que mas ganancias generan   
     public List EmpleadosVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT venta.vendedor, empleado.nombre, "
                + "COUNT(*) as total FROM controlventas.venta "
                + "JOIN controlpersonal.empleado ON venta.vendedor = empleado.codigo_empleado "
                + "GROUP BY venta.vendedor, empleado.nombre ORDER BY COUNT(*) DESC;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                VC.setVendedor(rs.getString(1));
                VC.setNombre(rs.getString(2));
                VC.setTotal(rs.getInt(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }
    //metodo para listar las sucursales que mas ganancias generan   
       public List ProductoVentaSucursal() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT producto.nombreProducto, sucursal.nombreTienda, "
                + "MAX(detalleventa.cantidad) FROM controlventas.detalleventa JOIN controlventas.producto "
                + "ON detalleventa.idprod = producto.codigo_producto JOIN controlventas.venta "
                + "ON detalleventa.idventa = venta.num_venta JOIN controltiendas.sucursal "
                + "ON venta.sucursal = sucursal.codigo_tienda GROUP BY producto.nombreProducto, sucursal.nombreTienda "
                + "ORDER BY MAX(detalleventa.cantidad) DESC;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                VC.setNombre(rs.getString(1));
                VC.setSucursal(rs.getString(2));
                VC.setTotal(rs.getInt(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }
    //metodo para listar las sucursales que mas ganancias generan   
      public List ProductoIngresosSucursal() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT producto.nombreProducto, sucursal.nombreTienda, "
                + "MAX(venta.monto_venta) FROM controlventas.venta JOIN controlventas.producto "
                + "ON venta.producto = producto.codigo_producto JOIN controltiendas.sucursal "
                + "ON venta.sucursal = sucursal.codigo_tienda GROUP BY producto.nombreProducto, sucursal.nombreTienda "
                + "ORDER BY MAX(venta.monto_venta) DESC;";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta VC = new Venta();
                VC.setNombre(rs.getString(1));
                VC.setSucursal(rs.getString(2));
                VC.setTotal(rs.getInt(3));

                lista.add(VC);
            }

        } catch (Exception e) {
        }
        return lista;
    }
      
    @Override
    public List listaCentral() {
        List<Producto> lista = new ArrayList<>();
        /*SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE inventario.sucursal = '" + sucursal +"'*/
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario ON producto.codigo_producto = inventario.producto";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(8));
                p.setSucural(rs.getString(6));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //Metodos que no utilizare en esta clase 
    @Override
    public List listaSur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listaNorte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listaBodega() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
