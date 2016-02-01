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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author sony vaio
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    //Prueba
    DefaultTableModel model;
    public static String servidor="",bas="";
    public static int P2P1=0,P2P2=0,P2P3=0;
    public Clientes() {
        initComponents();
//        setTitle("Local");
//        servidor1="JAVY-PC";
//        CargarTabla(servidor1);
//        baseInicial = "Renta de Auto ";
//        lblNombreBase.setText("B A S E  "+baseInicial);
    }
        String servidor1;
        public static String baseInicial="";
        
    public Clientes(String servidor){
        initComponents();
               JOptionPane.showMessageDialog(null, servidor);

        setTitle(servidor);
        servidor1=servidor;
 
    }
    
    public void cargarPublicaciones(String servidor){
        String sqlCargarPublicaciones="Use distribution  SELECT\n" +
"           *\n" +
"            FROM\n" +
"                DBO.MSpublications AS MSA\n" +
"            INNER JOIN DBO.MSpublications AS MSP\n" +
"                    ON MSA.publication_id = MSP.publication_id";
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, baseInicial);
        try{
        Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlCargarPublicaciones);
            while(rs.next()){
                //taPublicaciones.setText(taPublicaciones.getText().concat(rs.getString("Publication Name")));
                DefaultMutableTreeNode raiz= new DefaultMutableTreeNode(rs.getString("publication"));
                DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
                DefaultTreeModel dt= (DefaultTreeModel)jTree1.getModel();
                dt.insertNodeInto(raiz, nodo,nodo.getChildCount());
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex+ "Error al cargar publicacion");
        }
        
    }
    public void Insertar(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor1, txtbase.getText());
        String sql="";
        int fila=jtbDatos.getSelectedRow();
        System.out.println(jtbDatos.getSelectedRow());
        String cedula,nombre,apellido,telefono;
