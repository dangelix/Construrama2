package com.tikal.cacao.dao.imp;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.tikal.cacao.dao.ProveedoresDAO;
import com.tikal.cacao.model.Proveedores;

public class ProveedoresDAOImp implements ProveedoresDAO{

	@Override
	public Proveedores getProveedores() {
		List<Proveedores> p= ofy().load().type(Proveedores.class).list();
		if(p.size()>0){
			return p.get(0);
		}else{
			Proveedores pr= new Proveedores();
			boolean[] a= {false,true};
			pr.setActivos(a);
			ofy().save().entity(pr).now();
			return pr;
		}
	}
	
}
