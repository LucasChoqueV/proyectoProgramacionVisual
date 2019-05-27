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
 * Clase que funciona de DataSource para almacenar usuarios de la pagina
 */
public class ListaUsuario implements Serializable{
    
    /**
     * Se declara un List de Usuarios para almacenar los usuarios
     */
    private List<Usuario> usuarios;
    /**
     * Constructor por defecto
     * Se instancia la Lista y se le agregan 3 usuarios
     * Solo root1 tiene acceso a la base de datos de productos
     */
    public ListaUsuario() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("lucas14", "lucas", "Lucas", "Choque", "lucas14_@gmail.com", "San Salvador de Jujuy","image/user.png"));
        usuarios.add(new Usuario("kevin10", "kevin", "Kevin", "Santos", "kevin10_@gmail.com", "San Salvador de Jujuy","image/user.png"));
        usuarios.add(new Usuario("root1", "root", "root", "root", "root@root.root", "root","image/user.png"));
    }
    /**
     * Metodo que verifica los datos del usuario
     * @param id almacena el id del usuario a verificar
     * @param password almacena el password del usuario a vericar
     * @return return el usuario o null dependiendo si este se verifica o no
     * se crear un objeto de tipo Usuario y se le asigna null, despues recorremos
     * la lista de usuarios consultando por el id y password, si coinciden se le
     * asigna este usuario a la variable aux
     */
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