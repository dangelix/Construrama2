/**
 * 
 */
package com.tikal.cacao.dao.imp;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.tikal.cacao.dao.ReporteRenglonDAO;
//import com.tikal.toledo.reporte.ReporteRenglon;
//import com.tikal.cacao.model.Factura;
import com.tikal.cacao.model.ReporteRenglon;

/**
 * @author Tikal
 *
 */
@Repository
public class ReporteRenglonDAOImpl implements ReporteRenglonDAO {

	@Override
	public void guardar(ReporteRenglon r) {
		ofy().save().entity(r).now();

	}

	@Override
	public void guardar(List<ReporteRenglon> lista) {
		ofy().save().entities(lista).now();

	}

	@Override
	public ReporteRenglon consultar(String uuid) {
		return ofy().load().type(ReporteRenglon.class).id(uuid).now();
	}

	@Override
	public List<ReporteRenglon> consultar(String rfcEmisor, String serie, Date fechaI, Date fechaF) {
		List<ReporteRenglon> renglones = null;
		if (serie != null) {
			renglones = ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfcEmisor).filter("serie", serie)
					.filter("fechaCertificacion >=", fechaI).filter("fechaCertificacion <=", fechaF).list();
		} else {
			renglones = ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfcEmisor)
					.filter("fechaCertificacion >=", fechaI).filter("fechaCertificacion <=", fechaF).list();
		}
		return renglones;
	}

	@Override
	public List<ReporteRenglon> consultar(String rfcEmisor, String rfcReceptor, String serie, Date fechaI,
			Date fechaF) {
		List<ReporteRenglon> renglones = ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfcEmisor)
				.filter("serie", serie).filter("rfcRec", rfcReceptor).filter("fecha >=", fechaI)
				.filter("fecha <=", fechaF).list();
		return renglones;
	}

	@Override
	public List<ReporteRenglon> consultarPag(String rfcEmisor, int page) {
		List<ReporteRenglon> renglones = ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfcEmisor)
				.order("-fechaCertificacion").offset(25 * (page - 1)).limit(25).list();
		if (renglones == null) {
			return new ArrayList<>();
		} else {
			return renglones;
		}
	}

	@Override
	public List<ReporteRenglon> consultarPag(String rfcEmisor, String serie, int page) {
		List<ReporteRenglon> renglones = ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfcEmisor)
				.filter("serie", serie).order("- fechaCertificacion").offset(25 * (page - 1)).limit(25).list();
		if (renglones == null) {
			return new ArrayList<>();
		} else {
			return renglones;
		}
	}
	
	@Override
	public int pags(String rfcEmisor) {
		return ((ofy().load().type(ReporteRenglon.class).filter("rfcEmisor",rfcEmisor).count()-1)/25)+1;
	}

	@Override
	public int pags(String rfc, String serie) {
		return ((ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfc).filter("serie", serie).count() - 1)
				/ 25) + 1;
	}

	@Override
	public List<ReporteRenglon> consultarPagRec(String rfcEmisor, String receptor, int page) {
		List<ReporteRenglon> renglones = ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfcEmisor)
				.filter("rfcReceptor", receptor).order("- fechaCertificacion").offset(25 * (page - 1)).limit(25).list();
		if (renglones == null) {
			return new ArrayList<>();
		} else {
			return renglones;
		}
	}

	@Override
	public int pagsRec(String rfc, String receptor) {
		return ((ofy().load().type(ReporteRenglon.class).filter("rfcEmisor", rfc).filter("rfcReceptor", receptor)
				.count() - 1) / 25) + 1;
	}

	@Override
	public void eliminar(String uuid) {
		ofy().delete().type(ReporteRenglon.class).id(uuid).now();
	}

	@Override
	public List<ReporteRenglon> consultarids(String[] ids) {
		Map<String, ReporteRenglon> mapa = ofy().load().type(ReporteRenglon.class).ids(ids);
		List<ReporteRenglon> lista = new ArrayList<ReporteRenglon>();
		Iterator it = mapa.entrySet().iterator();

	    for (Entry<String, ReporteRenglon> e: mapa.entrySet()) {
	        lista.add(e.getValue());
	    }

		return lista;

	}

	@Override
	public List<ReporteRenglon> obtenerPendientesCancelacion() {
		
		return ofy().load().type(ReporteRenglon.class).filter("estatus", "PENDIENTE").list();
	}

}
