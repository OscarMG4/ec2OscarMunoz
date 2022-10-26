package com.idat.pe.ec1.OscarMunoz.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.idat.pe.ec1.OscarMunoz.app.Model.Bodega;
import com.idat.pe.ec1.OscarMunoz.app.Service.BodegaService;

@RestController
@RequestMapping("/api/bodega")
public class BodegaController {
	
	@Autowired
	private BodegaService service;
	
    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Bodega>> obtenerProductos() {
        return new ResponseEntity<List<Bodega>>(service.listar(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bodega> buscarProducto(@PathVariable Integer id) {
    	Bodega bodega = service.obtener(id);

        if (bodega != null) {
            return new ResponseEntity<Bodega>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Bodega>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Bodega bodega) {
        if (bodega != null) {
            service.guardar(bodega);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Bodega bodega) {
        Bodega bodegaId = service.obtener(bodega.getIdBodega());

        if (bodega != null) {
            service.actualizar(bodega);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Bodega bodega = service.obtener(id);
        
        if (bodega != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

	
}
