package com.idat.pe.ec1.OscarMunoz.app.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "direccion", nullable = false)
	private String direccion;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references productos(id_producto)"))
	private Producto producto;

	public Integer getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(Integer idBodega) {
		this.idBodega = idBodega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
