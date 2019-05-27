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

@ManagedBean
@SessionScoped
public class VistaProductosFormBean implements Serializable {
    
    /**
     * se declara un List de string para almacenar las direcciones de las imagenes
     */
     private List<String> images;
     /**
      * La etiqueta @PostConstruct permite que el metodo que se declare debajo se ejecute
     * inmediatamente despues de que la clase de instancie
     * el metodo init instancia la variable images
     * se hace un recorrido en donde se almacena el nombre de las imagenes
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