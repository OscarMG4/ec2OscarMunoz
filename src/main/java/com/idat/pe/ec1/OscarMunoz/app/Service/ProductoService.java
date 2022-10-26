package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.app.Model.Producto;

public interface ProductoService {
    void guardar(Producto producto);
    void actualizar(Producto producto);
    void eliminar(Integer id);
    List<Producto> listar();
    Producto obtener(Integer id);
}
