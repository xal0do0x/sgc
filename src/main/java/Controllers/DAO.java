/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gabriel
 * @param <T>
 */
public class DAO<T> {

    private final String PU = "SistemaDeCreditos_PU";
    private EntityManager em;
    private final Class<T> clase;

    public DAO(Class<T> clase) {
        this.clase = clase;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.PU);
            em = emf.createEntityManager();
        }
        return em;
    }

    public void guardar(T objeto) {

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(objeto);
        getEntityManager().getTransaction().commit();
    }

    public void modificar(T objeto) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(objeto);
        getEntityManager().getTransaction().commit();
    }

    public void eliminar(T objeto) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(objeto);
        getEntityManager().getTransaction().commit();
    }

    public List<T> buscar(String queryJPQL) {
        return this.buscar(queryJPQL, null, -1, -1);
    }

    public List<T> buscar(String queryJPQL, Map<String, Object> parametros) {
        return this.buscar(queryJPQL, parametros, -1, -1);
    }
    

    public List<T> buscar(String queryJPQL, Map<String, Object> parametros, int offset, int limit) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (offset != -1) {
            query.setFirstResult(offset);
        }

        if (limit != -1) {
            query.setMaxResults(limit);
        }

        List<T> lista = query.getResultList();

        return lista;
    }
    
    public void ejecutarQuery(String queryJPQL, Map<String, Object> parametros, int offset, int limit){
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (offset != -1) {
            query.setFirstResult(offset);
        }

        if (limit != -1) {
            query.setMaxResults(limit);
        }

        query.executeUpdate();
    }

    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(clase);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int contarFiltro(String queryJPQL, Map<String, Object> parametros) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return  ((Long) query.getSingleResult()).intValue();
    }
    
    public String buscarUltimo(String queryJPQL, Map<String, Object> parametros) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return  query.getSingleResult().toString();
    }

    public T buscarPorId(Object id) {
        return getEntityManager().find(clase, id);
    }
}
