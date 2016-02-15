/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basepresentar_aaa;

import static basepresentar_aaa.Clientes.servidor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Anita
 */
public class ReplicacionCola extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReplicacionSns
     */
    String publicadorS,nombrePublicacion;
    
    public ReplicacionCola(String publicador,String nombrePub) {
        initComponents();
            jVisBase.setEnabled(false);
            jVisBase1.setEnabled(false);
            jVisBase2.setEnabled(false);
            
            cbBasesSuscriptores.setEnabled(false);
            cbBasesSuscriptores1.setEnabled(false);
            cbBasesSuscriptores3.setEnabled(false);
            
            jComboBox2.setVisible(false);
            jLabel4.setVisible(false);
   
            publicadorS=publicador;
            nombrePublicacion=nombrePub;
            setTitle("S U S C R I P C I O N  C O L A");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbBasesSuscriptores2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        btnFinalizar = new javax.swing.JButton();
        txtBaseNueva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jVisBase1 = new javax.swing.JButton();
        jVisBase2 = new javax.swing.JButton();
        jcbSuscriptor2 = new javax.swing.JCheckBox();
        jcbSuscriptor3 = new javax.swing.JCheckBox();
        jcbSuscriptor1 = new javax.swing.JCheckBox();
        jVisBase = new javax.swing.JButton();
        cbBasesSuscriptores1 = new javax.swing.JComboBox();
        cbBasesSuscriptores3 = new javax.swing.JComboBox();
        cbBasesSuscriptores = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("Salir");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Replicacion");

        jLabel2.setText("Eliga donde va a correr el Agente de Distribución");

        jLabel3.setText("Subscriptores");

        jLabel4.setText("Inicializar la subscripcion");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inmediatamente", "Primera Sincronización" }));

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre Base Nueva");

        jButton2.setText("CREAR BASE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("BASES");

        jVisBase1.setText("jButton1");
        jVisBase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVisBase1ActionPerformed(evt);
            }
        });

        jVisBase2.setText("jButton1");
        jVisBase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVisBase2ActionPerformed(evt);
            }
        });

        jcbSuscriptor2.setText("TOSHIBA");
        jcbSuscriptor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSuscriptor2ActionPerformed(evt);
            }
        });

        jcbSuscriptor3.setText("JAVY-PC");
        jcbSuscriptor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSuscriptor3ActionPerformed(evt);
            }
        });

        jcbSuscriptor1.setText("ADRIAN");
        jcbSuscriptor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSuscriptor1ActionPerformed(evt);
            }
        });

        jVisBase.setText("jButton1");
        jVisBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVisBaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbSuscriptor1)
                    .addComponent(jcbSuscriptor2)
                    .addComponent(jcbSuscriptor3))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jVisBase2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jVisBase1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jVisBase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbBasesSuscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBasesSuscriptores1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBasesSuscriptores3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbBasesSuscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbBasesSuscriptores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbBasesSuscriptores3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSuscriptor1)
                            .addComponent(jVisBase))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSuscriptor2)
                            .addComponent(jVisBase1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSuscriptor3)
                            .addComponent(jVisBase2))))
                .addContainerGap())
        );

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(21, 21, 21))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtBaseNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap()))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnFinalizar)
                                                .addContainerGap())))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaseNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String suscriptorName;
    private void jVisBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVisBaseActionPerformed
        // TODO add your handling code here:
        suscriptorName=jcbSuscriptor1.getText();
        cbBasesSuscriptores.removeAllItems();
        cargarTablasSuscriptor(cbBasesSuscriptores);
        
    }//GEN-LAST:event_jVisBaseActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        if(jcbSuscriptor1.isSelected()){
            crearSubscripcion(jcbSuscriptor1.getText(),cbBasesSuscriptores.getSelectedItem().toString());
        }
        if(jcbSuscriptor2.isSelected()){
            crearSubscripcion(jcbSuscriptor2.getText(),cbBasesSuscriptores1.getSelectedItem().toString());
        }
        if(jcbSuscriptor3.isSelected()){
           // JOptionPane.showMessageDialog(null, jcbSuscriptor3.getText().toString()+""+cbBasesSuscriptores3.getSelectedItem().toString());
                    
            crearSubscripcion(jcbSuscriptor3.getText(),cbBasesSuscriptores3.getSelectedItem().toString());
        }
        this.dispose();
      //  correrPublicacion();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    void correrPublicacion(){

        String sql="USE msdb ;\n" +
        "EXEC dbo.sp_start_job N'"+Instantanea.nombreJob+"' ;";
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null,"Suscriptor"+suscriptorName);
        Connection cn=cc.conectar(Instantanea.servidor1);
       // escribir(sqlCrearSubs);
        try {
            PreparedStatement psd= cn.prepareStatement(sql);
            psd.execute();
        }catch(SQLException ex){
       //     JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
        //    JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }
    }
    
    
    
    
    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         if(jcbSuscriptor1.isSelected()){
            suscriptorName = jcbSuscriptor1.getText();
            crearBase(txtBaseNueva.getText());
            cbBasesSuscriptores.removeAllItems();
            cargarTablasSuscriptor(cbBasesSuscriptores);
        }
         if(jcbSuscriptor2.isSelected()){
            suscriptorName = jcbSuscriptor2.getText();
            crearBase(txtBaseNueva.getText());
            cbBasesSuscriptores1.removeAllItems();
            cargarTablasSuscriptor(cbBasesSuscriptores1);
        }
         if(jcbSuscriptor3.isSelected()){
            suscriptorName = jcbSuscriptor3.getText();
            crearBase(txtBaseNueva.getText());
            cbBasesSuscriptores3.removeAllItems();
            cargarTablasSuscriptor(cbBasesSuscriptores3);
        }
        
        
       // crearTabla(txtBaseNueva.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jVisBase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVisBase1ActionPerformed
        // TODO add your handling code here:
        suscriptorName=jcbSuscriptor2.getText();
        cbBasesSuscriptores1.removeAllItems();
        cargarTablasSuscriptor(cbBasesSuscriptores1);
    }//GEN-LAST:event_jVisBase1ActionPerformed

    private void jVisBase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVisBase2ActionPerformed
        // TODO add your handling code here:
        suscriptorName=jcbSuscriptor3.getText();
        cbBasesSuscriptores3.removeAllItems();
        cargarTablasSuscriptor(cbBasesSuscriptores3);
    }//GEN-LAST:event_jVisBase2ActionPerformed

    private void jcbSuscriptor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSuscriptor1ActionPerformed
        // TODO add your handling code here:
        if(jcbSuscriptor1.isSelected()){
            jVisBase.setEnabled(true);   
            cbBasesSuscriptores.setEnabled(true);
            
        }else{
            jVisBase.setEnabled(false);
            cbBasesSuscriptores.setEnabled(false);
        }
    }//GEN-LAST:event_jcbSuscriptor1ActionPerformed

    private void jcbSuscriptor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSuscriptor2ActionPerformed
        // TODO add your handling code here:
         if(jcbSuscriptor2.isSelected()){
            jVisBase1.setEnabled(true);   
            cbBasesSuscriptores1.setEnabled(true);
         
        }else{
            jVisBase1.setEnabled(false);
            cbBasesSuscriptores1.setEnabled(false);
        }
    }//GEN-LAST:event_jcbSuscriptor2ActionPerformed

    private void jcbSuscriptor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSuscriptor3ActionPerformed
        // TODO add your handling code here:
         if(jcbSuscriptor3.isSelected()){
            jVisBase2.setEnabled(true);   
            cbBasesSuscriptores3.setEnabled(true);
        }else{
            jVisBase2.setEnabled(false);
            cbBasesSuscriptores3.setEnabled(false);
        }
    }//GEN-LAST:event_jcbSuscriptor3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
        Calendar calobj = Calendar.getInstance();

    
    public void crearSubscripcion(String suscriptor,String lugar){
        String fecha;
        String año;
        String mes;
        String dia;
                año=String.valueOf(calobj.get(Calendar.YEAR));
                mes=String.valueOf(calobj.get(Calendar.MONTH)+1);
                if(Integer.valueOf(mes)<10)
                    mes = "0"+mes;
                dia=String.valueOf(calobj.get(Calendar.DAY_OF_MONTH));
                if(Integer.valueOf(dia)<10)
                    dia = "0"+dia;
               
                fecha=año+mes+dia;
    
                String baseOrigen =cargarBasedePublicaciones(Clientes.servidor1, nombrePublicacion);
        
                
                System.out.println(fecha);
        String va = suscriptor;
       JOptionPane.showMessageDialog(null, "Sucrip"+va);
    String sqlCrearSubs="use ["+baseOrigen+"]\n" +
                        "exec sp_addsubscription @publication = N'"+nombrePublicacion+"', @subscriber = N'"+va+"', @destination_db = N'"+lugar+"', @subscription_type = N'Push', @sync_type = N'automatic', @article = N'all', @update_mode = N'queued failover', @subscriber_type = 0\n" +
                        "exec sp_addpushsubscription_agent @publication = N'"+nombrePublicacion+"', @subscriber = N'"+va+"', @subscriber_db = N'"+lugar+"', @job_login = null, @job_password = null, @subscriber_security_mode = 0, @subscriber_login = N'sa', @subscriber_password = N'sa', @frequency_type = 64, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 4, @frequency_subday_interval = 5, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @dts_package_location = N'Distributor'";
   
        Conexion cc = new Conexion();
        Connection cn=cc.conectar(publicadorS);
        try {
            PreparedStatement psd= cn.prepareStatement(sqlCrearSubs);
            psd.execute();
    //        this.dispose();
        }catch(SQLException ex){
      //      JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
      //      JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }
        
    }
    
    public String cargarBasedePublicaciones(String servidor, String publicacion){
        JOptionPane.showMessageDialog(null, "Ver base");
        String sqlCargarPublicaciones="";
          sqlCargarPublicaciones="Use distribution  SELECT\n" +
"*\n" +
"            FROM\n" +
"                DBO.MSpublications AS MSA\n" +
"            INNER JOIN DBO.MSpublications AS MSP\n" +
"                    ON MSA.publication_id = MSP.publication_id\n" +
"                    AND MSA.publication='"+publicacion+"'";
        Conexion cc = new Conexion();
        Connection cn=cc.conectar(servidor);
        try{
        Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlCargarPublicaciones);
            while(rs.next()){
                return rs.getString("publisher_db");
            }
        }catch(SQLException ex){
       //     JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
       //     JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }
        return null;
    }
    
    
    
    
    
     public void crearSubscripcionDeCola(){
        String fecha="20160131";
        JOptionPane.showMessageDialog(null, Clientes.baseInicial);
        
        String va="ADRIAN";
        
        String sqlCrearSubs="use ["+Clientes.baseInicial+"]\n" +
"exec sp_addsubscription @publication = N'"+nombrePublicacion+"', @subscriber = N'"+va+"', @destination_db = N'"+cbBasesSuscriptores.getSelectedItem()+"', @subscription_type = N'Push', @sync_type = N'automatic', @article = N'all', @update_mode = N'queued failover', @subscriber_type = 0\n" +
"exec sp_addpushsubscription_agent @publication = N'"+nombrePublicacion+"', @subscriber = N'"+va+"', @subscriber_db = N'"+cbBasesSuscriptores.getSelectedItem()+"', @job_login = null, @job_password = null, @subscriber_security_mode = 0, @subscriber_login = N'sa', @subscriber_password = N'sa', @frequency_type = 64, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 4, @frequency_subday_interval = 5, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @dts_package_location = N'Distributor'";
                
                
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null,"Suscriptor"+suscriptorName);
        Connection cn=cc.conectar(publicadorS);
       // escribir(sqlCrearSubs);
        try {
            PreparedStatement psd= cn.prepareStatement(sqlCrearSubs);
            psd.execute();
        }catch(SQLException ex){
     //       JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
     //       JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }
        
    }
    
    
       public void cargarTablasSuscriptor(JComboBox jc){
        //String[] tablas=new String();
        //suscriptorName=cbSuscriptores.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null,"servidor"+suscriptorName);
        char slash=92;
//        suscriptorName="TOSHIBA".concat(String.valueOf(slash)).concat("SITIOA");
      //  Vector tablas=new Vector();
        String sqlTablasSuscriptor="SELECT * FROM master.dbo.sysdatabases WHERE dbid >= 5";
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null,"Suscriptor"+suscriptorName);
        
        Connection cn=cc.conectar(suscriptorName);
        //Connection cn=cc.conectar("TOSHIBA");
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlTablasSuscriptor);
                while(rs.next()){
                   //tablas.addElement(rs.getString("name"));
                  jc.addItem(rs.getString("name"));
                   //JOptionPane.showMessageDialog(null,rs.getString("name"));
                }
                
            }catch(SQLException ex){
      //      JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
      //      JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }
        }
    
    public void crearBase(String baseNueva){
        Conexion cc = new Conexion();
        JOptionPane.showMessageDialog(null,"suscriptor "+suscriptorName);
        Connection cn=cc.conectar(suscriptorName);
        String sql="";
        sql="USE [master]\n" +
            "/****** Object:  Database ["+baseNueva+"]    Script Date: 01/17/2016 19:05:20 ******/\n" +
            "CREATE DATABASE ["+baseNueva+"] ON  PRIMARY \n" +
            "( NAME = N'"+baseNueva+"', FILENAME = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL10.MSSQLSERVER\\MSSQL\\DATA\\"+baseNueva+".mdf' , SIZE = 6144KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )\n" +
            " LOG ON \n" +
            "( NAME = N'"+baseNueva+"_log', FILENAME = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL10.MSSQLSERVER\\MSSQL\\DATA\\"+baseNueva+"_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)\n" +
            "ALTER DATABASE ["+baseNueva+"] SET COMPATIBILITY_LEVEL = 100\n" +
            "IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))\n" +
            "begin\n" +
            "EXEC ["+baseNueva+"].[dbo].[sp_fulltext_database] @action = 'enable'\n" +
            "end\n" +
            "ALTER DATABASE ["+baseNueva+"] SET ANSI_NULL_DEFAULT OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET ANSI_NULLS OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET ANSI_PADDING OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET ANSI_WARNINGS OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET ARITHABORT OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET AUTO_CLOSE OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET AUTO_CREATE_STATISTICS ON \n" +
            "ALTER DATABASE ["+baseNueva+"] SET AUTO_SHRINK OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET AUTO_UPDATE_STATISTICS ON \n" +
            "ALTER DATABASE ["+baseNueva+"] SET CURSOR_CLOSE_ON_COMMIT OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET CURSOR_DEFAULT  GLOBAL \n" +
            "ALTER DATABASE ["+baseNueva+"] SET CONCAT_NULL_YIELDS_NULL OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET NUMERIC_ROUNDABORT OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET QUOTED_IDENTIFIER OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET RECURSIVE_TRIGGERS OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET  DISABLE_BROKER \n" +
            "ALTER DATABASE ["+baseNueva+"] SET AUTO_UPDATE_STATISTICS_ASYNC OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET DATE_CORRELATION_OPTIMIZATION OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET TRUSTWORTHY OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET ALLOW_SNAPSHOT_ISOLATION OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET PARAMETERIZATION SIMPLE \n" +
            "ALTER DATABASE ["+baseNueva+"] SET READ_COMMITTED_SNAPSHOT OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET HONOR_BROKER_PRIORITY OFF \n" +
            "ALTER DATABASE ["+baseNueva+"] SET  READ_WRITE \n" +
            "ALTER DATABASE ["+baseNueva+"] SET RECOVERY FULL \n" +
            "ALTER DATABASE ["+baseNueva+"] SET  MULTI_USER \n" +
            "ALTER DATABASE ["+baseNueva+"] SET PAGE_VERIFY CHECKSUM  \n" +
            "ALTER DATABASE ["+baseNueva+"] SET DB_CHAINING OFF \n" +
            "";
        try {
            PreparedStatement psd= cn.prepareStatement(sql);
            psd.execute();
            JOptionPane.showMessageDialog(null, "Se creo la BASE");
        }catch(SQLException ex){
       //     JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
        //    JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }     
    }
    public void crearTabla(String baseNueva){
        Conexion cc = new Conexion();
        Connection cn=cc.conectar(suscriptorName);
        String sql="";
         Instantanea instan = new Instantanea();
         TransaInstantanea tran = new TransaInstantanea();
         TransaCola tran1 = new TransaCola();
         
         JOptionPane.showMessageDialog(null, instan.columnasMandarTabla);
         JOptionPane.showMessageDialog(null, tran.columnasMandarTabla);
                JOptionPane.showMessageDialog(null, tran1.columnasMandarTabla);
        sql="USE ["+baseNueva+"]\n" +
            "/****** Object:  Table [dbo].[CLIENTES]    Script Date: 01/17/2016 19:13:45 ******/\n" +
            "SET ANSI_NULLS ON\n" +
            "SET QUOTED_IDENTIFIER ON\n" +
            "SET ANSI_PADDING ON\n" +
            "CREATE TABLE [dbo].[CLIENTES](   \n" +
            instan.columnasMandarTabla +
                tran.columnasMandarTabla +
                tran1.columnasMandarTabla +
            " CONSTRAINT [PK_CLIENTES] PRIMARY KEY CLUSTERED \n" +
            "(\n" +
            "	[CI_RENT] ASC\n" +
            ")WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]\n" +
            ") ON [PRIMARY]\n" +
            "";
        try {
          PreparedStatement psd= cn.prepareStatement(sql);
            psd.execute();
            JOptionPane.showMessageDialog(null, "Se creo la TABLA");
        }catch(SQLException ex){
       //     JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();    
        } catch(Exception ex){
        //    JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
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
            java.util.logging.Logger.getLogger(ReplicacionCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReplicacionCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReplicacionCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReplicacionCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ReplicacionSns().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox cbBasesSuscriptores;
    private javax.swing.JComboBox cbBasesSuscriptores1;
    private javax.swing.JComboBox cbBasesSuscriptores2;
    private javax.swing.JComboBox cbBasesSuscriptores3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jVisBase;
    private javax.swing.JButton jVisBase1;
    private javax.swing.JButton jVisBase2;
    private javax.swing.JCheckBox jcbSuscriptor1;
    private javax.swing.JCheckBox jcbSuscriptor2;
    private javax.swing.JCheckBox jcbSuscriptor3;
    private javax.swing.JTextField txtBaseNueva;
    // End of variables declaration//GEN-END:variables
}
