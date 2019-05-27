/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Producto;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Clase que funciona como DataSource para almacenar todos los productos
 */
public class ListaProducto implements Serializable{
    
    /**
     * Se declara un List de productos para almacenar los productos
     * Se declara un atributo estatico "codigo" de tipo int, para que funcione como el codigo del producto
     */
    private List<Producto> productos;
    private static int codigo;
    
    /**
     * Constructor por defecto
     * el atributo "codigo" se inicializa en 8 ya que hay pre-cargados 8 productos
     * si no se pre-cargarian esos productos, el codigo se inicializa en 0
     */
    public ListaProducto() {
        codigo = 8;
        productos = new ArrayList<>();
        productos.add(new Producto(1, 48932, 4,"Dell Latitude","Intel i7 8GB RAM 256GB SSD", "image/productos/prod2.jpg","computadora"));
        productos.add(new Producto(2, 10239, 6,"Samsung Galaxy S8 plus","Kirin520 4GB RAM 32GB Interna", "image/productos/prod1.jpg","celular"));
        productos.add(new Producto(3, 42381,2,"Lenovo Think Pad","Intel I5 8GB RAM 1TB HDD","image/productos/prod3.jpg","computadora"));
        productos.add(new Producto(4, 18999,2,"Motorola Moto Z Play","Snapdragon 3GB RAM 32GB Interna","image/productos/prod6.jpg","celular"));
        productos.add(new Producto(5, 36782,2,"Asus Vivabook S510U","Intel I5 4GB RAM 1TB HDD","image/productos/prod4.jpg","computadora"));
        productos.add(new Producto(6, 93938,2,"Acer Predator","Intel I7 16GB RAM 512GB SDD","image/productos/prod5.jpg","computadora"));
        productos.add(new Producto(7, 28432,2,"Huawei P20 Lite","Kirin970 6GB RAM 120GB Interna","image/productos/prod7.jpg","celular"));
        productos.add(new Producto(8, 31442,2,"Asos Rog Phone","Snapdragon 845 8GB RAM 120GB Interna","image/productos/prod8.jpg","celular"));
    }
    /**
     * metodo para agregar un producto a la lista de productos
     * @param p tiene almacenado el producto que deseo almacenar en la lista
     * se crear una producto auxiliar para evitar que 2 o mas productos tengan la misma referencia
     * incremento mi atributo estatico en 1 y al producto que voy a almacenar le asigno ese codigo
     */
    public void agregarProducto(Producto p){
        Producto aux = new Producto();
        aux = p;
        codigo++;
        aux.setCodigoProducto(codigo);
        productos.add(aux);
    }
    /**
     * metodo para eliminar un producto de la lista de productos
     * @param p tiene almacenado el codigo de producto que deseo eliminar de la lista
     * mediante un FOR se recorre la lista, preguntando con un IF si el codigo de la variable p
     * es igual a alguno de la lista de producto, si el IF es TRUE, ese producto se elimina sino
     * no se hace nada
     */
    public void eliminarProducto(Producto p){
        for(int i=0;i<productos.size();i++){
            if(productos.get(i).getCodigoProducto() == p.getCodigoProducto())
                productos.remove(i);
        }
    }
    /**Metodo que modifica un producto de la lista de productos
     * @param p tiene almacenado el producto que deseo modificar
     * mediante un FOR EACH se recorre la lista, preguntando con un IF si codigo la variable p
     * es igual a alguno de la lista de productos, si el IF es TRUE se reemplaza
     */
    public void modificarProducto(Producto p){
        for(Producto prod: productos){
            if(prod.getCodigoProducto() == p.getCodigoProducto())
                prod=p;
        }
    }
  
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}