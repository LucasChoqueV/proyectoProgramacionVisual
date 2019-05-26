/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Lucas
 */
@ManagedBean
@SessionScoped
public class ProductoFormBean implements Serializable{
    
    private IProductoDAO productoDAO;
    private List<Producto> listaProductos;
    private Producto producto;

    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
    }
    
    @PostConstruct
    public void init(){
        producto = new Producto();
        productoDAO = new ProductoDAOImp();
        generarProductos();
    }
    
    public void agregarProducto(){
        productoDAO.agregarProducto(producto);
        producto = new Producto();
        generarProductos();
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","El Producto se ha agregado"));
    }
    public void eliminarProducto(Producto p){
        productoDAO.eliminarProducto(p);
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","El Producto se ha eliminado"));
    }
    
    public void generarProductos(){
        listaProductos = productoDAO.obtenerProductos();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaProductos",listaProductos);
    }
    
    public List<Producto> listaComputadoras(){
        List<Producto> auxiliarComputadora = new ArrayList<>();
        for(Producto p : listaProductos){
            if(p.getCategoria().equalsIgnoreCase("computadora"))
                auxiliarComputadora.add(p);
        }
        return auxiliarComputadora;
    }
    public List<Producto> listaCelulares(){
        List<Producto> auxiliarCelular = new ArrayList<>();
        for(Producto p : listaProductos){
            if(p.getCategoria().equalsIgnoreCase("celular"))
                auxiliarCelular.add(p);
        }
        return auxiliarCelular;
    }
    
    public void onRowEdit(RowEditEvent event) {
        Producto productoModificado = (Producto)event.getObject();
        productoDAO.modificarProducto(productoModificado);
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","El Producto se ha modificado"));
    }
    public void onRowEditCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Edicion Cancelada","La edicion del Producto se ha cancelado"));
    }
    public IProductoDAO getProductoDAO() {
        return productoDAO;
    }
    public void setProductoDAO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos; 
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}