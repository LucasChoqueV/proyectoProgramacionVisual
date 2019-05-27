/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioFormBean implements Serializable{
    
    /**
     * Se declara un objeto de tipo String "id" para almacenar el id del usuario
     * Se declara un objeto de tipo String "password" para almacenar el password del usuario
     * Se declara una instancia de tipo IUsuarioDAO y un objeto de tipo Usuario
     */
    private String id;
    private String password;
    private IUsuarioDAO usuarioDAO;
    private Usuario usuario;
    
    /**
     * La etiqueta @PostConstruct permite que el metodo que se declare debajo se ejecute
     * inmediatamente despues de que la clase de instancie
     * se instancia el objeto usuariDAO y al objeto usuario se le asigna null
     */
    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAOImp();
        usuario = null;
    }
    /**
     * Metodo para verificar los datos de un usuario que intentan logearse
     * se declara un objeto de tipo String "resultado" y se le asinga cadena vacia
     * se declara un objeto de tipo Usuario "usuario" y se le asigna el valor que retorne el metodo
     * verificarDatos del atributo usuarioDAO, este metodo se le pasan por parametro los atributos id y password
     * si la variable "usuario" es distinto de null, quiere decir que se verificaron los datos, entonces
     * se pregunta si el usuario es root1(administrador), si es correcto, a la variable "resultado" se le asigna
     * la direccion de pagina de root, sino se le asigna la direccion de pagina inicio
     * @return 
     */
    public String verificarDatos(){
        String resultado="";
        Usuario usuario = usuarioDAO.verificarDatos(id, password);
        if(usuario != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            if(usuario.getId().equalsIgnoreCase("root1"))
                resultado = "root?faces-redirect=true";
            else
                resultado = "inicio?faces-redirect=true";
            this.usuario = usuario;
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Id o Contraseña incorrectas"));
        }
        return resultado;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IUsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}