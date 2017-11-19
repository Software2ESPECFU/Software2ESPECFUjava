/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import com.ecu.Cliente;
import com.ecu.Fecha;
import com.ecu.ModeloCliente;
import com.ecu.ModeloProducto;
import com.ecu.ModeloVenta;
import com.ecu.Producto;
import com.ecu.Venta;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Labs-DECC
 */
public class Ventas extends javax.swing.JFrame {

    /**
     * Creates new form Ventas
     */
    DefaultTableModel modelo;
    ArrayList<Producto> productos;
    Cliente cliente;
    float acumTotal=0.0f;
    
    public Ventas() {
        initComponents();
        modelo = new DefaultTableModel();
        productos = new ArrayList<>();
        cliente = new Cliente();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        tblVenta.setModel(modelo);
        btnRegistrar.setEnabled(false);
        actualizarListaProductos();
        mostrarDatos();
    }
    
    public void mostrarDatos(){
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cod Venta");
        modelo.addColumn("Cedula / Nombres Apellidos Cliente");
        modelo.addColumn("Total Venta");
        modelo.addColumn("Fecha");
        
        
        ModeloVenta mV = new ModeloVenta();
        ArrayList<Venta> ventas = mV.mostrarDatos();
            
        for(Venta v: ventas){
            Object []fila = new Object[4];
            fila[0] = v.getId();
            fila[1] = v.getAux();
            fila[2] = v.getTotal();
            fila[3] = v.getF();
            
            modelo.addRow(fila);
        }
                
        tblDatos.setModel(modelo);
                

    }
    
