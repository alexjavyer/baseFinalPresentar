/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basepresentar_aaa;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author JAvy
 */
public class errores {
    
    private static String _mensajePersonalizado;

   public static String MensajePersonalizado()
        {
    
                return _mensajePersonalizado;
        }
    public static void Gestionar(SQLException exception)
        {
            String saltoLinea = "\n";
            //Mensajes personalizados para el usuario
            String problema = "EL PROBLEMA GENERADO PUEDE DEBERSE A LOS SIGUIETNES FACTORES:";
            String solucion = "POR FAVOR, PRUEBE LA SIGUIENTE SOLUCIÓN";
            String mensajeFinal = "NOTA: EN caso de persistir el problema, llame a Soporte Técnico. " +
                saltoLinea +
                "O con el Administrador del Sistema";

            //contiene la cadena con el mensaje de error a mostrar al usuario
            String mensaje = null;
            // Verificamos el nuemero de error y personalizar el mensaje.
            switch (exception.getErrorCode())
            {
                case 2:
                //    //Error personalizado
                                mensaje = problema +
                        saltoLinea +
                        "1.- El agente esta detenido" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique que el agente este corriendo" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;

                    break;

                case 4060:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- No existe la base de datos seleccionada" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique el nombre de la base de datos" +
                        saltoLinea +
                        "2.- Cree la base de datos para trabajar con la misma" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;

                //case 53:
                //    //Error personalizado
                // esta mal el servidor
                //    break;

                case 18456:
                    mensaje = problema +
                        saltoLinea +
                        "1.- El nombre de usuario o la contraseña ingresados no son validos " +
                        saltoLinea +
                        "2.- El nombre de usuario o la contraseña ingresados son requeridos" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verifique que el nombre de usuario y/o la contraseña sean correctos" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;
                // Errores con mensajes personalizados
                default:
                    mensaje = "ERROR DESCONOCIDO: " +
                        saltoLinea +
                        saltoLinea +
                        "MENSAJE: " + exception.getMessage() +
                        saltoLinea +
                        "NUMERO: " + exception.getErrorCode() +
                        saltoLinea +
                        "FUENTE " + exception.getClass() +
                        saltoLinea +
                        saltoLinea +
                        "LINEA: " + exception.getStackTrace();
                    break;
            }

            //Mostrar las excepciones de SQL Server.
            // Retornar el mensaje de error en un  campo de la clase
            // para que sea el usaurio de la calse el que decida 
            // en que control muestra el mensaje, que puede ser
            // un label, ErrorProvider, ToolTip o en cualquier control
            // o tecnica requerida.

            _mensajePersonalizado = mensaje;
        }

            public static void Gestionar(Exception exception)
        {
            //-----------------------------------------
            //Capturar y personalizar los errores 
            // de C#
            //-----------------------------------------

            String saltoLinea = "\n";
            //Mensajes personalizados para el usuario
            String problema = "EL PROBLEMA GENERADO PUEDE DEBERSE A LOS SIGUIETNES FACTORES:";
            String solucion = "POR FAVOR, PRUEBE LA SIGUIENTE SOLUCIÓN";
            String mensajeFinal = "NOTA: EN caso de persistir el problema, llame a Soporte Técnico. " +
                saltoLinea +
                "O con el Administrador del Sistema";

            //contiene la cadena con el mensaje de error a mostrar al usuario
            String mensaje = null;
            // Verificamos el nuemero de error y personalizar el mensaje.
            switch (exception.getMessage())
            {
            
                case "System.ArgumentException":
                    mensaje = "Mensaje Personalizado";
                    break;
                // Errores con mensajes personalizados de C#.
                default:
                    mensaje = "ERROR DESCONOCIDO: " +
                        saltoLinea +
                        saltoLinea +
                        "MENSAJE: " + exception.getMessage() +
                        saltoLinea +
                        "FUENTE " + exception.getLocalizedMessage() +
                        saltoLinea +
                        "LINEA: " + exception.getStackTrace();
                    break;
            }

            //Mostrar las excepciones de SQL Server.
            // Retornar el mensaje de error en un  campo de la clase
            // para que sea el usaurio de la calse el que decida 
            // en que control muestra el mensaje, que puede ser
            // un label, ErrorProvider, ToolTip o en cualquier control
            // o tecnica requerida.

            _mensajePersonalizado = mensaje;
        }
public static void mensaje(){
             JOptionPane.showMessageDialog(null,MensajePersonalizado(),"ERROR",JOptionPane.ERROR_MESSAGE);
}
            
           
    
    
    
    
}
