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

@ManagedBean
@SessionScoped
public class ProductoFormBean implements Serializable{
    
    /**
     * Se declara una instancia de IProductoDAO
     * Se declara un List de productos
     * Se declara un objeto de tipo Producto
     */
    private IProductoDAO productoDAO;
    private List<Producto> listaProductos;
    private Producto producto;

    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
    }
    /**
     * La etiqueta @PostConstruct permite que el metodo que se declare debajo se ejecute
     * inmediatamente despues de que la clase de instancie
     * Se instancia los objetos producto y productoDAO
     * Se llama al metodo generarProductos
     */
    @PostConstruct
    public void init(){
        producto = new Producto();
        productoDAO = new ProductoDAOImp();
        generarProductos();
    }
    /**
     * Metodo que asigna al atributo listaProductos, la lista de productos del DataSource
     * por medio del metodo obtenerProductos del atributo productoDAO
     */
    public void generarProductos(){
        listaProductos = productoDAO.obtenerProductos();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaProductos",listaProductos);
    }
    /**
     * Metodo que agregar un nuevo producto a la lista de productos
     * se llama al metodo agregarProducto del atributo productoDAO y se pasa por parametro al atributo producto
     * que tiene los datos ingresados desde la vista
     * Se vuelve a instanciar el atributo producto para limpiar los campos y se llama al metodo generarProductos
     * para actualizar la lista. Tambien se muestra un mensaje 
     */
    public void agregarProducto(){
        productoDAO.agregarProducto(producto);
        producto = new Producto();
        generarProductos();
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","El Producto se ha agregado"));
    }
    /**
     * Metodo que elimina un producto de la lista de productos
     * se llama al metodo eliminarProducto del atributo productoDAO y se pasa por parametro el objeto obtenido desde la vista
     * @param p objetos que contiene los datos ingresados en la vista
     * tambien se muestra un mensaje
     */
    public void eliminarProducto(Producto p){
        productoDAO.eliminarProducto(p);
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","El Producto se ha eliminado"));
    }
    /**
     * Metodo que devuelve solo la lista de productos cuya categoria es "computadora"
     * se instancia un List llamada "auxiliarComputadora" y se recorre la lista de productos, por cada iteracion se pregunta
     * si el producto tiene como categoria "computadora", si el IF es TRUE se agrega ese producto a la lista auxiliar
     * @return auxiliarComputadora contiene los productos de tipo computadora
     */
    public List<Producto> listaComputadoras(){
        List<Producto> auxiliarComputadora = new ArrayList<>();
        for(Producto p : listaProductos){
            if(p.getCategoria().equalsIgnoreCase("computadora"))
                auxiliarComputadora.add(p);
        }
        return auxiliarComputadora;
    }
    /**
     * Metodo que devuelve solo la lista de productos cuya categoria es "celular"
     * se instancia un List llamada "auxiliarCelular" y se recorre la lista de productos, por cada iteracion se pregunta
     * si el producto tiene como categoria "celular", si el IF es TRUE se agrega ese producto a la lista auxiliar
     * @return auxiliarCelular contiene los productos de tipo celular
     */
    public List<Producto> listaCelulares(){
        List<Producto> auxiliarCelular = new ArrayList<>();
        for(Producto p : listaProductos){
            if(p.getCategoria().equalsIgnoreCase("celular"))
                auxiliarCelular.add(p);
        }
        return auxiliarCelular;
    }
    /**
     * Metodo necesario para editar una fila del componente DataTable, recibe como parametro un evento
     * se instancia un objeto de tipo producto y se le asigna el evento por medio de un casting. Esto se hace
     * para que se pueda llamar al metodo modoficarProducto del atributo productoDAO y se pueda pasar por 
     * parametro el producto que se ha modificado en la vista. Tambien se muestra un mensaje
     * @param event 
     */
    public void onRowEdit(RowEditEvent event) {
        Producto productoModificado = (Producto)event.getObject();
        productoDAO.modificarProducto(productoModificado);
        FacesContext.getCurrentInstance().addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito","El Producto se ha modificado"));
    }
    /**
     * al igual que el metodo anterior, este metodo es necesario para editar una fila del componente DataTable
     * solo que este se usa cuando se cancela la edicion. Solo se muestra un mensaje 
     * @param event 
     */
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