    private void actualizarListaProductos(){
      
        ModeloProducto mP = new ModeloProducto();
        ArrayList<Producto> productos = mP.mostrarDatos();
        comboProductos.removeAllItems();
        for(Producto p: productos){
            if(p.getCantidad()>0)
                comboProductos.addItem(p.getId()+"->"+p.getNombre()+"->"+p.getMarca()+"->"+p.getPrecio()+"->"+p.getCantidad());
        }
        
        ModeloCliente mC = new ModeloCliente();
        ArrayList<Cliente> clientes = mC.mostrarDatos();
        comboClientes.removeAllItems();
        for(Cliente c: clientes){
            comboClientes.addItem(c.getCod()+"->"+c.getNombres()+"->"+c.getApellidos()+"->"+c.getCedula());
        }
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        comboProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnActualizarListaP = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboClientes = new javax.swing.JComboBox<>();
        txtCliente = new javax.swing.JTextField();
        btnAñadir1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTAS");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("C O N T R O L   V E N T A S");

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProductosItemStateChanged(evt);
            }
        });
        comboProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboProductosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboProductosMouseReleased(evt);
            }
        });
        comboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductosActionPerformed(evt);
            }
        });
        comboProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboProductosKeyReleased(evt);
            }
        });

        jLabel2.setText("Productos Disponibles");

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVenta.setEnabled(false);
        jScrollPane1.setViewportView(tblVenta);

        txtTotal.setEditable(false);

        jLabel3.setText("Total Venta:");

        btnCalcular.setText("Calcular total");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar Venta");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnMenu.setText("Menu Principal");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnActualizarListaP.setText("Actualizar Productos/Clientes");
        btnActualizarListaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarListaPActionPerformed(evt);
            }
        });

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        jLabel4.setText("Clientes Disponibles");

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboClientesItemStateChanged(evt);
            }
        });
        comboClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboClientesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboClientesMouseReleased(evt);
            }
        });
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });
        comboClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboClientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboClientesKeyReleased(evt);
            }
        });

        txtCliente.setEditable(false);

        btnAñadir1.setText("Añadir");
        btnAñadir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnActualizarListaP, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAñadir1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCliente)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAñadir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAñadir1))
                        .addGap(25, 25, 25)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCalcular)
                    .addComponent(btnMenu)
                    .addComponent(btnActualizarListaP))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar Venta", jPanel1);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblDatos);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnMenuPrincipal)
                        .addGap(0, 337, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnMenuPrincipal))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Visualizar Ventas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        
        int cols = modelo.getColumnCount();
        int rows = modelo.getRowCount();
        System.out.println("filas: "+rows+" cols: "+cols);
        
        int idProducto=0;
        
        for(int i=0; i<rows; i++) {
            Producto p = new Producto();
            acumTotal+=(Float.parseFloat(modelo.getValueAt(i, 3).toString()))*(Integer.parseInt(modelo.getValueAt(i, 4).toString()));          
            idProducto=Integer.parseInt(modelo.getValueAt(i, 0).toString());
            p.setId(idProducto);
            p.setCantidad(Integer.parseInt(modelo.getValueAt(i, 4).toString()));
            p.setPrecio(Float.parseFloat(modelo.getValueAt(i, 3).toString()));
            productos.add(p);
            //System.out.println("cod: "+idProducto+" total: "+acumTotal);
        }
        //System.out.println("Total: "+acumTotal);  
        txtTotal.setText("$ "+acumTotal+"");
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        // TODO add your handling code here:
         Principal p = new Principal();
        this.dispose();
        p.show();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
         Principal p = new Principal();
        this.dispose();
        p.show();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void comboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductosActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_comboProductosActionPerformed

    private void btnActualizarListaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarListaPActionPerformed
        // TODO add your handling code here:
        actualizarListaProductos();
    }//GEN-LAST:event_btnActualizarListaPActionPerformed

    private void comboProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProductosItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboProductosItemStateChanged

    private void comboProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboProductosKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_comboProductosKeyPressed

    private void comboProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboProductosKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_comboProductosKeyReleased

    private void comboProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProductosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboProductosMouseClicked

    private void comboProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProductosMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboProductosMouseReleased

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        // TODO add your handling code here:
        //System.out.println((String) comboProductos.getSelectedItem());
        String cad = (String) comboProductos.getSelectedItem();
        String []a = cad.split("->");
        int cant=0;
        do{
            cant= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del "+a[1]+"(s) que desea vender"));
            if(cant<=0 || cant>Integer.parseInt(a[4]))
                JOptionPane.showMessageDialog(this, "La cantida ingresada es incorrecta");
        }while(cant<=0 || cant>Integer.parseInt(a[4]));
        
        
        Object []fila = new Object[5];
            fila[0] = a[0];
            fila[1] = a[1];
            fila[2] = a[2];
            fila[3] = a[3];
            fila[4] = cant;
            
        modelo.addRow(fila);
        tblVenta.setModel(modelo);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Calendar fecha = Calendar.getInstance();
  
        int aa = fecha.get(Calendar.YEAR);
        int dd = fecha.get(Calendar.DAY_OF_MONTH);
        int mm = fecha.get(Calendar.MONTH)+1;
        Fecha f = new Fecha();
        f.setAa(aa); f.setDd(dd); f.setMm(mm);
        
        Venta v = new Venta();
        v.setIdCliente(cliente.getCod());
        v.setTotal(acumTotal);
        v.setFecha(f);
           
        ModeloProducto mP = new ModeloProducto();
        ModeloVenta mV = new ModeloVenta();
        int codVenta = mV.totalVentas()+1;
        
        if(mV.ingresarVenta(v)){
            for(Producto p: productos){
                mV.ingresarDetalle(p.getId(), codVenta, p.getCantidad());
                mP.actualizarStock(p.getCantidad(), p.getId());
            }
            
            JOptionPane.showMessageDialog(null,"Venta ingresada correctamente");
        }else
            JOptionPane.showMessageDialog(null,"Venta no ingresada correctamente");
        
        productos.clear();
        txtTotal.setText("");
        actualizarListaProductos();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void comboClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboClientesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesItemStateChanged

    private void comboClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesMouseClicked

    private void comboClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboClientesMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesMouseReleased

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesActionPerformed

    private void comboClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboClientesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesKeyPressed

    private void comboClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesKeyReleased

    private void btnAñadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadir1ActionPerformed
        // TODO add your handling code here:
        String cad = (String) comboClientes.getSelectedItem();
        String []a = cad.split("->");
        cliente.setCod(Integer.parseInt(a[0]));
        cliente.setNombres(a[1]);
        cliente.setApellidos(a[2]);
        cliente.setCedula(a[3]);
        
        txtCliente.setText(a[3]+": "+a[1]+" "+a[2]);
    }//GEN-LAST:event_btnAñadir1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarListaP;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnAñadir1;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
