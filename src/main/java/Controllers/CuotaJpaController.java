/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Entitys.Credito;
import Entitys.Cuota;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class CuotaJpaController extends Controlador<Cuota> {

    public CuotaJpaController() {
         super(Cuota.class);
    }
    
    public List<Cuota> buscarXCredito(Credito credito){
        String jpql = "SELECT c FROM Cuota c WHERE c.idCredito = :credito ORDER BY c.fechaVencimiento";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("credito", credito);
        return this.getDao().buscar(jpql, mapa);
    }
    
}
