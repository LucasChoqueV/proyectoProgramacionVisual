/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.modelo.dominio.Usuario;
import aplicacion.modelo.util.ListaUsuario;
import java.io.Serializable;

/**
 * Clase que implementa la interface IUsuarioDAO
 */
public class UsuarioDAOImp implements Serializable, IUsuarioDAO{
    
    /**
     * Se declara un objeto de tipo listaUsuario 
     */
    private ListaUsuario listaUsuario;
    
    /**
     * Constructor por defecto
     */
    public UsuarioDAOImp() {
        listaUsuario = new ListaUsuario();
    }
    /**
     * Se sobreescriben los metodos abstractos de la interface IUsuarioDAO
     * Metodo que verifica los datos de un usuario que intenta logearse
     * se llama al metodo verificarDatos del atributo listaUsuario
     * @param id id del usuario que se desea a verificar
     * @param password password del usuario que se desea verificar
     * @return Retorna el usuario o null, dependiendo si se verifica o no
     */
    @Override
    public Usuario verificarDatos(String id, String password) {
       return listaUsuario.verificarDatos(id, password);
    }

    public ListaUsuario getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;
    }   
}