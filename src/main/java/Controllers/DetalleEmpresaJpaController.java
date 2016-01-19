/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entitys.Detalleempresa;
import Entitys.Empresa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author GabrielRD
 */
public class DetalleEmpresaJpaController extends Controlador<Detalleempresa> {
    
    public DetalleEmpresaJpaController() {
         super(Detalleempresa.class);
    }
    
     public List<Detalleempresa> integrantesXempresa(Empresa oempresa) {
        String jpql = "SELECT d FROM Detalleempresa d WHERE d.idEmpresa = :oempresa";               
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("oempresa", oempresa);
        return this.getDao().buscar(jpql, mapa);
    }
}
