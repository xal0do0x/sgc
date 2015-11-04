/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Entitys.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Gabriel
 */
public class UsuarioJpaController extends Controlador<Usuario> {

    public UsuarioJpaController() {
        super(Usuario.class);
    }
    
    public List<Usuario> buscarXNombre(String nombre) {        
        Query query = JpaUtil.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario");
        query.setParameter("usuario", nombre);
        return query.getResultList();
    }
    
    
}
