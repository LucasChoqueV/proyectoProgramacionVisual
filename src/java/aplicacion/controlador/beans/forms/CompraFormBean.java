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
 * Clase ManagedBean 
 */
@ManagedBean
@ApplicationScoped
public class CompraFormBean implements Serializable {
    
    /**
     * Se declara una instancia de ICompraDAO
     * Se declara un objeto de tipo Producto
     * Se declara un List de productos
     */
    private ICompraDAO productoDAO;
    private Producto productoCompra;
    private List<Producto> listaProductoCompra;
    /**
     * Creates a new instance of CompraFormBean
     */
    public CompraFormBean() {
    }
    /**
     * La etiqueta @PostConstruct permite que el metodo que se declare debajo se ejecute
     * inmediatamente despues de que la clase de instancie
     * Se instancia los atributos productoCompra y productoDAO y se llama al metodo generarProductoCompra
     */
    @PostConstruct
    public void init(){
        productoCompra = new Producto();
        productoDAO = new CompraDAOImp();
        generarProductoCompra();
        
    }
    /**
     * Metodo que le asigna al atributo listaProductoCompra la lista de compras del DataSource
     * por medio del metodo obtenerProductoCompra del atributo productoDAO
     */
    public void generarProductoCompra(){
        listaProductoCompra = productoDAO.obtenerProductoCompra();
    }
    /**
     * Metodo que agregar un producto comprado
     * llama al metodo agregarCompra del atributo productoDAO y le pasa por parametro
     * el atributo productoCompra, que almacena los datos ingresados desde la vista
     * tambien llama al metodo generarProductoCompra para actualizar los datos
     */
    public void agregarCompra(){
        productoDAO.agregarCompra(productoCompra);
        generarProductoCompra();
    }
    /**
     * metodo que desea la lista de compra por medio del metodo resetarCompra del atributo productoDAO
     */
    public void resetearCompra(){
        productoDAO.resetearCompra();
    }
    /**
     * metodo que obtiene el total de la compra de la lista de compra
     * se declara una variable "total" y se la inicializa en 0
     * se recorre la lista de productos comprados y por cada iteracion se acumula
     * el precio de los productos
     * @return total, que tiene el total de todos los productos comprados
     */
    public int obtenerTotalCompra(){
        int total = 0;
        for(Producto p: listaProductoCompra)
            total+=p.getPrecioProducto();
        return total;
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