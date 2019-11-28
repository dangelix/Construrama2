package com.tikal.cacao.dao;

import java.util.Date;
import java.util.List;

import com.tikal.cacao.model.ReporteRenglon;

public interface ReporteRenglonDAO {
	
	void guardar(ReporteRenglon r);
	
	void guardar(List<ReporteRenglon> lista);
	
	com.tikal.cacao.model.ReporteRenglon consultar(String uuid);
	
	List<ReporteRenglon> consultar(String rfcEmisor, String serie, Date fechaI, Date fechaF);
	
	List<ReporteRenglon> consultar(String rfcEmisor, String rfcReceptor, String serie, Date fechaI, Date fechaF);
	
	List<ReporteRenglon> consultarPag(String rfcEmisor, int page);
	
	List<ReporteRenglon> consultarPag(String rfcEmisor, String serie, int page);
	
	List<ReporteRenglon> consultarPagRec(String rfcEmisor, String receptor, int page);
	
	List<ReporteRenglon> consultarids(String[] ids);
	
	int pags(String rfcEmisor);
	
	int pags(String rfc, String serie);
	
	int pagsRec(String rfc, String receptor);
	
	/**
	 * <h2>Atenci&oacute;n</h2>
	 * <p>El prop&oacute;sito de este m&eacute;todo es borrar los <em>entities<em> {@code ReporteRenglon}
	 * cuyo atributo estatus tiene el valor de <strong>GENERADO</strong> y se creo otro 
	 * <em>entity</em> {@code ReporteRenglon} con un estatus de <strong>TIMBRADO</strong></p>
	 * @param uuid
	 */
	void eliminar(String uuid);
	
	List<ReporteRenglon> obtenerPendientesCancelacion();
}