//        cedula=(String) jtbDatos.getValueAt(fila, 0); 
//        nombre=(String) jtbDatos.getValueAt(fila, 1);
//        apellido=(String) jtbDatos.getValueAt(fila, 2); 
//        telefono=(String) jtbDatos.getValueAt(fila, 3);
        String nomCol="", values="";
        for(int i=0;i<modeloNombreColumnas.getSize();i++){
            if(i<modeloNombreColumnas.getSize()-1){
                nomCol=nomCol+modeloNombreColumnas.getElementAt(i).toString()+",";
                values=values+"?,";
            }else{
                nomCol=nomCol+modeloNombreColumnas.getElementAt(i).toString();
                values=values+"?";
            }
        }
        sql="insert into "+txtTabla.getText()+" ("+nomCol+") values("+values+")";
        //JOptionPane.showMessageDialog(null,"sql "+sql);
        try{
        PreparedStatement psd = cn.prepareStatement(sql);
        for(int j=0;j<modeloNombreColumnas.getSize();j++){
            psd.setString(j+1, jtbDatos.getValueAt(fila, j).toString());
        }
        
        int n = psd.executeUpdate();
        if(n>0){
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            CargarTabla(servidor1);
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }        
    }
    public void Actualizar(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor1, txtbase.getText());
        String sql="";
        int fila=jtbDatos.getSelectedRow();
        try {
            String campos="";
            for(int k=1;k<modeloNombreColumnas.getSize();k++){
                if(modeloNombreColumnas.getSize()-1==k){
                    campos=campos+modeloNombreColumnas.getElementAt(k)+"='"+jtbDatos.getValueAt(fila, k)+"' ";
                }else{
                    campos=campos+modeloNombreColumnas.getElementAt(k)+"='"+jtbDatos.getValueAt(fila, k)+"',";
                }
            }
            sql="update clientes set "+campos+" where "+modeloNombreColumnas.getElementAt(0)+"='"+jtbDatos.getValueAt(fila, 0)+"'";
            //JOptionPane.showMessageDialog(null,"SSQL "+sql);
            PreparedStatement psd= cn.prepareStatement(sql);
            int n= psd.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null, "Se Actualizo Correctamente");
                CargarTabla(servidor1);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            CargarTabla(servidor1);
        }
    }
    public void Eliminar (){
        if(JOptionPane.showConfirmDialog(null,"Estas Seguro que Deseas borrar El Dato","Borrar Registro",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        Conexion cc = new Conexion();
        
        Connection cn=cc.conectarBase(servidor1, txtbase.getText());
        String sql="";
        int fila=jtbDatos.getSelectedRow();
        sql="delete from "+txtTabla.getText()+" where "+modeloNombreColumnas.getElementAt(0)+"='"+jtbDatos.getValueAt(fila, 0)+"'";
        //JOptionPane.showMessageDialog(null,"SQL"+ sql);
        try {
            PreparedStatement psd=cn.prepareStatement(sql);
            int n=psd.executeUpdate();
            if(n>0){
                //JOptionPane.showMessageDialog(null, "Se Borro Correctamente");
                CargarTabla(servidor1);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }
    public void CargarTabla(String servidor){
        int nColumnas=modeloNombreColumnas.getSize();
        model = new DefaultTableModel();
        String column="";
        //jtbDatos.setModel(model);
        for(int j=0;j<nColumnas;j++){
            if(j==nColumnas-1){
                column=modeloNombreColumnas.getElementAt(j).toString();
                model.addColumn(column);
            }else{
                column=modeloNombreColumnas.getElementAt(j).toString();
                model.addColumn(column);
            }
        }
    //    JOptionPane.showMessageDialog(null,"Columnas"+column);
        //String []titulos={column};
        String [] registros=new String [nColumnas];
        String [] vacio=new String [4];
        Conexion cc = new Conexion();
        //JOptionPane.showMessageDialog(null, "Servidor "+servidor);
        Connection cn=cc.conectarBase(servidor, txtbase.getText());
        
        String sql="";
        sql="select * from "+txtTabla.getText()+"";
        //sql="select * from CLIENTES";
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            while(rs.next()){
                for(int k=0;k<nColumnas;k++){
                    registros[k]=rs.getString(modeloNombreColumnas.getElementAt(k).toString());
                }
//                
//                registros[0]=rs.getString("CI_RENT");
//                registros[1]=rs.getString("NOM_RENT");
//                registros[2]=rs.getString("APE_RENT");
//                registros[3]=rs.getString("TEL_RENT");
                model.addRow(registros);
            }
            model.addRow(vacio);
            jtbDatos.setModel(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+"al cargar tabla");
        }
    }
    public void S_Pull_Cont_Inme(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, "Renta_Auto_Sitio_A");
        String sql="";
        sql="use ["+baseInicial+"]  " +
"exec sp_addsubscription @publication = N'Pub_Instantanea_Renta_Autos', @subscriber = N'ADRIAN\\SITIO_A', @destination_db = N'Renta_Auto_Sitio_A', @sync_type = N'Automatic', @subscription_type = N'pull', @update_mode = N'read only'   "+
"";
        try {
            Statement psd= cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            
            JOptionPane.showMessageDialog(null, "Se creo la subscripcion");
            jtbDatos.setModel(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public void RSnapshotsinTiempo(){
        String []titulos={"PLACA","MARCA","COLOR","MODELO","AÑO","CAPACIDAD","OBSERVACION","URL"};
        String [] registros=new String [8];
        String instancia="TOSHIBA".concat("'\'").concat("PRINCIPAL");
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(instancia, baseInicial);
        model = new DefaultTableModel(null,titulos);
        String sql="",sql1="";
        sql="use ["+baseInicial+"]\n" +
"exec sp_replicationdboption @dbname = N'"+baseInicial+"', @optname = N'publish', @value = N'true'\n" +

"-- Adding the snapshot publication\n" +
"use ["+baseInicial+"]\n" +
"exec sp_addpublication @publication = N'Pub_Renta', @description = N'Snapshot publication of database ''"+baseInicial+"'' from Publisher ''TOSHIBA\\PRINCIPAL''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'true', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'snapshot', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1\n" +

"\n" +
"\n" +
"exec sp_addpublication_snapshot @publication = N'Pub_Renta', @frequency_type = 1, @frequency_interval = 0, @frequency_relative_interval = 0, @frequency_recurrence_factor = 0, @frequency_subday = 0, @frequency_subday_interval = 0, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 1\n" +
"\n" +
"\n" +
"use ["+baseInicial+"]\n" +
"exec sp_addarticle @publication = N'Pub_Renta', @article = N'Clientes', @source_owner = N'dbo', @source_object = N'Clientes', @type = N'logbased', @description = null, @creation_script = null, @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509D, @identityrangemanagementoption = N'manual', @destination_table = N'Clientes', @destination_owner = N'dbo', @vertical_partition = N'false'\n" +

"\n" +
"\n" +
"\n" +
"";
        sql1="use ["+baseInicial+"]\n" +
        "exec sp_replicationdboption @dbname = N'"+baseInicial+"', @optname = N'publish', @value = N'true'\n" +
        "-- Agregando la publicación de instantánea\n" +
        "use ["+baseInicial+"]\n" +
        "exec sp_addpublication @publication = N'Pub_Instantanea_Renta_Autos', @description = N'Publicación de instantánea de la base de datos ''"+baseInicial+"'' del publicador ''ADRIAN''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'true', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'snapshot', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1\n" +
        "\n" +
        "\n" +
        "exec sp_addpublication_snapshot @publication = N'Pub_Instantanea_Renta_Autos', @frequency_type = 1, @frequency_interval = 0, @frequency_relative_interval = 0, @frequency_recurrence_factor = 0, @frequency_subday = 0, @frequency_subday_interval = 0, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 1\n" +
        "\n" +
        "\n" +
        "use ["+baseInicial+"]\n" +
        "exec sp_addarticle @publication = N'Pub_Instantanea_Renta_Autos', @article = N'CATEGORIAS', @source_owner = N'dbo', @source_object = N'CATEGORIAS', @type = N'logbased', @description = null, @creation_script = null, @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509D, @identityrangemanagementoption = N'manual', @destination_table = N'CATEGORIAS', @destination_owner = N'dbo', @vertical_partition = N'false'\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "use ["+baseInicial+"]\n" +
        "exec sp_addarticle @publication = N'Pub_Instantanea_Renta_Autos', @article = N'CLIENTES', @source_owner = N'dbo', @source_object = N'CLIENTES', @type = N'logbased', @description = null, @creation_script = null, @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509D, @identityrangemanagementoption = N'manual', @destination_table = N'CLIENTES', @destination_owner = N'dbo', @vertical_partition = N'false'\n" +
        "\n" +
        "\n" +
        "\n" +
        "";
        try {
            Statement psd= cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            jtbDatos.setModel(model);
            S_Pull_Cont_Inme();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    void P2PPublicacion(String publicacion){
        Conexion cc = new Conexion();
        bas=jcbBases.getSelectedItem().toString();
        Connection cn=cc.conectarBase(servidor1, bas);
        String sql="",sql1="",sql2="",usu="";
        if(jcb_1.isSelected()==true || jcb_1.getText()==servidor1){
            sql="-- Enabling the replication database\n" +
            "use master\n" +
            "exec sp_replicationdboption @dbname = N'"+bas+"', @optname = N'publish', @value = N'true'\n" +
            "exec ["+bas+"].sys.sp_addlogreader_agent @job_login = null, @job_password = null, @publisher_security_mode = 1\n" +
            "exec ["+bas+"].sys.sp_addqreader_agent @job_login = null, @job_password = null, @frompublisher = 1\n" +
            "-- Adding the transactional publication\n" +
            "use ["+bas+"]\n" +
            "exec sp_addpublication @publication = N'"+publicacion+"', @description = N'Transactional publication of database ''"+bas+"'' from Publisher ''ADRIAN''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'false', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'continuous', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1, @allow_initialize_from_backup = N'true', @enabled_for_p2p = N'true', @enabled_for_het_sub = N'false', @p2p_conflictdetection = N'true', @p2p_originator_id = 1\n" +
            "exec sp_addpublication_snapshot @publication = N'"+publicacion+"', @frequency_type = 4, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 2, @frequency_subday_interval = 10, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 0, @publisher_login = N'sa', @publisher_password = N'sa'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'sa'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT AUTHORITY\\SYSTEM'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'ADRIAN\\sony vaio'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT SERVICE\\SQLSERVERAGENT'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT SERVICE\\MSSQLSERVER'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'distributor_admin'\n" +
            "-- Adding the transactional articles\n" +
            "use ["+bas+"]\n" +
            "exec sp_addarticle @publication = N'"+publicacion+"', @article = N'CLIENTES', @source_owner = N'dbo', @source_object = N'CLIENTES', @type = N'logbased', @description = N'', @creation_script = N'', @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509F, @identityrangemanagementoption = N'manual', @destination_table = N'CLIENTES', @destination_owner = N'dbo', @status = 24, @vertical_partition = N'false', @ins_cmd = N'CALL [dbo].[sp_MSins_dboCLIENTES]', @del_cmd = N'CALL [dbo].[sp_MSdel_dboCLIENTES]', @upd_cmd = N'SCALL [dbo].[sp_MSupd_dboCLIENTES]'";
            try {
                PreparedStatement psd= cn.prepareStatement(sql);
                psd.execute();
                JOptionPane.showMessageDialog(null, "Se creo la Publicacion P2P Local");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex+" "+"Error en pub_ Adrian");
            } 
            P2P1=1;
        }
        if(jcb_2.isSelected()==true || jcb_2.getText()==servidor1){
            P2P2=1;
            P2PPublicacionSA(txtNombrePubP2P.getText(), jcb_2.getText());
        }
        if(jcb_3.isSelected()==true || jcb_3.getText()==servidor1){
            P2P3=1;            
            P2PPublicacionSA(txtNombrePubP2P.getText(), jcb_3.getText());
        }
    }
    void P2PPublicacionSA(String publicacion, String ser){
        Conexion cc = new Conexion();
        bas=jcbBases.getSelectedItem().toString();
        Connection cn=cc.conectarBase(ser, bas);
        String sql="",sql2="";
        if(jcb_2.getText()==ser){
            sql="-- Enabling the replication database\n" +
            "use master\n" +
            "exec sp_replicationdboption @dbname = N'"+bas+"', @optname = N'publish', @value = N'true'\n" +
            "exec ["+bas+"].sys.sp_addlogreader_agent @job_login = null, @job_password = null, @publisher_security_mode = 0, @publisher_login = N'sa', @publisher_password = N'sa'\n" +
            "exec ["+bas+"].sys.sp_addqreader_agent @job_login = null, @job_password = null, @frompublisher = 1\n" +
            "-- Adding the transactional publication\n" +
            "use ["+bas+"]\n" +
            "exec sp_addpublication @publication = N'"+publicacion+"', @description = N'Transactional publication of database ''"+bas+"'' from Publisher ''ADRIAN''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'false', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'continuous', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1, @allow_initialize_from_backup = N'true', @enabled_for_p2p = N'true', @enabled_for_het_sub = N'false', @p2p_conflictdetection = N'true', @p2p_originator_id = 2\n" +
            "exec sp_addpublication_snapshot @publication = N'"+publicacion+"', @frequency_type = 4, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 8, @frequency_subday_interval = 1, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 1\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'sa'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT AUTHORITY\\SYSTEM'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'JAvy-PC\\JAvy'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT SERVICE\\SQLSERVERAGENT'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT SERVICE\\MSSQLSERVER'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'distributor_admin'\n" +
            "-- Adding the transactional articles\n" +
            "use ["+bas+"]\n" +
            "exec sp_addarticle @publication = N'"+publicacion+"', @article = N'CLIENTES', @source_owner = N'dbo', @source_object = N'CLIENTES', @type = N'logbased', @description = N'', @creation_script = N'', @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509F, @identityrangemanagementoption = N'manual', @destination_table = N'CLIENTES', @destination_owner = N'dbo', @status = 24, @vertical_partition = N'false', @ins_cmd = N'CALL [dbo].[sp_MSins_dboCLIENTES2116169880]', @del_cmd = N'CALL [dbo].[sp_MSdel_dboCLIENTES2116169880]', @upd_cmd = N'SCALL [dbo].[sp_MSupd_dboCLIENTES2116169880]'";
            try {
                PreparedStatement psd= cn.prepareStatement(sql);
                psd.execute();
                JOptionPane.showMessageDialog(null, "Se creo la Publicacion P2P SA");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex+" "+"Error en publicacion sA");
            } 
        }
        if(jcb_3.getText()==ser){
            sql2="-- Enabling the replication database\n" +
            "use master\n" +
            "exec sp_replicationdboption @dbname = N'"+bas+"', @optname = N'publish', @value = N'true'\n" +
            "exec ["+bas+"].sys.sp_addlogreader_agent @job_login = null, @job_password = null, @publisher_security_mode = 0, @publisher_login = N'sa', @publisher_password = N'sa'\n" +
            "exec ["+bas+"].sys.sp_addqreader_agent @job_login = null, @job_password = null, @frompublisher = 1\n" +
            "-- Adding the transactional publication\n" +
            "use ["+bas+"]\n" +
            "exec sp_addpublication @publication = N'"+publicacion+"', @description = N'Transactional publication of database ''"+bas+"'' from Publisher ''ADRIAN''.', @sync_method = N'native', @retention = 0, @allow_push = N'true', @allow_pull = N'true', @allow_anonymous = N'false', @enabled_for_internet = N'false', @snapshot_in_defaultfolder = N'true', @compress_snapshot = N'false', @ftp_port = 21, @ftp_login = N'anonymous', @allow_subscription_copy = N'false', @add_to_active_directory = N'false', @repl_freq = N'continuous', @status = N'active', @independent_agent = N'true', @immediate_sync = N'true', @allow_sync_tran = N'false', @autogen_sync_procs = N'false', @allow_queued_tran = N'false', @allow_dts = N'false', @replicate_ddl = 1, @allow_initialize_from_backup = N'true', @enabled_for_p2p = N'true', @enabled_for_het_sub = N'false', @p2p_conflictdetection = N'true', @p2p_originator_id = 2\n" +
            "exec sp_addpublication_snapshot @publication = N'"+publicacion+"', @frequency_type = 4, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 8, @frequency_subday_interval = 1, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @job_login = null, @job_password = null, @publisher_security_mode = 1\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'sa'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT AUTHORITY\\SYSTEM'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'TOSHIBA\\Anita'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT SERVICE\\SQLSERVERAGENT'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'NT SERVICE\\MSSQLSERVER'\n" +
            "exec sp_grant_publication_access @publication = N'"+publicacion+"', @login = N'distributor_admin'\n" +
            "-- Adding the transactional articles\n" +
            "use ["+bas+"]\n" +
            "exec sp_addarticle @publication = N'"+publicacion+"', @article = N'CLIENTES', @source_owner = N'dbo', @source_object = N'CLIENTES', @type = N'logbased', @description = N'', @creation_script = N'', @pre_creation_cmd = N'drop', @schema_option = 0x000000000803509F, @identityrangemanagementoption = N'manual', @destination_table = N'CLIENTES', @destination_owner = N'dbo', @status = 24, @vertical_partition = N'false', @ins_cmd = N'CALL [dbo].[sp_MSins_dboCLIENTES2116169880]', @del_cmd = N'CALL [dbo].[sp_MSdel_dboCLIENTES2116169880]', @upd_cmd = N'SCALL [dbo].[sp_MSupd_dboCLIENTES2116169880]'";
            try {
                PreparedStatement psd2= cn.prepareStatement(sql2);
                psd2.execute();
                JOptionPane.showMessageDialog(null, "Se creo la Publicacion P2P SB");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }       
        }     
    }
    void P2PSuscripcion(String publicacion){
        int numero_ins;
        String sql="",sus1="",sus2="",sus3="",s="";
        numero_ins=P2P1+P2P2+P2P3;
        Conexion cc = new Conexion();
        s=servidor1;
        bas=jcbBases.getSelectedItem().toString();
        for(int i=0;i<numero_ins;i++){
            System.out.println("servi "+s);
            Connection cn=cc.conectarBase(s, bas);
            sus1="-- Adding the transactional subscriptions\n" +
            "use ["+bas+"]\n" +
            "exec sp_addsubscription @publication = N'"+publicacion+"', @subscriber = N'ADRIAN', @destination_db = N'"+bas+"', @subscription_type = N'Push', @sync_type = N'replication support only', @article = N'all', @update_mode = N'read only', @subscriber_type = 0\n" +
            "exec sp_addpushsubscription_agent @publication = N'"+publicacion+"', @subscriber = N'ADRIAN', @subscriber_db = N'"+bas+"', @job_login = null, @job_password = null, @subscriber_security_mode = 0, @subscriber_login = N'sa', @subscriber_password = N'sa', @frequency_type = 64, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 4, @frequency_subday_interval = 5, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @dts_package_location = N'Distributor'";
            sus2="            -- Adding the transactional subscriptions\n" +
            "use ["+bas+"]\n" +
            "exec sp_addsubscription @publication = N'"+publicacion+"', @subscriber = N'JAVY-PC', @destination_db = N'"+bas+"', @subscription_type = N'Push', @sync_type = N'replication support only', @article = N'all', @update_mode = N'read only', @subscriber_type = 0\n" +
            "exec sp_addpushsubscription_agent @publication = N'"+publicacion+"', @subscriber = N'JAVY-PC', @subscriber_db = N'"+bas+"', @job_login = null, @job_password = null, @subscriber_security_mode = 0, @subscriber_login = N'sa', @subscriber_password = N'sa', @frequency_type = 64, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 4, @frequency_subday_interval = 5, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @dts_package_location = N'Distributor'";
            sus3 ="use ["+bas+"]\n" +
                "exec sp_addsubscription @publication = N'"+publicacion+"', @subscriber = N'TOSHIBA', @destination_db = N'"+bas+"', @subscription_type = N'Push', @sync_type = N'replication support only', @article = N'all', @update_mode = N'read only', @subscriber_type = 0\n" +
                "exec sp_addpushsubscription_agent @publication = N'"+publicacion+"', @subscriber = N'TOSHIBA', @subscriber_db = N'"+bas+"', @job_login = null, @job_password = null, @subscriber_security_mode = 0, @subscriber_login = N'sa', @subscriber_password = N'sa', @frequency_type = 64, @frequency_interval = 1, @frequency_relative_interval = 1, @frequency_recurrence_factor = 0, @frequency_subday = 4, @frequency_subday_interval = 5, @active_start_time_of_day = 0, @active_end_time_of_day = 235959, @active_start_date = 0, @active_end_date = 0, @dts_package_location = N'Distributor'";
            if(P2P1==1){
                if(numero_ins==3){
                    sql=sus2+"\n"+sus3;
                    s=jcb_2.getText();
                }
                else{
                    if(P2P2==1){
                        sql=sus2;
                        s=jcb_2.getText();
                    }
                    else{
                        sql=sus3;
                        s=jcb_3.getText();
                    }
                }
                P2P1=0;
                //System.out.println("sql1 "+sql);
            }
            else{
                if(P2P2==1){
                    P2P1=1;
                    if(numero_ins==3){
                        sql=sus1+"\n"+sus3;
                        s=jcb_3.getText();
                    }
                    else{
                        if(P2P1==1)
                            sql=sus1;
                        else{
                            sql=sus3;
                            s=jcb_3.getText();
                        }
                    }
                    P2P1=0; P2P2=0;
                }
                else{
                    if(P2P3==1){
                        P2P1=1;
                        if(numero_ins==3)
                            sql=sus1+"\n"+sus2;
                        else{
                            if(P2P1==1)
                                sql=sus1;
                            else
                                sql=sus2;
                        }
                    }
                }
            }
            System.out.println("sql  "+ sql +"   \n servidor   "+s);
            try {
                PreparedStatement psd= cn.prepareStatement(sql);
                psd.execute();
                JOptionPane.showMessageDialog(null, "Se creo la subscripcion P2P");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    void cargarTabla(){
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor1, jcbBases.getSelectedItem().toString());
        String sql="";
        sql="SELECT * FROM INFORMATION_SCHEMA.TABLES where TABLE_TYPE ='base table' and TABLE_NAME not like 'MS%'and TABLE_NAME not like 'sys%'";
        jcmTablas.removeAllItems();
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            while(rs.next()){
                jcmTablas.addItem(rs.getString("TABLE_NAME"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    void cargarBase(){
        Conexion cc = new Conexion();
        System.out.println("cargar base "+servidor);
        Connection cn=cc.conectarBase(servidor1, "master");
        String sql="";
        sql="SELECT name, database_id, create_date FROM sys.databases";
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            while(rs.next()){
                jcbBases.addItem(rs.getString("NAME"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void crearBase(String baseNueva, String ser){
        String sql="";
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor.toString().trim()+ser, "master");
        sql="USE [master]\n" +
            "/****** Object:  Database ["+baseNueva+"]    Script Date: 01/17/2016 19:05:20 ******/\n" +
            "CREATE DATABASE ["+baseNueva+"] ON  PRIMARY \n" +
            "( NAME = N'prueba_renta', FILENAME = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL10."+ser+"\\MSSQL\\DATA\\"+baseNueva+".mdf' , SIZE = 6144KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )\n" +
            " LOG ON \n" +
            "( NAME = N'prueba_renta_log', FILENAME = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL10."+ser+"\\MSSQL\\DATA\\"+baseNueva+"_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)\n" +
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
        P2P = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        btnAceptarP2P = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        jcbBases = new javax.swing.JComboBox();
        jcmTablas = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtNombrePubP2P = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jcb_1 = new javax.swing.JCheckBox();
        jcb_2 = new javax.swing.JCheckBox();
        jcb_3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        txtNombre_Base = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnVerSubs = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtBaseDatos = new javax.swing.JTree();
        btnCargarBase = new javax.swing.JButton();
        btnVerTablas = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnEditarTabla = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbase = new javax.swing.JTextField();
        txtTabla = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

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

        P2P.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                P2PPropertyChange(evt);
            }
        });

        jLabel4.setText("Base de Datos");

        btnAceptarP2P.setText("Aceptar");
        btnAceptarP2P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarP2PActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        jcbBases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbBasesMouseClicked(evt);
            }
        });
        jcbBases.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBasesItemStateChanged(evt);
            }
        });
        jcbBases.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcbBasesPropertyChange(evt);
            }
        });
        jcbBases.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbBasesKeyPressed(evt);
            }
        });

        jcmTablas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcmTablasMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmTablasMouseClicked(evt);
            }
        });
        jcmTablas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmTablasItemStateChanged(evt);
            }
        });
        jcmTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmTablasActionPerformed(evt);
            }
        });
        jcmTablas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmTablasKeyPressed(evt);
            }
        });

        jLabel5.setText("Tablas");

        jLabel6.setText("Nombre de la Publicación");

        jcb_1.setText("ADRIAN");
        jcb_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_1ItemStateChanged(evt);
            }
        });

        jcb_2.setText("JAVY-PC");

        jcb_3.setText("TOSHIBA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_1)
                    .addComponent(jcb_2)
                    .addComponent(jcb_3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcb_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Nombre de la Base");

        javax.swing.GroupLayout P2PLayout = new javax.swing.GroupLayout(P2P.getContentPane());
        P2P.getContentPane().setLayout(P2PLayout);
        P2PLayout.setHorizontalGroup(
            P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2PLayout.createSequentialGroup()
                .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P2PLayout.createSequentialGroup()
                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(P2PLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcmTablas, 0, 138, Short.MAX_VALUE)
                                    .addComponent(jcbBases, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(P2PLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2PLayout.createSequentialGroup()
                                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombrePubP2P, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(txtNombre_Base))))))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P2PLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnAceptarP2P)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar1)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        P2PLayout.setVerticalGroup(
            P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2PLayout.createSequentialGroup()
                .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P2PLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P2PLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(P2PLayout.createSequentialGroup()
                                .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbBases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcmTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombrePubP2P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre_Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(P2PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptarP2P)
                            .addComponent(btnCancelar1))))
                .addContainerGap(23, Short.MAX_VALUE))
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

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnInsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Publicaciones");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Publicaciones");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Suscripcion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Sincronizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnVerSubs.setText("Ver Subscripcion");
        btnVerSubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSubsActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerSubs, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerSubs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Base de Datos");
        jtBaseDatos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtBaseDatos.setToolTipText("");
        jScrollPane3.setViewportView(jtBaseDatos);

        btnCargarBase.setText("Mostrar");
        btnCargarBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarBaseActionPerformed(evt);
            }
        });

        btnVerTablas.setText("Ver Tablas");
        btnVerTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTablasActionPerformed(evt);
            }
        });

        jLabel9.setText("Base de Datos");

        btnEditarTabla.setText("Editar Tabla");
        btnEditarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargarBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerTablas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                    .addComponent(jLabel9))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCargarBase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerTablas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarTabla))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel3.setText("Base de Datos");

        jLabel8.setText("Tabla");

        txtbase.setEditable(false);

        txtTabla.setEditable(false);

        jMenu2.setText("SNAPSHOT");

        jMenuItem3.setText("PUBLICACION");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("TRANSACCIONAL");

        jMenuItem1.setText("INSTANTANEA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("COLA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("P2P");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("MERGE");

        jMenuItem5.setText("Publicacion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Subscripcion");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(53, 53, 53)
                                .addComponent(txtTabla))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbase, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
    String nombrePubli;
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Instantanea ins=new Instantanea(servidor1);
        ins.show();
        ins.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TransaInstantanea trans = new TransaInstantanea(servidor1);
        trans.show();
        trans.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(jcb_1.getText()==servidor1)
            jcb_1.setEnabled(false);
        if(jcb_2.getText()==servidor1)
            jcb_2.setEnabled(false);
        if(jcb_3.getText()==servidor1)
            jcb_3.setEnabled(false);
        P2P.setBounds(200, 200, 500, 280);
        P2P.setLocationRelativeTo(null);
        P2P.setVisible(true);
        cargarBase();
        cargarTabla();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null,"Server: "+servidor1);
        Merge mer=new Merge(servidor1);
        mer.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        MergeSubcripcion mergsub=new MergeSubcripcion(servidor1);
        mergsub.show();
        this.hide()
                ;
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnAceptarP2PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarP2PActionPerformed
        // TODO add your handling code here:
        //Snapshot
        System.out.println("jcm "+jcb_1.isSelected()+"  "+ jcb_2.isSelected()+"  "+jcb_3.isSelected());
        if((!txtNombre_Base.getText().equals("")) && (!txtNombrePubP2P.getText().equals("")) && (jcb_1.isSelected()==true ||jcb_1.isSelected()==true||jcb_1.isSelected()==true)){
            //crearBase(bas, servidor);
            //crearTabla(bas, servidor);
            bas=jcbBases.getSelectedItem().toString();
            P2PPublicacion(txtNombrePubP2P.getText());
            P2PSuscripcion(txtNombrePubP2P.getText());
        }else{
            if((jcb_1.isSelected()==false)  && (jcb_2.isSelected()==false) && (jcb_3.isSelected()==false))
                JOptionPane.showMessageDialog(null, "Debe elegir una instancia");
            if(txtNombrePubP2P.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Debe escribir un nombre para la publicación");
            if(txtNombre_Base.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Debe escribir un nombre para la base");
        }
    }//GEN-LAST:event_btnAceptarP2PActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
        P2P.setBounds(200, 200, 500, 280);
        P2P.setLocationRelativeTo(null);
        P2P.setVisible(false);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void jcbBasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbBasesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBasesMouseClicked

    private void jcbBasesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBasesItemStateChanged
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jcbBasesItemStateChanged

    private void jcbBasesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcbBasesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBasesPropertyChange

    private void jcbBasesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbBasesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBasesKeyPressed

    private void jcmTablasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmTablasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmTablasMouseClicked

    private void jcmTablasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmTablasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmTablasMousePressed

    private void jcmTablasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmTablasItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmTablasItemStateChanged

    private void jcmTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmTablasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmTablasActionPerformed

    private void jcmTablasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmTablasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmTablasKeyPressed

    private void jcb_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_1ItemStateChanged

    private void P2PPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_P2PPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_P2PPropertyChange

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TransaCola trans = new TransaCola(servidor1);
        trans.show();
        trans.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnVerSubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSubsActionPerformed
        cargarSubs();
    }//GEN-LAST:event_btnVerSubsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode =
        (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        nombrePubli=selectedNode.toString();

        correrPublicacion(nombrePubli);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode =
        (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        nombrePubli=selectedNode.toString();

        ReplicacionSns repl=new ReplicacionSns(servidor,nombrePubli);
        repl.show();
        this.dispose();
        //JOptionPane.showMessageDialog(null, "publicacion seleccionada "+nombrePubli);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargarPublicaciones(servidor1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCargarBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarBaseActionPerformed
        // TODO add your handling code here:
        cargarBases(servidor1);
    }//GEN-LAST:event_btnCargarBaseActionPerformed

    private void btnVerTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTablasActionPerformed
        // TODO add your handling code here:
        cargarTabla(servidor1);
    }//GEN-LAST:event_btnVerTablasActionPerformed

    private void btnEditarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTablaActionPerformed
        // TODO add your handling code here:
        String tablaActual=jtBaseDatos.getLastSelectedPathComponent().toString();
        DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)jtBaseDatos.getLastSelectedPathComponent();
        txtTabla.setText(tablaActual);
        String baseActual=nodo.getParent().toString();
        txtbase.setText(baseActual);
        cargarColumnas(txtTabla.getText());
        CargarTabla(servidor);
        baseInicial = baseActual;
                
    }//GEN-LAST:event_btnEditarTablaActionPerformed
    DefaultListModel modeloNombreColumnas;
    
    public void cargarColumnas(String tabla){
            String sql="";
            String base_de_autos=txtbase.getText();
        //    sql="SELECT COLUMN_NAME \n" +
        //    "FROM [Renta de Autos].INFORMATION_SCHEMA.COLUMNS\n" +
        //    "WHERE TABLE_NAME = N'"+nomTabla+"'";
            sql="SELECT COLUMN_NAME\n" +
        "        FROM ["+base_de_autos+"].INFORMATION_SCHEMA.COLUMNS\n" +
        "        WHERE TABLE_NAME ='"+tabla+"'";
           // JOptionPane.showMessageDialog(null,"cl "+Clientes.baseInicial);
            String [] ListaColumnas=new String[4];
            Conexion cc = new Conexion();

            Connection cn=cc.conectarBase(servidor1,base_de_autos);
             modeloNombreColumnas=new DefaultListModel();
                         modeloNombreColumnas.removeAllElements();
            //model1 = new DefaultTableModel(null,titulos);
            int i=0;
          //  modeloR=new DefaultTableModel();
             try {
                    Statement psd1 = cn.createStatement();
                    ResultSet rs1=psd1.executeQuery(sql);
                    while(rs1.next()){
                        modeloNombreColumnas.addElement(rs1.getString("COLUMN_NAME"));
                    }
                    
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex+"al cargar Columnas");
                }

    }
    public void cargarTabla(String servidor){
        //String sql ="SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = BASE TABLE AND TABLE_SCHEMA=dbName";
        
        String base_de_datos1=jtBaseDatos.getLastSelectedPathComponent().toString();
        
        String sql ="USE ["+base_de_datos1+"]\n" +
        "SELECT name FROM sysobjects where xtype='U' and category <> 2";
        //  JOptionPane.showMessageDialog(null,"SQL cargarbases "+sql);
        //JOptionPane.showMessageDialog(null,"sql "+sql);
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor, base_de_datos1);
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sql);
            while(rs.next()){
                    DefaultMutableTreeNode raiz= new DefaultMutableTreeNode(rs.getString("name"));
                    DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)jtBaseDatos.getLastSelectedPathComponent();
                    DefaultTreeModel dt= (DefaultTreeModel)jtBaseDatos.getModel();
                    
                    dt.insertNodeInto(raiz, nodo,nodo.getChildCount());
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+" al cargar tabla");
        }
    }

    public void cargarBases(String servidor){
         //  JOptionPane.showMessageDialog(null, "Servidor "+servidor);
        String sqlTablasSuscriptor="SELECT name FROM master.dbo.sysdatabases WHERE dbid >= 5";
        
        boolean correcto=true;
        Conexion cc = new Conexion();
        Connection cn=cc.conectar(servidor1);
        try {
            Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlTablasSuscriptor);
                while(rs.next()){
                    DefaultMutableTreeNode raiz= new DefaultMutableTreeNode(rs.getString("name"));
                    DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)jtBaseDatos.getLastSelectedPathComponent();
                    DefaultTreeModel dt= (DefaultTreeModel)jtBaseDatos.getModel();
                    dt.insertNodeInto(raiz, nodo,nodo.getChildCount());
                //   JOptionPane.showMessageDialog(null,"name "+rs.getString("name"));
                }
                
            }catch(Exception ex){
                correcto=false;
                JOptionPane.showMessageDialog(null,"Error "+ex+" Suscriptor"+servidor);
            }
        
        
                
    }
    public void cargarSubs(){
        String publi=jTree1.getLastSelectedPathComponent().toString();
        //JOptionPane.showMessageDialog(null, "Publi " +publi);
        String sqlCargarSubs="Use distribution  SELECT\n" +
        "*\n" +
        "            FROM\n" +
        "                DBO.MSmerge_subscriptions AS MSA\n" +
        "            INNER JOIN DBO.MSpublications AS MSP\n" +
        "                    ON MSA.publication_id = MSP.publication_id"
                + " AND publication='"+publi+"'\n" +
        "				";
        Conexion cc = new Conexion();
        Connection cn=cc.conectarBase(servidor1, baseInicial);
        try{
        Statement psd = cn.createStatement();
            ResultSet rs=psd.executeQuery(sqlCargarSubs);
            while(rs.next()){
               // JOptionPane.showMessageDialog(null, "Publi " +publi);
                //taPublicaciones.setText(taPublicaciones.getText().concat(rs.getString("Publication Name")));
                DefaultMutableTreeNode raiz= new DefaultMutableTreeNode("["+rs.getString("subscriber")+"]: "+rs.getString("subscriber_db"));
                DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
                DefaultTreeModel dt= (DefaultTreeModel)jTree1.getModel();
                dt.insertNodeInto(raiz, nodo,nodo.getChildCount());
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex+ "Error al cargar publicacion");
        }
    }
    
    
    String nombreJob="";
    
    void seleccionaJob(String nombre){
     String sql="";
        sql = "SELECT  name \n" +
              "FROM    msdb.dbo.sysjobs J\n" +
              "WHERE   name like '%"+Clientes.baseInicial+"-"+nombre+"%'\n" + "";
    
    
    Conexion cc = new Conexion();
    Connection cn=cc.conectar(servidor1);

     try {
            Statement psd1 = cn.createStatement();
            ResultSet rs1=psd1.executeQuery(sql);
            while(rs1.next()){
                nombreJob=(rs1.getString("name"));
            }
            JOptionPane.showMessageDialog(null, nombreJob);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+"al cargar tabla");
        }   
    }
    
    void correrPublicacion(String nombre){
        seleccionaJob(nombre);
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
                    JOptionPane.showMessageDialog(null,"Publicacion corriendo");
                    Clientes cli=new Clientes(servidor1);
                    cli.show();
                }else{
                JOptionPane.showMessageDialog(null,"Error al crear la subscripción"+ex);
                }
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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog P2P;
    private javax.swing.JDialog Usuario;
    private javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnAceptarP2P;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCargarBase;
    private javax.swing.JButton btnEditarTabla;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnVerSubs;
    private javax.swing.JButton btnVerTablas;
    private javax.swing.JComboBox cmbServidores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    public javax.swing.JComboBox jcbBases;
    public javax.swing.JCheckBox jcb_1;
    public javax.swing.JCheckBox jcb_2;
    public javax.swing.JCheckBox jcb_3;
    public javax.swing.JComboBox jcmTablas;
    private javax.swing.JTree jtBaseDatos;
    private javax.swing.JTable jtbDatos;
    private javax.swing.JTextField txtNombrePubP2P;
    private javax.swing.JTextField txtNombre_Base;
    private javax.swing.JTextField txtTabla;
    private javax.swing.JTextField txtbase;
    // End of variables declaration//GEN-END:variables
}
