package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.app.Model.Usuario;


public interface UsuarioService {
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminar(Integer id);
    List<Usuario> listar();
    Usuario obtener(Integer id);
}
