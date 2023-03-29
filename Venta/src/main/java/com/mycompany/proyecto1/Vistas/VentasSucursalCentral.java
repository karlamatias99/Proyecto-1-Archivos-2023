/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto1.Vistas;

import Entidades.Cliente;
import Entidades.ClienteDAO;
import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.ProductoDAO;
import Entidades.Venta;
import Entidades.VentaDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VentasSucursalCentral extends javax.swing.JFrame {

    Venta v = new Venta();
    VentaDAO VD = new VentaDAO();
    Producto p = new Producto();
    ProductoDAO PD = new ProductoDAO();
    Cliente c = new Cliente();
    ClienteDAO CD = new ClienteDAO();
    DetalleVenta Dv = new DetalleVenta();
    String tienda = Login.tienda;
    String emp = Login.emp;
    String nombre = Login.nombre;
    double descuento;
    int item;
    double totalPagar = 0.00;
    String Prod;
    int IdVenta = VD.NumVenta() + 1;

    DefaultTableModel model = new DefaultTableModel();

    public VentasSucursalCentral() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        //Agrego al Frame el nombre del vendedor y la sucursal a la que tiene acceso
        txtNit.setVisible(true);
        labelVen.setText(emp);
        //labelNombreVend.setText(nombre);
        labelTienda.setText(tienda);
        labelVenta.setText("" + IdVenta);
    }

    //metodo para calcular el total a pagar. 
    private void TotalPagar() {
        totalPagar = 0.00;
        int numFila = tablaVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double subtotal = Double.parseDouble(String.valueOf(tablaVenta.getModel().getValueAt(i, 4)));
            totalPagar = totalPagar + subtotal;
        }
        txtTotal.setText(String.format("%.2f", totalPagar));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNombreCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoPr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        btnEliminarPr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelTienda = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelVen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        txtGuardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        labelVenta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Nit:");

        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNitKeyPressed(evt);
            }
        });

        jLabel11.setText("Direccion:");

        jLabel10.setText("Nombre:");

        jLabel6.setText("Precio");

        jLabel7.setText("Stock Disponible");

        jLabel1.setText("Codigo Producto");

        txtCodigoPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoPrKeyPressed(evt);
            }
        });

        jLabel4.setText("Nombre Producto");

        jLabel5.setText("Cantidad");

        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantKeyPressed(evt);
            }
        });

        btnEliminarPr.setText("Eliminar Producto");
        btnEliminarPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigoPr, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarPr))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPr)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("AREA DE VENTAS SUCURSAL CENTRAL");

        jLabel3.setText("Codigo Tienda:");

        jLabel12.setText("Vendedor:");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tablaVenta);

        txtGuardar.setText("Guardar");
        txtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarActionPerformed(evt);
            }
        });

        jLabel8.setText("Total a Pagar:");

        jLabel13.setText("Venta No:");

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12)
                                .addComponent(labelVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(txtGuardar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnsalir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGuardar))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(12, 12, 12)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(35, 35, 35)
                        .addComponent(labelVen, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(196, 196, 196))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(labelTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelVen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoPrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPrKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodigoPr.getText())) {
                String cod = txtCodigoPr.getText();
                p = PD.BuscarProductoCentral(cod);
                if (p.getNombre() != null) {
                    txtNombre.setText("" + p.getNombre());
                    txtPrecio.setText("" + p.getPrecio());
                    txtStock.setText("" + p.getStock());
                    txtCant.requestFocus();
                    Prod = p.getCodigo();

                } else {
                    LimpiarCampos();
                    txtCodigoPr.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese codigo del producto");
                txtCodigoPr.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoPrKeyPressed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCant.getText())) {
                String cod = txtCodigoPr.getText();
                String nombre = txtNombre.getText();
                int cant = Integer.parseInt(txtCant.getText());
                double precio = Double.parseDouble(txtPrecio.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtStock.getText());

                //verifico que la cantidad a pedir no sobrepase el stock existente
                if (stock >= cant) {
                    item = item + 1;
                    model = (DefaultTableModel) tablaVenta.getModel();

                    for (int i = 0; i < tablaVenta.getRowCount(); i++) {
                        if (tablaVenta.getValueAt(i, 1).equals(txtNombre.getText())) {
                            JOptionPane.showMessageDialog(null, "Este producto ya lo ingreso, pruebe con otro");
                            return;
                        }
                    }
                    ArrayList list = new ArrayList();
                    list.add(item);
                    list.add(cod);
                    list.add(nombre);
                    list.add(cant);
                    list.add(precio);
                    list.add(total);

                    Object[] o = new Object[5];
                    o[0] = list.get(1);
                    o[1] = list.get(2);
                    o[2] = list.get(3);
                    o[3] = list.get(4);
                    o[4] = list.get(5);
                    model.addRow(o);
                    tablaVenta.setModel(model);
                    TotalPagar();
                    LimpiarCampos();
                    txtCodigoPr.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese cantidad para realizar la venta");
            }
        }
    }//GEN-LAST:event_txtCantKeyPressed

    //metodo para registrar la venta en la base de datos. 
    private void RegistrarVenta() {

        for (int i = 0; i < tablaVenta.getRowCount(); i++) {
            String cod = tablaVenta.getValueAt(i, 0).toString();
            String cliente = txtNit.getText();
            double total = totalPagar;

            Object[] ob = new Object[6];
            ob[1] = tienda;
            ob[2] = emp;
            ob[3] = cliente;
            ob[4] = cod;
            ob[5] = total;
            VD.agregar(ob);

        }

    }

    //Eliminar el producto de la lista, antes de realizar la venta 
    private void btnEliminarPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPrActionPerformed
        model = (DefaultTableModel) tablaVenta.getModel();
        model.removeRow(tablaVenta.getSelectedRow());
        TotalPagar();
        txtCodigoPr.requestFocus();
    }//GEN-LAST:event_btnEliminarPrActionPerformed

    //Busco el cliente 
    private void txtNitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtNit.getText())) {
                String nit = txtNit.getText();
                c = CD.BuscarCliente(nit);
                //Si el cliente existe en la base de datos, imprimo los valores en la pantalla
                if (c.getNombre() != null) {
                    txtNombreCli.setText("" + c.getNombre());
                    txtDirecc.setText("" + c.getDireccion());
                    //En caso no exista el cliente, cierro la ventana de ventas y abro la ventana para regristrar o modificar clientes 
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                    this.setVisible(false);
                    VistaCliente vc = new VistaCliente();
                    vc.setVisible(true);
                    LimpiarCampos();
                    txtNit.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el nit del cliente");
                txtNit.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNitKeyPressed

    //Registro la venta en la base de datos, y muestro un mensaje de exito
    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        RegistrarVenta();
        JOptionPane.showMessageDialog(null, "Venta Registrada");
        DetalleVenta();
        ActualizarStock();
        LimpiarCampos();
        limpiarTabla();
    }//GEN-LAST:event_txtGuardarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    //metodo para limpiar los campos una vez terminada la venta. 
    private void LimpiarCampos() {
        txtNit.setText("");
        txtNombreCli.setText("");
        txtDirecc.setText("");
        txtCodigoPr.setText("");
        txtNombre.setText("");
        txtCant.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
    }

    //metodo para guardar el detalle de la venta 
    void DetalleVenta() {

        for (int i = 0; i < tablaVenta.getRowCount(); i++) {
            String cod = tablaVenta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(tablaVenta.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(tablaVenta.getValueAt(i, 3).toString());

            Object[] ob = new Object[6];
            ob[1] = IdVenta;
            ob[2] = cod;
            ob[3] = cant;
            ob[4] = precio;
            ob[5] = Descuento();
            VD.RegistrarDetalle(ob);

        }

    }

    //metodo para aplicar el descuento.
    double Descuento() {
        for (int i = 0; i < tablaVenta.getRowCount(); i++) {
            double precio = Double.parseDouble(tablaVenta.getValueAt(i, 4).toString());

            if (precio == 1000) {
                descuento = (precio * 2) / 100;
            } else if (precio == 5000) {
                descuento = (precio * 5) / 100;
            } else if (precio == 10000) {
                descuento = (precio * 10) / 100;
            }
        }
        return descuento;

    }

    //metodo para actualizar el stock una vez se a realizado una venta 
    void ActualizarStock() {
        for (int i = 0; i < tablaVenta.getRowCount(); i++) {
            String cod = tablaVenta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(tablaVenta.getValueAt(i, 2).toString());
            p = PD.BuscarProducto(cod, tienda);
            int StockActual = (p.getStock() - cant);
            VD.ActualizarStock(StockActual, cod, tienda);

        }
    }

    void limpiarTabla() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentasSucursalCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasSucursalCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasSucursalCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasSucursalCentral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentasSucursalCentral().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentasSucursalCentral.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPr;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTienda;
    private javax.swing.JLabel labelVen;
    private javax.swing.JLabel labelVenta;
    private javax.swing.JTable tablaVenta;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCodigoPr;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCli;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
