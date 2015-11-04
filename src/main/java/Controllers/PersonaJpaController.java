/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Entitys.Persona;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class PersonaJpaController extends Controlador<Persona> {

    public PersonaJpaController() {
         super(Persona.class);
    }
    
    public List<Persona> buscarXPatron(String patron) {
        String jpql = "SELECT p FROM Persona p WHERE p.numIdentificacion LIKE CONCAT('%',:patron,'%') OR p.nombre LIKE CONCAT('%',:patron,'%')";               
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("patron", patron);
        return this.getDao().buscar(jpql, mapa);
    }
}
