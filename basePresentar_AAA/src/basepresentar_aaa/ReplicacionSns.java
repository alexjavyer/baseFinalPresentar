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
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Anita
 */
public class ReplicacionSns extends javax.swing.JFrame {

    /**
     * Creates new form ReplicacionSns
     */
    String publicadorS,nombrePublicacion;
    
    public ReplicacionSns(String publicador,String nombrePub) {
        initComponents();
        publicadorS=publicador;
        nombrePublicacion=nombrePub;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSuscriptores = new javax.swing.JComboBox();
        cbBasesSuscriptores = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        btnFinalizar = new javax.swing.JButton();
        txtBaseNueva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Replicacion");

        jLabel2.setText("Eliga donde va a correr el Agente de Distribución");

        jLabel3.setText("Subscriptores");

        cbSuscriptores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADRIAN", "TOSHIBA", "JAVY-PC" }));
        cbSuscriptores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbSuscriptoresMouseEntered(evt);
            }
        });
        cbSuscriptores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSuscriptoresActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Inicializar la subscripcion");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inmediatamente", "Primera Sincronización" }));

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre Base Nueva");

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(41, 41, 41)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBaseNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbSuscriptores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbBasesSuscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addComponent(btnFinalizar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbSuscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBasesSuscriptores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBaseNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton2)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String suscriptorName;
    private void cbSuscriptoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSuscriptoresMouseEntered
        suscriptorName=cbSuscriptores.getSelectedItem().toString();
        
    }//GEN-LAST:event_cbSuscriptoresMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cbBasesSuscriptores.removeAllItems();
        cargarTablasSuscriptor();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        crearSubscripcion();
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
            Statement psd = cn.createStatement();
            psd.executeQuery(sql);
            }catch(Exception ex){
                if(ex.getMessage()=="La instrucción no devolvió un conjunto de resultados."){
                    JOptionPane.showMessageDialog(null,"Publicacion corriendo");
                    Clientes cli=new Clientes(Instantanea.servidor1);
                    cli.show();
                }else{
                JOptionPane.showMessageDialog(null,"Error al crear la subscripción"+ex);
                }
            }
    }
    
    
    
    
    
    
    
    
    private void cbSuscriptoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSuscriptoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSuscriptoresActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        crearBase(txtBaseNueva.getText());
        cbBasesSuscriptores.removeAllItems();
        cargarTablasSuscriptor();
       // crearTabla(txtBaseNueva.getText());
    }//GEN-LAST:event_jButton2ActionPerformed
    
        Calendar calobj = Calendar.getInstance();

    
    public void crearSubscripcion(){
        String fecha="";
        String año="";
        String mes="";
        String dia="";
                año=String.valueOf(calobj.get(Calendar.YEAR));
                mes=String.valueOf(calobj.get(Calendar.MONTH)+1);
                dia=String.valueOf(calobj.get(Calendar.DAY_OF_MONTH));
                fecha=año+mes+dia;
                
        JOptionPane.showMessageDialog(null, Clientes.baseInicial);
        String va=cbSuscriptores.getSelectedItem().toString();
        
        
        String sqlCrearSubs="-----------------BEGIN: Script to be run at Publisher '"+publicadorS+"'----------------- \n" +
        "use ["+Clientes.baseInicial+"]\n" +
        " exec sp_addsubscription @publication = N'"+nombrePublicacion+"',@subscriber = N'"+va+"', @destination_db = N'"+cbBasesSuscriptores.getSelectedItem()+"', @subscription_type = N'Push', @sync_type = N'automatic', @article = N'all', @update_mode = N'read only', @subscriber_type = 0 \n"
        + "exec sp_addpushsubscription_agent @publication = N'"+nombrePublicacion+"', @subscriber = N'"+va+"', @subscriber_db = N'"+cbBasesSuscriptores.getSelectedItem()+"', @job_login = null, @job_password = null, @subscriber_security_mode = 0, @subscriber_login = N'sa', @subscriber_password = N'sa', @frequency_type = 64, @frequency_interval = 0, @frequency_relative_interval = 0, @frequency_recurrence_factor = 0, @frequency_subday = 0, @frequency_subday_interval = 0, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = "+fecha+", @active_end_date = 99991231, @enabled_for_syncmgr = N'False', @dts_package_location = N'Distributor'"+
        "";
       
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null,"Suscriptor"+suscriptorName);
        Connection cn=cc.conectar(publicadorS);
       // escribir(sqlCrearSubs);
        try {
            Statement psd = cn.createStatement();
            psd.executeQuery(sqlCrearSubs);
            }catch(Exception ex){
                if(ex.getMessage()=="La instrucción no devolvió un conjunto de resultados."){
                    JOptionPane.showMessageDialog(null,"Subscripción Creada ");
                    Clientes cli=new Clientes(servidor);
                    cli.show();
                }else{
                JOptionPane.showMessageDialog(null,"Error al crear la subscripción"+ex);
                }
            }
        
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
            Statement psd = cn.createStatement();
            psd.executeQuery(sqlCrearSubs);
            }catch(Exception ex){
                if(ex.getMessage()=="La instrucción no devolvió un conjunto de resultados."){
                    JOptionPane.showMessageDialog(null,"Subscripción Creada ");
                    Clientes cli=new Clientes(publicadorS);
                    cli.show();
                }else{
                JOptionPane.showMessageDialog(null,"Error al crear la subscripción"+ex);
                }
            }
        
    }
    
    
    public void escribir(String codigo){
        File f;
        f = new File("C:\\Users\\Anita\\Documents\\DOCUMENTOS\\UNIVERSIDAD\\SEMESTRES\\6. SEXTO\\SBD DISTRIBUIDOS\\Segundo Parcial\\Proyecto\\GenerardoSubsSnap\\ProbandoSubs.txt");

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
    public void cargarTablasSuscriptor(){
        //String[] tablas=new String();
        suscriptorName=cbSuscriptores.getSelectedItem().toString();
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
                   cbBasesSuscriptores.addItem(rs.getString("name"));
                   //JOptionPane.showMessageDialog(null,rs.getString("name"));
                }
                
            }catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,"Error al cargar las tablas"+ex);
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
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
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
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
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
            java.util.logging.Logger.getLogger(ReplicacionSns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReplicacionSns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReplicacionSns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReplicacionSns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox cbSuscriptores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBaseNueva;
    // End of variables declaration//GEN-END:variables
}
