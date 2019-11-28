package com.tikal.toledo;

import com.googlecode.objectify.ObjectifyService;
import com.tikal.cacao.model.Imagen;
import com.tikal.cacao.model.Proveedores;
import com.tikal.cacao.model.RegistroBitacora;
import com.tikal.cacao.model.ReporteRenglon;
import com.tikal.toledo.model.AlertaInventario;
import com.tikal.toledo.model.Cliente;
import com.tikal.toledo.model.DatosEmisor;
import com.tikal.toledo.model.Factura;
import com.tikal.toledo.model.FacturaVTT;
import com.tikal.toledo.model.Lote;
import com.tikal.toledo.model.Perfil;
import com.tikal.toledo.model.Producto;
import com.tikal.toledo.model.Proveedor;
import com.tikal.toledo.model.SerieFactura;
import com.tikal.toledo.model.SerieVenta;
import com.tikal.toledo.model.Tornillo;
import com.tikal.toledo.model.Usuario;
import com.tikal.toledo.model.Venta;

public class Register {
	public Register(){
		ObjectifyService.register(Cliente.class);
		ObjectifyService.register(Lote.class);
		ObjectifyService.register(Producto.class);
		ObjectifyService.register(Tornillo.class);
		ObjectifyService.register(Venta.class);
		ObjectifyService.register(Proveedor.class);
		ObjectifyService.register(Proveedores.class);
		ObjectifyService.register(Usuario.class);
		ObjectifyService.register(Perfil.class);
		ObjectifyService.register(DatosEmisor.class);
		ObjectifyService.register(Factura.class);
		ObjectifyService.register(AlertaInventario.class);
		ObjectifyService.register(SerieFactura.class);
		ObjectifyService.register(SerieVenta.class);
		ObjectifyService.register(FacturaVTT.class);
		ObjectifyService.register(Imagen.class);
		ObjectifyService.register(ReporteRenglon.class);
		ObjectifyService.register(RegistroBitacora.class);
		

	}
}
