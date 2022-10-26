package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.OscarMunoz.app.Model.Producto;
import com.idat.pe.ec1.OscarMunoz.app.Repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {
	
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public void guardar(Producto producto) {
		repo.save(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		repo.saveAndFlush(producto);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto obtener(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
