/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ListaUsuario implements Serializable{
    
    private List<Usuario> usuarios;

    public ListaUsuario() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("lucas14", "lucas", "Lucas", "Choque", "lucas14_@gmail.com", "San Salvador de Jujuy","image/user.png"));
        usuarios.add(new Usuario("kevin10", "kevin", "Kevin", "Santos", "kevin10_@gmail.com", "San Salvador de Jujuy","image/user.png"));
        usuarios.add(new Usuario("root1", "root", "root", "root", "root@root.root", "root","image/user.png"));
    }
   
    public Usuario verificarDatos(String id, String password){
        Usuario aux = null;
        for(Usuario u : usuarios){
            if(u.getId().equals(id) && u.getPassword().equals(password))
                aux = u;
        }
        return aux;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}