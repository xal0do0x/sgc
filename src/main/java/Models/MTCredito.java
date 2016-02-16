/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entitys.Credito;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Aldo
 */
public class MTCredito extends ModeloTabla<Credito>{
    
    private final DateFormat dfFecha;
    public MTCredito(List<Credito> datos) {
        super(datos);
        this.nombreColumnas = new String[]{"Cliente","DNI/RUC","Monto","Fecha Inicio","Fecha Fin"};
        dfFecha = new SimpleDateFormat("dd.MM.yyyy");      
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Credito credito = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0:
                if(credito.getIdEmpresa()==null){
                    return credito.getIdPersona().getApellidos();
                }else{
                    return credito.getIdEmpresa().getNombre();
                }
                
            case 1:
                if(credito.getIdEmpresa()==null){
                    return credito.getIdPersona().getDni();
                }else{
                    return credito.getIdEmpresa().getRuc();
                }
            case 2:
                return credito.getMonto();
            case 3:
                return dfFecha.format(credito.getFechaInicio());
            case 4:
                return dfFecha.format(credito.getFechaFinal());
            default:
                return null;
        }
    }
}
