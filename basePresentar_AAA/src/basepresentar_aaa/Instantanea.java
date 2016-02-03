/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basepresentar_aaa;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author Anita
 */
public class Instantanea extends javax.swing.JInternalFrame {

    /**
     * Creates new form Instantanea
     */
    static String servidor1;
    String servidor2;
    DefaultListModel model;
    String sqlFiltro;
    public Instantanea()
            {
               initComponents();
        this.setFocusable(true);     
         setTitle("P U B L I C A C I O N  S N A P S H O T");
            }
    
    
   
    public Instantanea(String servidor) {
        initComponents();
        cargarTabla(servidor);
        servidor1=servidor;
        this.setFocusable(true);
                 setTitle("P U B L I C A C I O N  S N A P S H O T");
       // servidor2="JAVY-PC";
    }
    String tiempo,intervalo;
    
    public void cargarTabla(String servidor){
        //String sql ="SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = BASE TABLE AND TABLE_SCHEMA=dbName";
        String sql ="USE ["+Clientes.baseInicial+"]\n" +
            "SELECT name FROM sysobjects where xtype='U' and name='Clientes' ";
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, Clientes.baseInicial);
        model = new DefaultListModel();
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            while(rs.next()){
                model.addElement(rs.getString("name"));
            }
            jlTablasBase.setModel(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+"al cargar tabla");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jlTablasBase = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombrePublicacion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jcTiempo1 = new javax.swing.JComboBox();
        jcTiempo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jlTablasBase);

        jLabel1.setText("Tablas:");

        jLabel4.setText("Nombre de la Publicacion");

        txtNombrePublicacion.setText("pub_instantanea_");

        jButton2.setText("Listo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tiempo", "Inmediatamente" }));

        jLabel3.setText("Snapshot Agent");

        jcTiempo1.setEnabled(false);
        jcTiempo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTiempo1ActionPerformed(evt);
            }
        });

        jcTiempo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIEMPO", "segundos", "minutos", "horas" }));
        jcTiempo.setEnabled(false);
        jcTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jcTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcTiempo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcTiempo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jButton6.setText("Cargar Campos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "T/F", "Campo", "Condición", "Igualdad"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton3.setText("Crear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombrePublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem()=="Tiempo"){
          // SheduleInstantanea si=new SheduleInstantanea();
          // si.setVisible(true);
          // jDesktopPane1.add(si);
            jcTiempo.setEnabled(true);
            jcTiempo1.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        filtrosTabla();
        publicacionFiltros(txtNombrePublicacion.getText());
        crearPublicacion();
        correrPublicacion();
//        crearPub();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jcTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTiempoActionPerformed
        // TODO add your handling code here:
        if(jcTiempo.getSelectedItem()=="segundos"){
            intervalo = "2";
            jcTiempo1.removeAllItems();

            for(int i=10;i<60;i++){
                jcTiempo1.addItem(i);
            }
        }else{
            if(jcTiempo.getSelectedItem()=="minutos"){
                intervalo = "4";
                jcTiempo1.removeAllItems();

                for(int i=1;i<60;i++){
                    jcTiempo1.addItem(i);
                }
            }else{
                if(jcTiempo.getSelectedItem()=="horas"){
                    intervalo = "8";
                    jcTiempo1.removeAllItems();

                    for(int i=1;i<=12;i++){
                        jcTiempo1.addItem(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_jcTiempoActionPerformed

    private void jcTiempo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTiempo1ActionPerformed
        // TODO add your handling code here:
        tiempo = jcTiempo1.getSelectedItem().toString();
    }//GEN-LAST:event_jcTiempo1ActionPerformed

    public static final String[] DATA = { "=",">","<",">=","<=","like","<>" };
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        cargarAtributos();
        
        JCheckBox check = new JCheckBox();
        TableColumn tc1 = jTable1.getColumnModel().getColumn(0);
        TableCellEditor tce1 = new DefaultCellEditor(check);
        tc1.setCellEditor(tce1);
        
        JComboBox comboBox = new JComboBox(DATA);
        TableColumn tc = jTable1.getColumnModel().getColumn(2);
        TableCellEditor tce = new DefaultCellEditor(comboBox);
        tc.setCellEditor(tce);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
      public void crearPub(){
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null, "El servidor "+servidor1);
        //Connection cn=cc.conectarBase(servidor1, "Renta de Autos");
        //String servidor33="TOSHIBA".concat("'\'").concat("PRINCIPAL");
        Connection cn=cc.conectarBase(servidor1, "Renta de Auto");
        String sqlCrearPublicacion="";
        sqlCrearPublicacion="-- Enabling the replication database\n" +
"use master\n" +
"exec sp_replicationdboption @dbname = N'"+Clientes.baseInicial+"', @optname = N'publish', @value = N'true'\n" +

"\n" +
"-- Adding the snapshot publication\n" +
"use ["+Clientes.baseInicial+"]\n" +
"exec sp_addpublication @publication = N'Pub_11', @description = N'Snapshot publication of database ''"+Clientes.baseInicial+"'' from Publisher ''TOSHIBA''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'true', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'snapshot', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1\n" +

"\n" +
"\n" +
"exec sp_addpublication_snapshot @publication = N'Pub_11', @frequency_type = 1, @frequency_interval = 0, @frequency_relative_interval = 0, @frequency_recurrence_factor = 0, @frequency_subday = 0, @frequency_subday_interval = 0, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 1\n" +
"\n" +
"\n" +
"use ["+Clientes.baseInicial+"]\n" +
"exec sp_addarticle @publication = N'Pub_11', @article = N'Clientes', @source_owner = N'dbo', @source_object = N'Clientes', @type = N'logbased', @description = null, @creation_script = null, @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509D, @identityrangemanagementoption = N'manual', @destination_table = N'Clientes', @destination_owner = N'dbo', @vertical_partition = N'false'\n" +

"\n" +
"\n" +
"\n" +
"";
        //JOptionPane.showMessageDialog(null, "sentencia sql "+sqlCrearPublicacion);
        try {
            Statement psd= cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlCrearPublicacion);
            //sS_Pull_Cont_Inme();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+"Reportar");
        }

    }
    
      public void crearPublicacion(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor1, Clientes.baseInicial);
        String sqlCrearPublicacion="";
        String frequency_type="1",frequency_interval="0",frequency_relative_interval="0",frequency_subday="0",frequency_subday_interval="0",nombrePub="";
        String sqlFiltro="";
        String nombreTabla;
        nombreTabla=jlTablasBase.getSelectedValue().toString();
        nombrePub=txtNombrePublicacion.getText();
        String sqlParte4="",sqlParte5="",sqlFiltroCol1="",sqlFiltroCol2="";
        boolean verticalPartition=false;
        boolean conFiltros=true;
        boolean allowAnonymous=true;
        boolean inmediateSync=true;

        if(jComboBox1.getSelectedItem().equals("Tiempo")){   
            if(jcTiempo.getSelectedItem().equals("segundos")){
            frequency_type="4";
            frequency_interval="1";
            frequency_relative_interval="1";
            frequency_subday=intervalo;
            frequency_subday_interval=tiempo;
            }else{
            if(jcTiempo.getSelectedItem().equals("horas")){
                frequency_type="4";
                frequency_interval="1";
                frequency_relative_interval="1";
                frequency_subday=intervalo;
                frequency_subday_interval=tiempo;
            }else{
                frequency_type="4";
                frequency_interval="1";
                frequency_relative_interval="1";
                frequency_subday=intervalo;
                frequency_subday_interval=tiempo;
            }
            }
            
        }
        
        
        sqlCrearPublicacion="use master\n" +
                            "exec sp_replicationdboption @dbname = N'"+Clientes.baseInicial+"', @optname = N'publish', @value = N'true' \n" +
                            "\n" +
                            "-- Adding the snapshot publication\n" +
                            "use ["+Clientes.baseInicial+"]\n" +
                            "exec sp_addpublication @publication = N'"+nombrePub+"', @description = N'Snapshot publication of database ''"+Clientes.baseInicial+"'' from Publisher ''"+servidor1+"''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'true', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'snapshot', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1 \n" +
                            "exec sp_addpublication_snapshot @publication = N'"+nombrePub+"', @frequency_type = "+frequency_type+", @frequency_interval = "+frequency_interval+", @frequency_relative_interval = "+frequency_relative_interval+", @frequency_recurrence_factor = 0, @frequency_subday = "+frequency_subday+", @frequency_subday_interval = "+frequency_subday_interval+", @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 1 \n" +
                            "exec sp_grant_publication_access @publication = N'"+nombrePub+"', @login = N'sa' \n" +
                            "exec sp_grant_publication_access @publication = N'"+nombrePub+"', @login = N'NT AUTHORITY\\SYSTEM' \n" +
                            "exec sp_grant_publication_access @publication = N'"+nombrePub+"', @login = N'JAvy-PC\\JAvy' \n" +
                            "exec sp_grant_publication_access @publication = N'"+nombrePub+"', @login = N'NT SERVICE\\SQLSERVERAGENT' \n" +
                            "exec sp_grant_publication_access @publication = N'"+nombrePub+"', @login = N'NT SERVICE\\MSSQLSERVER' \n" +
                            "exec sp_grant_publication_access @publication = N'"+nombrePub+"', @login = N'distributor_admin' \n" +
                            "use ["+Clientes.baseInicial+"] \n" +
                            "exec sp_addarticle @publication = N'"+nombrePub+"', @article = N'CLIENTES', @source_owner = N'dbo', @source_object = N'CLIENTES', @type = N'logbased', @description = N'', @creation_script = N'', @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509D, @identityrangemanagementoption = N'none', @destination_table = N'CLIENTES', @destination_owner = N'dbo', @status = 24, @vertical_partition = N'true', @ins_cmd = N'SQL', @del_cmd = N'SQL', @upd_cmd = N'SQL' \n" +             
                            filtros +"  "+ filtroFilas +"  "+ filtroS ;
        boolean exitosa=true;
        try {
            Statement psd= cn.createStatement();
            psd.executeQuery(sqlCrearPublicacion);
        }catch(Exception ex){
            if(ex.getMessage()=="La instrucción no devolvió un conjunto de resultados."){
                JOptionPane.showMessageDialog(null, "Publicacion Creada!");
                exitosa=true;
            }else{
            JOptionPane.showMessageDialog(null, ex);
              exitosa=false;
            }
        }
    }

    DefaultTableModel modeloR;
    public void cargarAtributos(){
    String sql="";

    String nomTabla=jlTablasBase.getSelectedValue().toString();
    sql="SELECT COLUMN_NAME\n" +
        "FROM ["+Clientes.baseInicial+"].INFORMATION_SCHEMA.COLUMNS\n" +
        "WHERE TABLE_NAME = N'Clientes'";
    String [] ListaColumnas=new String[4];
    Conexion cc = new Conexion();
    Connection cn=cc.conectarBase(servidor1, Clientes.baseInicial);
    //model1 = new DefaultTableModel(null,titulos);
    int i=0;
  //  modeloR=new DefaultTableModel();
     try {
            Statement psd1 = cn.createStatement();
            ResultSet rs1=psd1.executeQuery(sql);
            while(rs1.next()){
                
                 //JOptionPane.showMessageDialog(null,rs1.getString("COLUMN_NAME"));
                jTable1.setValueAt(rs1.getString("COLUMN_NAME"),i,1);
               // modeloR.addElement(rs1.getString("COLUMN_NAME"));
                i++;
            }
     //      jTable1.setModel(modeloR);
            //tbFiltro.setModel(modelR);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+"al cargar tabla");
        }
        
    }
    DefaultTableModel model1;
    public void filtrarColumna(){
//        int tamaño=modeloR.size();
//        String []titulo=new String[tamaño];
//        sqlFiltro="SELECT "+txtFiltro.getText()+" FROM "+jlTablasBase.getSelectedValue();
//        JOptionPane.showMessageDialog(null, "Filtro Columna sql: "+sqlFiltro);
    }
    public void filtrarFila(){
//        sqlFiltro="SELECT * FROM "+jlTablasBase.getSelectedValue()+" "
//                + "where "+cbCampos.getSelectedItem()+" "+cbSigno.getSelectedItem()+" '"+txtFiltro1.getText()+"'";
//        JOptionPane.showMessageDialog(null, "Filtro Fila sql: "+sqlFiltro);
    }
    public void escribir(String codigo){
        File f;
        f = new File("C:\\Users\\Anita\\Documents\\DOCUMENTOS\\UNIVERSIDAD\\SEMESTRES\\6. SEXTO\\SBD DISTRIBUIDOS\\Segundo Parcial\\Proyecto\\GenerandoPubSnap\\ProbandoSnapshot.txt");

        //Escritura
        try{
        FileWriter w = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);	
        wr.write(codigo);//escribimos en el archivo 
        //wr.append(" - y aqui continua"); //concatenamos en el archivo sin borrar lo existente
                      //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
                      //de no hacerlo no se escribirá nada en el archivo
        wr.close();
        bw.close();
        }catch(IOException e){};
    }
 
   public static  String nombreJob="";
    
    void seleccionaJob(){
     String sql="";
        sql = "SELECT  name \n" +
              "FROM    msdb.dbo.sysjobs J\n" +
              "WHERE   name like '%"+Clientes.baseInicial+"-"+txtNombrePublicacion.getText()+"%'\n" + "";
    
    
    Conexion cc = new Conexion();
    Connection cn=cc.conectar(servidor1);

     try {
            Statement psd1 = cn.createStatement();
            ResultSet rs1=psd1.executeQuery(sql);
            while(rs1.next()){
                nombreJob=(rs1.getString("name"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+"al cargar tabla");
        }   
    }
    
    void correrPublicacion(){
        seleccionaJob();
        String sql="USE msdb ;\n" +
        "EXEC dbo.sp_start_job N'"+nombreJob+"' ;";
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
    
    
    // filtros
    public static String columnasMandarTabla = "";
    String filtros,filtroFilas,filtroS;
  public void filtrosTabla(){
        
        String cedula, nombre, apellido, telefono;
        String Fcedula, Fnombre, Fapellido, Ftelefono;
        
        if(jTable1.getValueAt(0, 0).toString().equals("true")){
         cedula= "[CI_RENT] [nchar](10) NOT NULL,";
         Fcedula="exec sp_articlecolumn @publication = N'"+txtNombrePublicacion.getText()+"', @article = N'CLIENTES', @column = N'CI_RENT', @operation = N'add', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
         
        }else{
            cedula="";
            Fcedula="";
        }
        if(jTable1.getValueAt(1, 0).toString().equals("true")){
        nombre= "[NOM_RENT] [varchar](15) NULL,";
               Fnombre="exec sp_articlecolumn @publication = N'"+txtNombrePublicacion.getText()+"', @article = N'CLIENTES', @column = N'NOM_RENT', @operation = N'add', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
      
        }
        else{
            nombre="";
            Fnombre="";
        }
        if(jTable1.getValueAt(2, 0).toString().equals("true")){
        apellido= "[APE_RENT] [varchar](15) NULL,";
               Fapellido="exec sp_articlecolumn @publication = N'"+txtNombrePublicacion.getText()+"', @article = N'CLIENTES', @column = N'APE_RENT', @operation = N'add', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
      
        }else{
            apellido="";
            Fapellido="";
        }
        if(jTable1.getValueAt(3, 0).toString().equals("true")){
        telefono= "[TEL_RENT] [int] NULL,";
        Ftelefono="exec sp_articlecolumn @publication = N'"+txtNombrePublicacion.getText()+"', @article = N'CLIENTES', @column = N'TEL_RENT', @operation = N'add', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
      
        }else{
            telefono="";
            Ftelefono="";
        }
        columnasMandarTabla = cedula+""+nombre+""+apellido+""+telefono;
        filtros = Fcedula+""+Fnombre+""+Fapellido+""+Ftelefono;
             
    }
  int contador;
  
  public void publicacionFiltros(String publicacion){
        String FFcedula, FFnombre, FFapellido, FFtelefono;
        FFcedula= "";FFnombre= "";FFapellido= ""; FFtelefono="";
        String FScedula, FSnombre, FSapellido, FStelefono;
        FScedula= ""; FSnombre= ""; FSapellido= ""; FStelefono="";
        if(jTable1.getValueAt(0,0).toString().equals("true")&&jTable1.getValueAt(0,3)!=null)
         {
             contador++;
            FFcedula="exec sp_articlefilter @publication = N'"+publicacion+"', @article = N'CLIENTES', @filter_name = N'FLTR_CLIENTES_"+contador+"__57', @filter_clause = N'[CI_RENT] "+jTable1.getValueAt(0, 2).toString()+"''"+jTable1.getValueAt(0, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1 \n";
            FScedula="exec sp_articleview @publication = N'"+publicacion+"', @article = N'CLIENTES', @view_name = N'SYNC_CLIENTES_"+contador+"__57', @filter_clause = N'[CI_RENT] "+jTable1.getValueAt(0, 2).toString()+"''"+jTable1.getValueAt(0, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1";  
         }
           else
          {
            FFcedula="";
            FScedula="";
          }

     if(jTable1.getValueAt(1,0).toString().equals("true")&&jTable1.getValueAt(1,3)!=null)
     {
             contador++;
            FFnombre="exec sp_articlefilter @publication = N'"+publicacion+"', @article = N'CLIENTES', @filter_name = N'FLTR_CLIENTES_"+contador+"__57', @filter_clause = N'[NOM_RENT] "+jTable1.getValueAt(1, 2).toString()+"''"+jTable1.getValueAt(1, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
            FSnombre="exec sp_articleview @publication = N'"+publicacion+"', @article = N'CLIENTES', @view_name = N'SYNC_CLIENTES_"+contador+"__57', @filter_clause = N'[NOM_RENT] "+jTable1.getValueAt(1, 2).toString()+"''"+jTable1.getValueAt(1, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1";    

     }
           else
          {
            FFnombre="";
            FSnombre="";
          }
     
    if(jTable1.getValueAt(2,0).toString().equals("true")&&jTable1.getValueAt(2,3)!=null)
     {
             contador++;
            FFapellido="exec sp_articlefilter @publication = N'"+publicacion+"', @article = N'CLIENTES', @filter_name = N'FLTR_CLIENTES_"+contador+"__57', @filter_clause = N'[APE_RENT] "+jTable1.getValueAt(2, 2).toString()+"''"+jTable1.getValueAt(2, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
                 FSapellido="exec sp_articleview @publication = N'"+publicacion+"', @article = N'CLIENTES', @view_name = N'SYNC_CLIENTES_"+contador+"__57', @filter_clause = N'[APE_RENT] "+jTable1.getValueAt(2, 2).toString()+"''"+jTable1.getValueAt(2, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1";    

     }
           else
          {
            FFapellido="";
            FSapellido="";
          }
     
     if(jTable1.getValueAt(3,0).toString().equals("true")&&jTable1.getValueAt(3,3)!=null)
     {
             contador++;
            FFtelefono="exec sp_articlefilter @publication = N'"+publicacion+"', @article = N'CLIENTES', @filter_name = N'FLTR_CLIENTES_"+contador+"__57', @filter_clause = N'[TEL_RENT] "+jTable1.getValueAt(3, 2).toString()+"''"+jTable1.getValueAt(3, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1\n";
            FStelefono="exec sp_articleview @publication = N'"+publicacion+"', @article = N'CLIENTES', @view_name = N'SYNC_CLIENTES_"+contador+"__57', @filter_clause = N'[TEL_RENT] "+jTable1.getValueAt(3, 2).toString()+"''"+jTable1.getValueAt(3, 3).toString()+"''', @force_invalidate_snapshot = 1, @force_reinit_subscription = 1";    

     }
           else
          {
            FFtelefono="";
            FStelefono="";
          }
     
        filtroFilas="\n"+FFcedula+"\n"+FFnombre+"\n"+FFapellido+"\n"+FFtelefono;
        filtroS="\n"+FScedula+"\n"+FSnombre+"\n"+FSapellido+"\n"+FStelefono;
     
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
            java.util.logging.Logger.getLogger(Instantanea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instantanea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instantanea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instantanea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instantanea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JComboBox jcTiempo;
    public javax.swing.JComboBox jcTiempo1;
    private javax.swing.JList jlTablasBase;
    private javax.swing.JTextField txtNombrePublicacion;
    // End of variables declaration//GEN-END:variables
}
