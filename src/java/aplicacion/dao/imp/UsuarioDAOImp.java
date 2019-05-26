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
 *
 * @author Lucas
 */
public class UsuarioDAOImp implements Serializable, IUsuarioDAO{
    
    private ListaUsuario listaUsuario;

    public UsuarioDAOImp() {
        listaUsuario = new ListaUsuario();
    }
    
    

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
