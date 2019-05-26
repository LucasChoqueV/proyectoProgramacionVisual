/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Caracteristicas;
import aplicacion.modelo.dominio.Producto;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class ListaProducto implements Serializable{
    
    private List<Producto> productos;
    private static int codigo;

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
    public void agregarProducto(Producto p){
        Producto aux = new Producto();
        aux = p;
        codigo++;
        aux.setCodigoProducto(codigo);
        productos.add(aux);
    }
    public void eliminarProducto(Producto p){
        for(int i=0;i<productos.size();i++){
            if(productos.get(i).getCodigoProducto() == p.getCodigoProducto())
                productos.remove(i);
        }
    }
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