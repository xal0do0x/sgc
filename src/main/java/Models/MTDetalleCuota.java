/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Cuota;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.observablecollections.ObservableListListener;

/**
 *
 * @author Aldo
 */
public class MTDetalleCuota extends AbstractTableModel implements ObservableListListener {
    
    private List<Cuota> listaCuotas;
    private String[] nombreColumnas = {"Fecha Vencimiento","Fecha Pago","Mora","Monto","Monto Cobrado","Estado"};
    private final DateFormat dfFecha;
    public MTDetalleCuota(List<Cuota> datos) {
        this.listaCuotas = datos;
        dfFecha = new SimpleDateFormat("dd-MM-yyyy"); 
        if(datos instanceof ObservableList){
            ((ObservableList) listaCuotas).addObservableListListener(this);
        }
    }
    
    private static final Logger LOG = Logger.getLogger(MTDetalleCuota.class.getName());
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Cuota seleccionada = this.listaCuotas.get(rowIndex);
            
            switch (columnIndex) {
                case 1:
                    Date fechaPago = dfFecha.parse(aValue.toString());
                    seleccionada.setFechaPago(fechaPago);
                    break;
                case 2:
                    Double mora = (Double) aValue;
                    seleccionada.setMora(mora);                           
                    break;
                case 5:
                    String estado = aValue.toString();
                    seleccionada.setEstado(estado);
                    break;
            }
            this.fireTableCellUpdated(rowIndex, columnIndex);
        } catch (ParseException ex) {
            Logger.getLogger(MTDetalleCuota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1 || columnIndex == 2 || columnIndex == 5; 
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public int getRowCount() {
        return this.listaCuotas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {        
        if (columnIndex == 1) {
            return Date.class;
        } else if (columnIndex == 2 ) {
            return Double.class;
        } else if (columnIndex == 5) {
            return String.class;
        } else {
            return Object.class;
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuota cuota = this.listaCuotas.get(rowIndex);
        switch(columnIndex){
            case 0:
                return dfFecha.format(cuota.getFechaVencimiento());               
            case 1:
                if(cuota.getFechaPago()==null){
                    return "Aun sin pagar";
                }else{
                    return dfFecha.format(cuota.getFechaPago());
                }
                
            case 2:
                return cuota.getMora();
            case 3:
                return cuota.getMonto();
            case 4:
                double montoCobrado = 0;
                    if( cuota.getMora()!=0 && cuota.getMonto()!= 0){
                        montoCobrado = cuota.getMonto()+ cuota.getMora();
                    }                    
                    if (montoCobrado == 0) {
                        return null;
                    } else {                       
                        return montoCobrado;
                    }
            case 5:
                return cuota.getEstado();
            default:
                return null;
        }
    }
    @Override
    public void listElementsAdded(ObservableList ol, int i, int i1) {
       // LOG.info("AGREGADO: " + i + " " + i1);
        this.fireTableRowsInserted(i1, i1);
    }

    @Override
    public void listElementsRemoved(ObservableList ol, int i, List list) {
       // LOG.info(i + "");
        this.fireTableRowsDeleted(i, i);
    }

    @Override
    public void listElementReplaced(ObservableList ol, int i, Object o) {
        this.fireTableRowsUpdated(i, i);
    }

    @Override
    public void listElementPropertyChanged(ObservableList ol, int i) {
        this.fireTableRowsUpdated(i, i);
    }
}
