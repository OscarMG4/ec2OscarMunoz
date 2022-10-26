package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.app.Model.Bodega;

public interface BodegaService {
    void guardar(Bodega bodega);
    void actualizar(Bodega bodega);
    void eliminar(Integer id);
    List<Bodega> listar();
    Bodega obtener(Integer id);
}
