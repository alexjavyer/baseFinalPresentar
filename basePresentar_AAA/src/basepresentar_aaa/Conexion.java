/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basepresentar_aaa;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sony vaio
 */
public class Conexion {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 
 */
    
    public Connection conectar(String server){
        Connection cn=null;
//      JOptionPane.showMessageDialog(null, "Servidor"+server);
        String instancia="";
        if(server.equals("ADRIAN")){
            instancia="192.168.1.4";
//              instancia="172.21.105.124";
            //  instancia="172.21.105.124";
        }else{
            if(server.equals("JAVY-PC")){
                instancia="192.168.1.5";
//               instancia="172.21.105.123";
              // instancia="172.21.105.123";
            }else{
                instancia="192.168.1.6";
//                   instancia="172.21.105.248";
                   //instancia="192.168.1.6";
                   //instancia="172.21.105.248";
            }
        }
           // JOptionPane.showMessageDialog(null, instancia);
       try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cadenaConexion="jdbc:sqlserver://"+instancia+"\\"+server+":1433;User=sa; Password= sa";
            System.out.println(cadenaConexion);
            cn=DriverManager.getConnection(cadenaConexion);
        }catch(SQLException ex){
          //  JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
              errores.mensaje();
            
        } catch(Exception ex){
          //  JOptionPane.showMessageDialog(null,"Exception "+ex);  
            errores.Gestionar(ex);
              errores.mensaje();   
        }
        return cn;
    }
    
    public Connection conectarBase(String server,String base){
        Connection cn=null;
        String instancia="";
        if(server.equals("ADRIAN")){
            instancia="192.168.1.8";
            //  instancia="172.21.105.124";
              //instancia="172.21.105.124";
        }else{
            if(server.equals("JAVY-PC")){
               instancia="192.168.1.5";
              // instancia="172.21.105.123";
                instancia="192.168.1.5";
               //instancia="172.21.105.123";
            }else{
                
                   instancia="192.168.1.6";
                //   instancia="172.21.105.248";
                   //instancia="172.21.105.248";
                
            }
            }
         //   JOptionPane.showMessageDialog(null, instancia);
        
        try
        {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            cn=DriverManager.getConnection("jdbc:sqlserver://"+instancia+"\\"+server+":1433;"
//                    + "databaseName="+base+";User = sa; Password= sa");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://"+instancia+"\\"+server+":1433;"
                    + "databaseName="+base+";User = sa; Password= sa");
            //System.out.println("exito  ");
            String cadenaConexion="jdbc:sqlserver://"+instancia+"\\"+server+":1433;"
                    + "databaseName="+base+";User = sa; Password= sa";
            System.out.println(cadenaConexion);
            cn=DriverManager.getConnection(cadenaConexion);



            System.out.println("exito  ");
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null,"SQLException "+ex);
            errores.Gestionar(ex);
             errores.mensaje();
        } catch(Exception ex){
           // JOptionPane.showMessageDialog(null,"Exception "+ex);
              errores.Gestionar(ex);
              errores.mensaje();  
        }
        
         return cn;
    }
    
}
