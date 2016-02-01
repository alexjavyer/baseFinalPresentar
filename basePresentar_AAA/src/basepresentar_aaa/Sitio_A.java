/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basepresentar_aaa;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sony vaio
 */
public class Sitio_A extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    //Prueba
    DefaultTableModel model;
    public static String servidor="";
    public Sitio_A() {
        initComponents();
        setTitle("Sitio_A");
    }
    
    public Sitio_A(String servidor){
        initComponents();
        //CargarTabla(servidor);
        System.out.println("Sitio A  "+servidor);
        setTitle(servidor);
    }
    public void Insertar(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase("ADRIAN\\SITIO_A", "Renta de Autos");
        String sql="";
        int fila=jtbDatos.getSelectedRow();
        System.out.println(jtbDatos.getSelectedRow());
        String cedula,nombre,apellido,telefono;
        cedula=(String) jtbDatos.getValueAt(fila, 0); 
        nombre=(String) jtbDatos.getValueAt(fila, 1);
        apellido=(String) jtbDatos.getValueAt(fila, 2); 
        telefono=(String) jtbDatos.getValueAt(fila, 3);
        sql="insert into CLIENTES (CI_RENT,NOM_RENT,APE_RENT,TEL_RENT) values(?,?,?,?)";
        try{
        PreparedStatement psd = cn.prepareStatement(sql);
        psd.setString(1, cedula);
        psd.setString(2, nombre);
        psd.setString(3, apellido);
        psd.setString(4, telefono);
        int n = psd.executeUpdate();
        if(n>0){
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            CargarTabla(servidor);
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }        
    }
    public void Actualizar(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase("ADRIAN\\SITIO_A", "Renta de Autos");
        String sql="";
        int fila=jtbDatos.getSelectedRow();
        try {
            sql="update clientes set NOM_RENT='"+jtbDatos.getValueAt(fila, 1)+"',APE_RENT='"+jtbDatos.getValueAt(fila, 2)+"',TEL_RENT='"+jtbDatos.getValueAt(fila, 3)+"'where CI_RENT='"+jtbDatos.getValueAt(fila, 0)+"'";
            PreparedStatement psd= cn.prepareStatement(sql);
            int n= psd.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null, "Se Actualizo Correctamente");
                CargarTabla(servidor);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void Eliminar (){
        if(JOptionPane.showConfirmDialog(null,"Estas Seguro que Deseas borrar El Dato","Borrar Registro",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase("ADRIAN\\SITIO_A", "Renta de Autos");
        String sql="";
        int fila=jtbDatos.getSelectedRow();
        sql="delete from clientes where CI_RENT='"+jtbDatos.getValueAt(fila, 0)+"'";
        try {
            PreparedStatement psd=cn.prepareStatement(sql);
            int n=psd.executeUpdate();
            if(n>0){
                //JOptionPane.showMessageDialog(null, "Se Borro Correctamente");
                CargarTabla(servidor);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }
    public void CargarTabla(String servidor){
        String []titulos={"CEDULA","NOMBRE","APELLIDO","TELEFONO"};
        String [] registros=new String [4];
        String [] vacio=new String [4];
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, "Renta de Autos");
        model = new DefaultTableModel(null,titulos);
        String sql="";
        sql="select * from clientes";
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("CI_RENT");
                registros[1]=rs.getString("NOM_RENT");
                registros[2]=rs.getString("APE_RENT");
                registros[3]=rs.getString("TEL_RENT");
                model.addRow(registros);
            }
            model.addRow(vacio);
            jtbDatos.setModel(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void S_Pull_Cont_Inme(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase("ADRIAN\\SITIO_A", "Renta_Auto_Sitio_A");
        String sql="";
        sql="-----------------INICIO: script que se ejecutará en el suscriptor 'ADRIAN\\SITIO_A'-----------------\n" +
"use [Renta_Auto_Sitio_A]\n" +
"exec sp_addpullsubscription @publisher = N'ADRIAN', @publication = N'Pub_Instantanea_Renta_Autos', @publisher_db = N'Renta de Autos', @independent_agent = N'True', @subscription_type = N'pull', @description = N'', @update_mode = N'read only', @immediate_sync = 1\n" +
"\n" +
"exec sp_addpullsubscription_agent @publisher = N'ADRIAN', @publisher_db = N'Renta de Autos', @publication = N'Pub_Instantanea_Renta_Autos', @distributor = N'ADRIAN', @distributor_security_mode = 1, @distributor_login = N'', @distributor_password = null, @enabled_for_syncmgr = N'False', @frequency_type = 64, @frequency_interval = 0, @frequency_relative_interval = 0, @frequency_recurrence_factor = 0, @frequency_subday = 0, @frequency_subday_interval = 0, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 20160115, @active_end_date = 99991231, @alt_snapshot_folder = N'', @working_directory = N'', @use_ftp = N'False', @job_login = null, @job_password = null, @publication_type = 0\n" +
"-----------------FIN: script que se ejecutará en el suscriptor 'ADRIAN\\SITIO_A'-----------------\n" +
"";
        try {
            Statement psd= cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
//            while(rs.next()){
//                registros[0]=rs.getString("AUTPLACA");
//                registros[1]=rs.getString("AUTMARCA");
//                registros[2]=rs.getString("AUTCOLOR");
//                registros[3]=rs.getString("AUTMODELO");
//                registros[4]=rs.getString("AUTANO");
//                registros[5]=rs.getString("AUTCAPACIDAD");
//                registros[6]=rs.getString("AUTOBSERVACION");
//                registros[7]=rs.getString("URL");
//                model.addRow(registros);
//            }
            JOptionPane.showMessageDialog(null, "Se creo la subscripcion");
            jtbDatos.setModel(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
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

        Usuario = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        cmbServidores = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnInstantanea = new javax.swing.JMenuItem();
        jmnTransaccional = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnConectar = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jmnSInstantanea = new javax.swing.JMenuItem();

        jLabel1.setText("Nombre del servidor");

        cmbServidores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADRIAN", "ADRIAN\\SITIO_A", "ADRIAN\\SITIO_B" }));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout UsuarioLayout = new javax.swing.GroupLayout(Usuario.getContentPane());
        Usuario.getContentPane().setLayout(UsuarioLayout);
        UsuarioLayout.setHorizontalGroup(
            UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar)
                    .addComponent(jLabel1))
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsuarioLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(cmbServidores, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UsuarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        UsuarioLayout.setVerticalGroup(
            UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbServidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtbDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbDatos);

        jLabel5.setText("Nombre");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox1.setText("A");

        jCheckBox2.setText("B");

        jCheckBox3.setText("C");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Nombre");

        jButton4.setText("Sincronizar");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(68, 68, 68)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Replicaciones");

        jmnInstantanea.setText("Instantanea");
        jmnInstantanea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnInstantaneaActionPerformed(evt);
            }
        });
        jMenu1.add(jmnInstantanea);

        jmnTransaccional.setText("Transaccional");
        jMenu1.add(jmnTransaccional);

        jMenuItem3.setText("Mezcla");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        mnConectar.setText("Conectar");
        mnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConectarActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnConectar);

        jMenu3.setText("Subscripciones");

        jmnSInstantanea.setText("Instantaneas");
        jmnSInstantanea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSInstantaneaActionPerformed(evt);
            }
        });
        jMenu3.add(jmnSInstantanea);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        Insertar();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        servidor=cmbServidores.getSelectedItem().toString();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jmnInstantaneaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnInstantaneaActionPerformed
        // TODO add your handling code here:
        Instantanea in=new Instantanea();
        in.show();
        in.setVisible(true);
    }//GEN-LAST:event_jmnInstantaneaActionPerformed

    private void jmnSInstantaneaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSInstantaneaActionPerformed
        // TODO add your handling code here:
        S_Pull_Cont_Inme();
    }//GEN-LAST:event_jmnSInstantaneaActionPerformed

    private void mnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConectarActionPerformed
        // TODO add your handling code here:
        Servidor ser = new Servidor();
        ser.setExtendedState(MAXIMIZED_BOTH);
        ser.setVisible(true);
    }//GEN-LAST:event_mnConectarActionPerformed

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
            java.util.logging.Logger.getLogger(Sitio_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sitio_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sitio_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sitio_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sitio_A().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Usuario;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox cmbServidores;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem jmnInstantanea;
    private javax.swing.JMenuItem jmnSInstantanea;
    private javax.swing.JMenuItem jmnTransaccional;
    private javax.swing.JTable jtbDatos;
    private javax.swing.JMenu mnConectar;
    // End of variables declaration//GEN-END:variables
}
