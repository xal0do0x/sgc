/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views.Settings;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Gabriel
 */
public class ClaseUtil {
    
    public final static int NUEVO = 1;
    public final static int MODIFICAR = 2;
    public final static int ELIMINAR = 3;
    public final static int DATOSVACIOS = 4;
    
     public static boolean dialogoConfirmar(Component parent, int opcion) {
        String mensaje = "";
        String titulo = "Mensaje del sistema";
        int tipoMensaje = 0;

        switch (opcion) {
            case NUEVO:
                mensaje = "¿Desea guardar los datos?";
                tipoMensaje = JOptionPane.QUESTION_MESSAGE;
                break;
            case MODIFICAR:
                mensaje = "¿Desea guardar los cambios realizados?";
                tipoMensaje = JOptionPane.QUESTION_MESSAGE;
                break;
            case ELIMINAR:
                mensaje = "¿Desea eliminar el elemento seleccionado?";
                tipoMensaje = JOptionPane.WARNING_MESSAGE;
                break;
            
        }

        return JOptionPane.showConfirmDialog(parent, mensaje, titulo, JOptionPane.YES_NO_OPTION, tipoMensaje) == JOptionPane.YES_OPTION;
    }

    public static void mensajeExito(Component parent, int opcion) {
        String mensaje = "";
        String titulo = "Mensaje del sistema";
        int tipoMensaje = JOptionPane.INFORMATION_MESSAGE;

        switch (opcion) {
            case NUEVO:
                mensaje = "Los datos se guardaron correctamente";
                break;
            case MODIFICAR:
                mensaje = "Los datos fueron actualizados correctamente";
                break;
            case ELIMINAR:
                mensaje = "Se eliminó el elemento seleccionado";
                break;
            case DATOSVACIOS:
                mensaje = "Ingresar Todos los Campos Obligatorios";                
                break;
        }

        JOptionPane.showMessageDialog(parent, mensaje, titulo, tipoMensaje);
    }
    
    public static void activarComponente(Component component, boolean editable) {
        if (component instanceof JDateChooser) {
            JDateChooser dc = (JDateChooser) component;
            activarComponente(dc.getCalendarButton(), editable);
            ((JTextFieldDateEditor) dc.getDateEditor()).setEditable(false);
        } else if (component instanceof JTextComponent) {
            ((JTextComponent) component).setEditable(editable);
        } else if (component instanceof AbstractButton) {
            component.setEnabled(editable);            
//        }else if(component instanceof  JScrollPane) {
//             ((JScrollPane) component).set
        }else if (component instanceof JPanel) {
            for (Component c : ((JComponent) component).getComponents()) {
                activarComponente(c, editable);
            }
        } else {
            component.setEnabled(editable);
        }
    }
    
    public static void limpiarComponente(Component component) {
        if (component instanceof JComboBox) {
            ((JComboBox) component).setSelectedIndex(0);
        } else 
        if (component instanceof JTextComponent) {
            ((JTextComponent) component).setText("");
        } else if (component instanceof JDateChooser) {
            ((JDateChooser) component).setDate(null);
        } else if (component instanceof JPanel) {
            for (Component c : ((JPanel) component).getComponents()) {
                limpiarComponente(c);
            }
        }

    }

    
}
