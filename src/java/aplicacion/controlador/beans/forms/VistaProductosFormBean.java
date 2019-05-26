/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucas
 */
@ManagedBean
@SessionScoped
public class VistaProductosFormBean implements Serializable {
    
     private List<String> images;
    /**
     * Creates a new instance of vistaProductos
     */
     @PostConstruct
     public void init(){
         images = new ArrayList<>();
         for(int i=1; i<=5; i++){
             images.add("prod"+i+".jpg");
         }
     }
     
     public List<String> getImages(){
         return images;
     }
}