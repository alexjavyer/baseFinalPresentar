/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basepresentar_aaa;

import static basepresentar_aaa.Clientes.baseInicial;
import static basepresentar_aaa.Instantanea.nombreJob;
import static basepresentar_aaa.Instantanea.servidor1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Anita
 */
public class MergeSubcripcion extends javax.swing.JFrame {

    /**
     * Creates new form MergeSubcripcion
     */
    DefaultTableModel modeloTabSubs=new DefaultTableModel();
    DefaultListModel modeloSubs=new DefaultListModel();
    DefaultListModel modeloBasesLista=new DefaultListModel();
    String servidor1;
    String baseDePublicacion="";
    public MergeSubcripcion(String servidor) {
        initComponents();
        servidor1=servidor;
        cargarPublicaciones(servidor1);
    }
    public void cargarBasedePublicaciones(String servidor, String publicacion){
        
        String sqlCargarPublicaciones="";
//                "Use distribution \n" +
//            "\n" +
//            "DECLARE @ArticleName SysName\n"+
//            "\n" +
//            "SELECT\n" +
//            "    MSA.publisher_db AS 'Database Name'\n" +
//            "FROM\n" +
//            "    DBO.MSarticles AS MSA\n" +
//            "INNER JOIN DBO.MSpublications AS MSP\n" +
//            "        ON MSA.publication_id = MSP.publication_id"
//                + " AND publication='"+publicacion+"' \n" ;
        
          sqlCargarPublicaciones="Use distribution  SELECT\n" +
"*\n" +
"            FROM\n" +
"                DBO.MSpublications AS MSA\n" +
"            INNER JOIN DBO.MSpublications AS MSP\n" +
"                    ON MSA.publication_id = MSP.publication_id\n" +
"                    AND MSA.publication='"+publicacion+"'";
        cbBasedeDatos.removeAllItems();
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, baseInicial);
        try{
        Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlCargarPublicaciones);
            while(rs.next()){
                cbBasedeDatos.addItem(rs.getString("publisher_db"));
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex+ "Error al cargar publicacion");
        }
    }
    public void cargarPublicaciones(String servidor){
        
        String sqlCargarPublicaciones="Use distribution \n" +
            "\n" +
            "DECLARE @ArticleName SysName\n"+
            "\n" +
            "SELECT\n" +
            "     MSP.publication AS 'Publication Name'\n" +
            "    ,MSA.publisher_db AS 'Database Name'\n" +
            "    ,MSA.article AS 'Article Name'\n" +
            "    ,MSA.source_owner AS 'Schema Name'\n" +
            "    ,MSA.source_object AS 'Table Name'\n" +
            "FROM\n" +
            "    DBO.MSarticles AS MSA\n" +
            "INNER JOIN DBO.MSpublications AS MSP\n" +
            "        ON MSA.publication_id = MSP.publication_id\n" ;
        String descripcion="";
//        descripcion="'Transactional publication of database ''"+cbBasedeDatos.getSelectedItem()+"'' from Publisher ''"+servidor+"''.'";
//        descripcion="Snapshot publication of database 'ANITA' from Publisher 'TOSHIBA'.";
        descripcion="'%Merge publication of database %'";
        sqlCargarPublicaciones="Use distribution  SELECT\n" +
"           *\n" +
"            FROM\n" +
"                DBO.MSpublications AS MSA\n" +
"            INNER JOIN DBO.MSpublications AS MSP\n" +
"                    ON MSA.publication_id = MSP.publication_id"
                + " AND MSA.description LIKE "+descripcion;
        
        cbPublicaciones.removeAllItems();
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, baseInicial);
        try{
        Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlCargarPublicaciones);
            while(rs.next()){
                cbPublicaciones.addItem(rs.getString("publication"));
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex+ "Error al cargar publicacion");
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
        cbSubscriptores = new javax.swing.JComboBox();
        btnOtroSubs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlSubscriptores = new javax.swing.JList();
        cbBases = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlBases = new javax.swing.JList();
        btnSelecBase = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtAgente = new javax.swing.JTable();
        btnAddAgent = new javax.swing.JButton();
        btnCrearSubs = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbPublicaciones = new javax.swing.JComboBox();
        cbBasedeDatos = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        btnCrearBase = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Subscriptores");

        cbSubscriptores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOSHIBA", "ADRIAN", "JAVY-PC" }));

        btnOtroSubs.setText("Añadir");
        btnOtroSubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroSubsActionPerformed(evt);
            }
        });

        jlSubscriptores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSubscriptoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlSubscriptores);

        jScrollPane2.setViewportView(jlBases);

        btnSelecBase.setText("Seleccionar");
        btnSelecBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecBaseActionPerformed(evt);
            }
        });

        jtAgente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtAgente);

        btnAddAgent.setText("Siguiente");
        btnAddAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAgentActionPerformed(evt);
            }
        });

        btnCrearSubs.setText("Crear Subs");
        btnCrearSubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSubsActionPerformed(evt);
            }
        });

        jLabel2.setText("Base de Datos");

        jLabel3.setText("Publicacion");

        cbPublicaciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPublicacionesItemStateChanged(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCrearBase.setText("CrearBase");
        btnCrearBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBaseActionPerformed(evt);
            }
        });

        jButton1.setText("Quitar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearSubs))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbBasedeDatos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbPublicaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                                    .addComponent(btnAddAgent))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnOtroSubs)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(cbSubscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCrearBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbBases, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSelecBase))
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbSubscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnOtroSubs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbBases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSelecBase))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrearBase)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(btnAddAgent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbBasedeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearSubs)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtroSubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroSubsActionPerformed
        añadirSubscriptor();
    }//GEN-LAST:event_btnOtroSubsActionPerformed

    private void jlSubscriptoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSubscriptoresMouseClicked
        // TODO add your handling code here:
        cargarBases(jlSubscriptores.getSelectedValue().toString());
    }//GEN-LAST:event_jlSubscriptoresMouseClicked

    private void btnSelecBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecBaseActionPerformed
         cargarBasesLista();
    }//GEN-LAST:event_btnSelecBaseActionPerformed

    private void btnAddAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAgentActionPerformed
        // TODO add your handling code here:
            llenarTabla();
    }//GEN-LAST:event_btnAddAgentActionPerformed

    private void btnCrearSubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSubsActionPerformed
        // TODO add your handling code here:
            CrearSubscripcion();
    }//GEN-LAST:event_btnCrearSubsActionPerformed

    private void cbPublicacionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPublicacionesItemStateChanged
        // TODO add your handling code here:
            //JOptionPane.showMessageDialog(null, "Cargar Base de la Publicacion");
            cargarBasedePublicaciones(servidor1, cbPublicaciones.getSelectedItem().toString());
    }//GEN-LAST:event_cbPublicacionesItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Clientes cli=new Clientes(servidor1);
        cli.show();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnCrearBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBaseActionPerformed
        // TODO add your handling code here:
        //"Crear Base de Datos",
        String nombreBaseNueva=JOptionPane.showInputDialog("Escriba el nombre de la base de datos nueva: ");
        //if(String.valueOf(JOptionPane.YES_OPTION)==nombreBaseNueva){
            crearBase(nombreBaseNueva);
        //}
        
        
    }//GEN-LAST:event_btnCrearBaseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modeloBasesLista.removeElementAt(jlBases.getSelectedIndex());
    }//GEN-LAST:event_jButton1ActionPerformed
    public void crearBase(String baseNueva){
        Conexion cc = new Conexion();
        String subscriptor="";
        subscriptor=jlSubscriptores.getSelectedValue().toString();
        //JOptionPane.showMessageDialog(null,"suscriptor "+suscriptorName);
        Connection cn=cc.conectar(subscriptor);
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
            JOptionPane.showMessageDialog(null, "Creación de base exitosa!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }     
    }
    public void CrearSubscripcion(){
        String sqlCrearSubs="";
        String frequency_type="";//continously="";
        String active_end_time_of_day="";
        
        Calendar calobj = Calendar.getInstance();
        String active_start_date ="";
        String dia, mes, año,fecha="";
        String subscriber_type="";
        String active_end_date="";
        
       //firstsyncro.. --> active_end_time_of_day=0
        //inmediately --> active_end_time_of_day=235959
        for(int j=0;j<modeloSubs.getSize();j++){
            
            
            String frecuency_type="",subscription_priority="";
            //runOndemand --> subscriber_type='1'
            //runContinuosly --> subscriber_type='64'
            if(modeloTabSubs.getValueAt(j, 3).equals("Ejecutar Continuamente")){
                //runCont
                //Ejecutar Continuamente
                
                frecuency_type=" 64 ";
                active_end_time_of_day="235959";
                año=String.valueOf(calobj.get(Calendar.YEAR));
                mes=String.valueOf(calobj.get(Calendar.MONTH)+1);
                dia=String.valueOf(calobj.get(Calendar.DAY_OF_MONTH));
                fecha=año+mes+dia;
                active_start_date=fecha;
                JOptionPane.showMessageDialog(null,"Presiono Ejecutar Continuamente "+modeloTabSubs.getValueAt(j, 3)+" active_star_date= "+active_start_date);
            }else{
                //runOndemand
                frecuency_type=" 1 ";
                active_end_date = "19950101";
                active_start_date =" 0 ";
                active_end_time_of_day =" 0 ";
            }
            if(modeloTabSubs.getValueAt(j, 4).equals("Primera Sincronización")){
                active_end_time_of_day=" 0 ";
                //active_start_date=" 0 ";
                
            }else{
                //$$$$Inmediatamente
                
                //df.format(calobj.getTime();
              
                
            }
            if(modeloTabSubs.getValueAt(j, 4)=="Servidor"){
                subscriber_type="Global";
                subscription_priority=modeloTabSubs.getValueAt(j, 5).toString();
            }else{
                subscriber_type="Local";
                subscription_priority="0";
            }
            //Subscriptor con contraseña
            String subscriber_security_mode =" 0 ",subscriber_login=",@subscriber_login = N'sa'",
                    subscriber_password=", @subscriber_password = N'sa'";
            //Subscriptor sin contraseña
            //String subscriber_security_mode =" 1 ";
            
           String sqlSeguridad=subscriber_login+subscriber_password;
           sqlCrearSubs=sqlCrearSubs+"use ["+cbBasedeDatos.getSelectedItem()+"]\n" +
            "exec sp_addmergesubscription @publication = N'"+cbPublicaciones.getSelectedItem()+"', @subscriber = N'"+modeloSubs.getElementAt(j)+"', @subscriber_db = N'"+modeloBasesLista.getElementAt(j)+"',"
            + " @subscription_type = N'Push', @sync_type = N'Automatic', @subscriber_type = N'"+subscriber_type+"', @subscription_priority = "+subscription_priority+","
            + " @description = null, @use_interactive_resolver = N'False' \n" +
            "exec sp_addmergepushsubscription_agent @publication = N'"+cbPublicaciones.getSelectedItem()+"', @subscriber = N'"+modeloSubs.getElementAt(j)+"', @subscriber_db = N'"+modeloBasesLista.getElementAt(j)+"',"
            + " @job_login = null, @job_password = null, @subscriber_security_mode = "+subscriber_security_mode+sqlSeguridad+", @publisher_security_mode = 1, @frequency_type = 64,"
            + " @frequency_interval = 0, @frequency_relative_interval = 0, @frequency_recurrence_factor = 0, @frequency_subday = 0, "
            + "@frequency_subday_interval = 0, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = "+active_start_date+", "
            + "@active_end_date = 99991231, @enabled_for_syncmgr = N'False'";
        }
      //  escribir(sqlCrearSubs);
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null,"Suscriptor"+suscriptorName);
        
        Connection cn=cc.conectarBase(servidor1,cbBasedeDatos.getSelectedItem().toString());
        boolean seCreo=true;
       // escribir(sqlCrearSubs);
        try {
            Statement psd = cn.createStatement();
            psd.executeQuery(sqlCrearSubs);
            }catch(Exception ex){
//                JOptionPane.showMessageDialog(null,"Error al crear subscripcion merge"+ex);
//                seCreo=false;
                       if(ex.getMessage().equals("La instrucción no devolvió un conjunto de resultados.")){
                            seCreo=true;
                        }else{
                           
              JOptionPane.showMessageDialog(null,"Error al crear publicacion Merge"+ex);
              seCreo=false;
            }
    
            }
    if(seCreo){
        correrPublicacion();
        JOptionPane.showMessageDialog(null,"Subscripción creada correctamente");
        Clientes cli=new Clientes(servidor1);
        cli.show();
        
        this.dispose();
    }
    }
     String seleccionaJob(){
     String sql="";
     JOptionPane.showMessageDialog(null,"Seleccionando Job");
        sql = "SELECT  name \n" +
              "FROM    msdb.dbo.sysjobs J\n" +
              "WHERE   name like '%"+cbBasedeDatos.getSelectedItem()+"-"+cbPublicaciones.getSelectedItem()+"%'\n" + "";
            Conexion cc = new Conexion();
            Connection cn=cc.conectar(servidor1);

             try {
                    Statement psd1 = cn.createStatement();
                    ResultSet rs1=psd1.executeQuery(sql);
                    while(rs1.next()){
                        nombreJob=(rs1.getString("name"));
                        JOptionPane.showMessageDialog(null,"Nombre del job "+nombreJob);
                        return nombreJob;
                        
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex+"al cargar tabla");
                }   
             return "";
    }
    void correrPublicacion(){
    JOptionPane.showMessageDialog(null,"Corriendo el agente");
        
            String sql="USE msdb ;\n" +
            "EXEC dbo.sp_start_job N'"+seleccionaJob()+"' ;";
            Conexion cc = new Conexion();
            //JOptionPane.showMessageDialog(null,"Suscriptor"+suscriptorName);
            Connection cn=cc.conectar(servidor1);
           // escribir(sqlCrearSubs);
            try {
                Statement psd = cn.createStatement();
                psd.executeQuery(sql);
                }catch(Exception ex){
                    if(ex.getMessage()=="La instrucción no devolvió un conjunto de resultados."){
      //                  JOptionPane.showMessageDialog(null,"Publicacion corriendo");
                    }else{
                JOptionPane.showMessageDialog(null,"Error al crear la subscripción"+ex);
                }
            }
    }
    
    public void escribir(String codigo){
        File f;
        f = new File("C:\\Users\\Anita\\Desktop\\SCRIPTS\\SUB_MERGE_TOSHIBA.txt");
        //Escritura
        try{
        FileWriter w = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);	
        wr.write(codigo);
        wr.close();
        bw.close();
        }catch(IOException e){};
    }
    public void llenarTabla(){
        String agent[]=new String[2];
        String combo[]={"Ejecutar Continuamente","Ejecutar bajo demanda"};
        String ini[]={"Inmediatamente","Primera Sincronización"};
        String tipoS[]={"Cliente","Servidor"};
        JComboBox cbAgent=new JComboBox(combo);
        JComboBox cbInicializacion=new JComboBox(ini);
        JComboBox cbTipos=new JComboBox(tipoS);
        modeloTabSubs.addColumn("Subscriptor");
        modeloTabSubs.addColumn("Agente");
        modeloTabSubs.addColumn("Inicialización");
        modeloTabSubs.addColumn("Tipo Subs");
        modeloTabSubs.addColumn("Prioridad Res. Conf.");
        for(int k=0;k<modeloSubs.getSize();k++){
            agent[0]=modeloSubs.getElementAt(k).toString();
            modeloTabSubs.addRow(agent);
        }
        jtAgente.setModel(modeloTabSubs);
        TableColumn col=jtAgente.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(cbAgent));
        TableColumn col2=jtAgente.getColumnModel().getColumn(2);
        col2.setCellEditor(new DefaultCellEditor(cbInicializacion));
        TableColumn col3=jtAgente.getColumnModel().getColumn(3);
        col3.setCellEditor(new DefaultCellEditor(cbTipos));
        
        
    }
    public void cargarBasesLista(){
        
        modeloBasesLista.addElement(cbBases.getSelectedItem().toString());
        jlBases.setModel(modeloBasesLista);
    }
    public void cargarBases(String servidor){
         //  JOptionPane.showMessageDialog(null, "Servidor "+servidor);
        String sqlTablasSuscriptor="SELECT name FROM master.dbo.sysdatabases WHERE dbid >= 5";
        cbBases.removeAllItems();
        
        boolean correcto=true;
        Conexion cc = new Conexion();
    //     JOptionPane.showMessageDialog(null, "Servidor "+servidor);
        Connection cn=cc.conectarBase(servidor,"Renta de Auto");
        //Connection cn=cc.conectar("TOSHIBA");
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlTablasSuscriptor);
                while(rs.next()){
                   cbBases.addItem(rs.getString("name"));
                //   JOptionPane.showMessageDialog(null,"name "+rs.getString("name"));
                }
                
            }catch(Exception ex){
                correcto=false;
                JOptionPane.showMessageDialog(null,"Error "+ex+" Suscriptor"+servidor);
            }
        
        
                
    }
    public void añadirSubscriptor(){
        modeloSubs.addElement(cbSubscriptores.getSelectedItem().toString());
        jlSubscriptores.setModel(modeloSubs);
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
            java.util.logging.Logger.getLogger(MergeSubcripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MergeSubcripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MergeSubcripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MergeSubcripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MergeSubcripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAgent;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearBase;
    private javax.swing.JButton btnCrearSubs;
    private javax.swing.JButton btnOtroSubs;
    private javax.swing.JButton btnSelecBase;
    private javax.swing.JComboBox cbBasedeDatos;
    private javax.swing.JComboBox cbBases;
    private javax.swing.JComboBox cbPublicaciones;
    private javax.swing.JComboBox cbSubscriptores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList jlBases;
    private javax.swing.JList jlSubscriptores;
    private javax.swing.JTable jtAgente;
    // End of variables declaration//GEN-END:variables
}
