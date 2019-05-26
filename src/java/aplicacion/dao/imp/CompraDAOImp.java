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
 *
 * @author Lucas
 */
public class CompraDAOImp implements Serializable, ICompraDAO{
    
    private ListaCompra listaCompra;

    public CompraDAOImp() {
        listaCompra = new ListaCompra();
    }
    
    @Override
    public void agregarCompra(Producto p) {
        listaCompra.agregarCompra(p);
    }

    @Override
    public List<Producto> obtenerProductoCompra() {
        return listaCompra.getListaCompra();
    }

    @Override
    public void resetearCompra() {
        listaCompra.resetearCompra();
    }
}