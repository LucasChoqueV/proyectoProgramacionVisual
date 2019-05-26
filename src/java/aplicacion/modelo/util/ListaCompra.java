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
 *
 * @author Lucas
 */
public class ListaCompra implements Serializable{
    
    private List<Producto> listaCompra;

    public ListaCompra() {
        listaCompra = new ArrayList<>();
    }
    
    public void agregarCompra(Producto p){
        Producto auxiliar = p;
        listaCompra.add(auxiliar);
        mostrar();
    }
    
    public void resetearCompra(){
        listaCompra.clear();
    }
    
    public void mostrar(){
        System.out.println("Lista de compra");
        for(Producto p : listaCompra)
            System.out.println(p.toString());
    }

    public List<Producto> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Producto> listaCompra) {
        this.listaCompra = listaCompra;
    }
    
}