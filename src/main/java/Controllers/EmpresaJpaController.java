/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Entitys.Empresa;
import Entitys.Persona;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class EmpresaJpaController extends Controlador<Empresa> {

    public EmpresaJpaController() {
        super(Empresa.class);
    }
    
    public List<Empresa> buscarXPatron(String patron) {
        String jpql = "SELECT e FROM Empresa e WHERE e.nombre LIKE CONCAT('%',:patron,'%') OR e.ruc LIKE CONCAT('%',:patron,'%')";               
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("patron", patron);
        return this.getDao().buscar(jpql, mapa);
    }
    
    
   
}
