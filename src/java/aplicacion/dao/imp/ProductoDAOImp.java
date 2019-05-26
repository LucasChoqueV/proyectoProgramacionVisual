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
 *
 * @author Lucas
 */
public class ProductoDAOImp implements Serializable, IProductoDAO{
    
    private ListaProducto listaProducto;
    
    public ProductoDAOImp(){
        listaProducto = new ListaProducto();
    }
    @Override
    public void agregarProducto(Producto p) {
        listaProducto.agregarProducto(p);
    }

    @Override
    public void eliminarProducto(Producto p) {
        listaProducto.eliminarProducto(p);
    }

    @Override
    public void modificarProducto(Producto p) {
        listaProducto.modificarProducto(p);
    }
    
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