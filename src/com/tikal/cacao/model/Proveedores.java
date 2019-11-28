package com.tikal.cacao.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Proveedores {
	@Id
	Long id;
	
	boolean[] activos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean[] getActivos() {
		return activos;
	}

	public void setActivos(boolean[] activos) {
		this.activos = activos;
	}
	
	public boolean isActivo(int index){
		return this.activos[index];
	}
}
