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

/**
 *
 * @author Lucas
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean implements Serializable{
    
    private String id;
    private String password;
    private IUsuarioDAO usuarioDAO;
    private Usuario usuario;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    
    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAOImp();
        usuario = null;
    }
    
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