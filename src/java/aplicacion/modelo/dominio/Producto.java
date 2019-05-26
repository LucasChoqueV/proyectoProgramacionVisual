/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Producto implements Serializable{
    
    private int codigoProducto;
    private int precioProducto;
    private int stock;
    private String nombreProducto;
    private String caracteristicas;
    private String imagen;
    private String categoria;

    public Producto() {
    }

    public Producto(int codigoProducto, int precioProducto, int stock, String nombreProducto, String caracteristicas, String imagen, String categoria) {
        this.codigoProducto = codigoProducto;
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.nombreProducto = nombreProducto;
        this.caracteristicas = caracteristicas;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", precioProducto=" + precioProducto + ", stock=" + stock + ", nombreProducto=" + nombreProducto + ", caracteristicas=" + caracteristicas + ", imagen=" + imagen + ", categoria=" + categoria + '}';
    }   
}