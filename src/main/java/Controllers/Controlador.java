/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GabrielRD
 * @param <T>
 */
public abstract class Controlador<T> {

    private final DAO<T> dao;
    public static final int NUEVO = 1;
    public static final int MODIFICAR = 2;
    public static final int ELIMINAR = 3;
    private T seleccionado;
    private final Class<T> seleccionadoClass;
    private int conteo;

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    public T getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(T seleccionado) {
        this.seleccionado = seleccionado;
    }

    public DAO<T> getDao() {
        return dao;
    }

    public Controlador(Class<T> clase) {
        this.seleccionadoClass = clase;
        this.dao = new DAO<>(clase);
    }

    private void guardar(T objeto) {
        this.dao.guardar(objeto);
    }

    private void modificar(T objeto) {
        this.dao.modificar(objeto);
    }

    private void eliminar(T objeto) {
        this.dao.eliminar(objeto);
    }

    public List<T> buscarTodos() {
        return this.dao.buscarTodos();
    }

    public T buscarPorId(Object id) {
        return this.dao.buscarPorId(id);
    }

    public List<T> buscar(String nombre) {
        return this.dao.buscar(nombre);
    }

    public int conteo() {
        return this.dao.contar();
    }

    public void prepararCrear() {
        try {
            seleccionado = seleccionadoClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int accion(int accion) {
        if (accion == Controlador.NUEVO) {
            this.guardar(seleccionado);
            return 1;
        } else if (accion == Controlador.MODIFICAR) {
            this.modificar(seleccionado);
            return 2;
        } else if (accion == Controlador.ELIMINAR) {
            this.eliminar(seleccionado);
            return 3;
        }
        return 0;
    }
}
