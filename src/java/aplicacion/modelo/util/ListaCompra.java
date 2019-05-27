/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que funciona como DataSource para almacenar la lista de compras
 */
public class ListaCompra implements Serializable{
    
    /**
    Se declara un List de productos para almacenar los objetos de tipo productos que el usuario compre
    */
    private List<Producto> listaCompra;
    /**
     * Se instancia la Lista de productos
     */
    public ListaCompra() {
        listaCompra = new ArrayList<>();
    }
    /**
     * este metodo agregar el producto en la lista de productos comprados, se crear
     * un objeto Producto llamado auxiliar para evitar tener 2 o mas objetos con la misma referencia
     * @param p: tiene almacenado el producto que el usuario comrpo con todas sus caracteristicas 
     */
    public void agregarCompra(Producto p){
        Producto auxiliar = p;
        listaCompra.add(auxiliar);
    }
    /**
     * Este metodo limpia la lista de compras
     */
    public void resetearCompra(){
        listaCompra.clear();
    }
    
    public List<Producto> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Producto> listaCompra) {
        this.listaCompra = listaCompra;
    }
}