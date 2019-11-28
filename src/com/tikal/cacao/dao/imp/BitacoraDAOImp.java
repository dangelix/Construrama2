package com.tikal.cacao.dao.imp;

import java.util.Date;
import java.util.List;

import com.tikal.cacao.dao.BitacoraDAO;
import com.tikal.cacao.model.RegistroBitacora;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class BitacoraDAOImp implements BitacoraDAO {

	@Override
	public boolean addReg(RegistroBitacora r) {
		ofy().save().entity(r).now();
		return true;
	}

	@Override
	public List<RegistroBitacora> getBitacora(String tipo) {
		
		return ofy().load().type(RegistroBitacora.class).filter("tipo",tipo).limit(30).list();
	}

	@Override
	public List<RegistroBitacora> getBitacora(String tipo, Date inicio, Date fin) {
		
		return ofy().load().type(RegistroBitacora.class).filter("tipo",tipo).filter("fecha >=",inicio).filter("fecha <=", fin).list();
	}

	@Override
	public List<RegistroBitacora> getBitacora(String tipo, String usuario) {
		
		return ofy().load().type(RegistroBitacora.class).filter("tipo",tipo).filter("usuario",usuario).list();
	}

	@Override
	public boolean addReg(String tipo, String usuario, String accion) {
		RegistroBitacora r= new RegistroBitacora();
		r.setEvento(accion);
		r.setTipo(tipo); 
		r.setUsuario(usuario);
		this.addReg(r);
		return true;
	}

}
