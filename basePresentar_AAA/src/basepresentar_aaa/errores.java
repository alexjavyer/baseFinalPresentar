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
            String problema = "EL PROBLEMA GENERADO PUEDE DEBERSE A LOS SIGUIENTES FACTORES:";
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

                    case 20026:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- No existe la publicación" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique el nombre de la publicación" +
                        saltoLinea +
                        "2.- Cree la publiccón para trabajar con ella" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;
                    case 14043:
                         mensaje=problema+
                                 saltoLinea+
                                 "La publicación debe tener un nombre."
                                +saltoLinea+
                                 saltoLinea+
                                 solucion+
                                 saltoLinea+
                                 "Asigne un nombre a la publicación.";
                    break;
                        case 21745:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- Error de filtros" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique los fitros" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;
                            
                            case 14016:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- La publicación ya existe" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Cambie el nombre de la publicación" +
                        saltoLinea +
                        "2.- Vaya a las publicaciones y trabaje con ella" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;
                        
                                case 2714:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- La tabla ya existe" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique el nombre de la tabla" +
                        saltoLinea +
                        "2.- Cree o escoja una nueva base para crear la tabla" +
                        saltoLinea +
                        "3.- Borre la tabla para crear en la misma base" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;
                                    
                            case 14058:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- La suscripcion ya existe" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique el nombre de la suscripcion" +
                        saltoLinea +
                        "2.- Borre la sucripcion para crear nuevamente" +
                        saltoLinea +
                        saltoLinea +
                        mensajeFinal;
                    break;        
                                  case 102:
                    //Error personalizado
                mensaje = problema +
                        saltoLinea +
                        "1.- Error en el SELET" +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verique el contenido del SELECT" +
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
                                 case 5:
                    mensaje = problema +
                        saltoLinea +
                        "1.- No existe conexion con la Instancia " +
                        saltoLinea +
                        saltoLinea +
                        solucion +
                        saltoLinea +
                        "1.- Verifique que exista conexion con la intancia mensionada" +
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
            JOptionPane.showMessageDialog(null,"Error nombre"+exception);
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
