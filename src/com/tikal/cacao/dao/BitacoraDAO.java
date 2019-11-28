package com.tikal.cacao.dao;

import java.util.Date;
import java.util.List;

import com.tikal.cacao.model.RegistroBitacora;

public interface BitacoraDAO {
 
	public boolean addReg(RegistroBitacora r);
	public boolean addReg(String tipo, String usuario, String accion);
	public List<RegistroBitacora> getBitacora(String tipo);
	public List<RegistroBitacora> getBitacora(String tipo,Date inicio, Date fin);
	public List<RegistroBitacora> getBitacora(String tipo,String usuario);
}
