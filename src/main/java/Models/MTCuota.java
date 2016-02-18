/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Cuota;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Aldo
 */
public class MTCuota extends ModeloTabla<Cuota>{
    
    private final DateFormat dfFecha;
    public MTCuota(List<Cuota> datos) {
        super(datos);
        this.nombreColumnas = new String[]{"Fecha Vencimiento","Fecha Pago","Mora","Monto","Monto Cobrado","Estado"}; 
        dfFecha = new SimpleDateFormat("dd-MM-yyyy");    
    }
    
    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Cuota cuota = this.datos.get(rowIndex);
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
                return cuota.getMontoCobrado();
            case 5:
                return cuota.getEstado();
            default:
                return null;
        }
    }
}
