/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ICompraDAO;
import aplicacion.modelo.dominio.Producto;
import aplicacion.modelo.util.ListaCompra;
import java.io.Serializable;
import java.util.List;
/**
 * Clase que implementa la inferface ICompraDAO
 */
public class CompraDAOImp implements Serializable, ICompraDAO{
    
    /**
     * Se declara una atributo de Tipo ListaCompra para llamar a sus metodos y atributos
     */
    private ListaCompra listaCompra;
    /**
     * Constructor por defecto
     * Se instancia el atributo
     */
    public CompraDAOImp() {
        listaCompra = new ListaCompra();
    }
    /**
     * Se sobreescribe los metodos abstracto de la interface ICompraDAO
     * Metodo que agregar un producto llamando al metodo del atributo listaCompra
     * @param p almacena el producto que se desea almacenar
     */
    @Override
    public void agregarCompra(Producto p) {
        listaCompra.agregarCompra(p);
    }
    /**
     * Metodo que retorna la lista de productos comprados, este metodo llama al metodo del atributo listaCompra
     * @return listaCompra
     */
    @Override
    public List<Producto> obtenerProductoCompra() {
        return listaCompra.getListaCompra();
    }
    /**
     * Metodo que limpia la lista de productos comprados, este metodo llama al metodo del atributo listaCompra
     */
    @Override
    public void resetearCompra() {
        listaCompra.resetearCompra();
    }
}