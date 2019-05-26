/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.dao.ICompraDAO;
import aplicacion.dao.imp.CompraDAOImp;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lucas
 */
@ManagedBean
@ApplicationScoped
public class CompraFormBean implements Serializable {
    
    private ICompraDAO productoDAO;
    private Producto productoCompra;
    private List<Producto> listaProductoCompra;
    /**
     * Creates a new instance of CompraFormBean
     */
    public CompraFormBean() {
    }
    @PostConstruct
    public void init(){
        productoCompra = new Producto();
        productoDAO = new CompraDAOImp();
        generarProductoCompra();
        
    }
    //resetar esto cuando el usuario entre desde el login
    
    public void agregarCompra(){
        productoDAO.agregarCompra(productoCompra);
        generarProductoCompra();
    }
    
    public void resetearCompra(){
        productoDAO.resetearCompra();
    }
    
    public int obtenerTotalCompra(){
        int total = 0;
        for(Producto p: listaProductoCompra)
            total+=p.getPrecioProducto();
        return total;
    }
    public void generarProductoCompra(){
        listaProductoCompra = productoDAO.obtenerProductoCompra();
    }
    public ICompraDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(ICompraDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public Producto getProductoCompra() {
        return productoCompra;
    }

    public void setProductoCompra(Producto productoCompra) {
        this.productoCompra = productoCompra;
    }

    public List<Producto> getListaProductoCompra() {
        return listaProductoCompra;
    }

    public void setListaProductoCompra(List<Producto> listaProductoCompra) {
        this.listaProductoCompra = listaProductoCompra;
    }
}