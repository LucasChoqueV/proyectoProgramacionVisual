/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IProductoDAO;
import aplicacion.modelo.dominio.Producto;
import aplicacion.modelo.util.ListaProducto;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que implementa la interface IProductoDAO
 */
public class ProductoDAOImp implements Serializable, IProductoDAO{
    
    /**
     * Se declara un objeto de tipo ListaProducto para acceder a sus metodos y atributos
     */
    private ListaProducto listaProducto;
    /**
     * Constructor por defecto
     * Se instancia listaProductos
     */
    public ProductoDAOImp(){
        listaProducto = new ListaProducto();
    }
    /**
     * Se sobreescriben los metodos de la interface IProductoDAO
     * metodo que agregar un producto a la lista de productos
     * se llama al metodo agregarProducto del atributo listaProducto
     * @param p almacena el producto que se desea almacenar
     */
    @Override
    public void agregarProducto(Producto p) {
        listaProducto.agregarProducto(p);
    }
    /**
     * metodo que elimina un producto de la lista de productos
     * se llama al metodo eliminarProducto del atributo listaProducto
     * @param p alamcena el producto que se desea eliminar
     */
    @Override
    public void eliminarProducto(Producto p) {
        listaProducto.eliminarProducto(p);
    }
    /**
     * metodo que modifica un producto de la lista de productos
     * se llama al metodo modoficarProducto del atributo listaProducto
     * @param p almacena el producto que se desea modificar
     */
    @Override
    public void modificarProducto(Producto p) {
        listaProducto.modificarProducto(p);
    }
    /**
     * metodo que devuelve la lista de productos
     * se llama al metodo getter del atributo listaProducto
     * @return la lista de productos
     */
    @Override
    public List<Producto> obtenerProductos() {
        return listaProducto.getProductos();
    }

    public ListaProducto getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ListaProducto listaProducto) {
        this.listaProducto = listaProducto;
    }
}