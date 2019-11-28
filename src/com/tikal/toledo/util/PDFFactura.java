package com.tikal.toledo.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;				
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.ExtendedColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.tikal.cacao.model.Imagen;
import com.tikal.cacao.util.CustomColor;
import com.tikal.toledo.factura.Estatus;
import com.tikal.toledo.model.Venta;
import com.tikal.toledo.sat.cfd.Comprobante;
import com.tikal.toledo.sat.cfd.Comprobante.Conceptos.Concepto;
import com.tikal.toledo.sat.cfd.Comprobante.Impuestos.Retenciones.Retencion;
import com.tikal.toledo.sat.cfd.Comprobante.Impuestos.Traslados.Traslado;
import com.tikal.toledo.sat.timbrefiscaldigital.TimbreFiscalDigital;

/**
 * @author Tikal
 *
 */
public class PDFFactura {

	private Document document;
	private static String IVA = "IVA";
	private static String IEPS = "IEPS";
	private static String ISR = "ISR";
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private MyFooter pieDePagina = new MyFooter(null);

	private Font fontTituloSellos = new Font(Font.FontFamily.HELVETICA, 6.5F, Font.BOLD);
	private Font fontContenidoSellos = new Font(Font.FontFamily.HELVETICA, 6.5F, Font.NORMAL);
	private Font font1 = new Font(Font.FontFamily.HELVETICA, 7F, Font.BOLD);
	private Font font2 = new Font(Font.FontFamily.HELVETICA, 6.5F, Font.BOLD);
	private Font font3 = new Font(Font.FontFamily.HELVETICA, 6.5F, Font.NORMAL);
	private Font fontSerieYFolio = new Font(Font.FontFamily.HELVETICA, 8.5F, Font.BOLD);
	private Font fontHead = new Font(Font.FontFamily.HELVETICA, 7.5F, Font.NORMAL);
	// fontHead.setColor(BaseColor.WHITE);
	private BaseColor tikalColor;
	private BaseColor tikalColor2;
	private PdfPCell emptyCell = new PdfPCell();
	// emptyCell.setBorderWidth(0);

	public PDFFactura() {
		fontHead.setColor(new BaseColor(17,55,92));
		emptyCell.setBorderWidth(0);
		tikalColor = new CustomColor(ExtendedColor.TYPE_RGB, 143F / 255F, 135F / 255F, 56F / 255F);
		this.document = new Document();
		this.document.setPageSize(PageSize.A4);
		this.document.setPageSize(PageSize.LETTER.rotate());
		this.document.setMargins(35, 35, 35, 35); // Left Right Top Bottom
	}

	public Document getDocument() {
		return document;
	}

	public MyFooter getPieDePagina() {
		return pieDePagina;
	}

	/**
	 * Construye y regresa un objeto {@code Document} que se convertir&aacute;
	 * la representaci&oacute;n impresa de un CFDI
	 * 
	 * @param comprobante
	 *            el CFDI con los datos con los que se construira el documento
	 * @param selloDigital
	 *            el sello digital del CFDI
	 * @param bytesQRCode
	 *            el arreglo de bytes que se convertir&aacute; en la imagen del
	 *            c&oacute;digo QR que se agregar&aacute; al documento
	 * @return un objeto {@code Document} que se convertir&aacute; la
	 *         representaci&oacute;n impresa de un CFDI
	 * @throws DocumentException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Document construirPdf(Comprobante comprobante, String selloDigital, byte[] bytesQRCode, Estatus estatus, int tipo, Imagen imagen,String dir, String con)
			throws DocumentException, MalformedURLException, IOException {
		TimbreFiscalDigital tfd = null;
		if(tipo==1){
		if (comprobante.getComplemento() != null) {
			List<Object> complemento = comprobante.getComplemento().getAny();

			if (complemento.size() > 0) {
				for (Object object : complemento) {
					if (object instanceof TimbreFiscalDigital) {
						tfd = (TimbreFiscalDigital) object;
					}
				}
			}
		}
		}
		construirBoceto(comprobante, tfd,tipo, estatus, imagen, dir, con);

		// si no hay timbre lanzar una excepción
		/*
		 * if (tfd == null) throw CFDIImpresoException
		 */
		/*
		 * Font fontTituloSellos = new Font(Font.FontFamily.HELVETICA, 7.5F,
		 * Font.BOLD); Font fontContenidoSellos = new
		 * Font(Font.FontFamily.HELVETICA, 7.5F, Font.NORMAL); Font font2 = new
		 * Font(Font.FontFamily.HELVETICA, 8.5F, Font.BOLD); Font font3 = new
		 * Font(Font.FontFamily.HELVETICA, 8.5F, Font.NORMAL); Font
		 * fontSerieYFolio = new Font(Font.FontFamily.HELVETICA, 9.5F,
		 * Font.BOLD); Font fontHead = new Font(Font.FontFamily.HELVETICA, 8.5F,
		 * Font.NORMAL); fontHead.setColor(BaseColor.WHITE);
		 * 
		 * PdfPCell emptyCell = new PdfPCell(); emptyCell.setBorderWidth(0);
		 * 
		 * // BaseColor gris = new BaseColor(153, 153, 102); // BaseColor
		 * otroGris = new BaseColor(235, 235, 224);
		 * 
		 * PdfPTable tablaEncabezado = new PdfPTable(3);
		 * tablaEncabezado.setWidthPercentage(100);
		 * tablaEncabezado.setWidths(new float[] { 30, 40, 30 });
		 * 
		 * // ENCABEZADO DEL COMPROBANTE PdfPTable subTablaLogo = new
		 * PdfPTable(1); PdfPCell celdaLogo = new PdfPCell();
		 * celdaLogo.setBorder(PdfPCell.NO_BORDER); if (imagen != null) { Image
		 * imgLogo = Image.getInstance(new URL(imagen.getImage()));
		 * 
		 * Chunk chunkLogo = new Chunk(imgLogo, 0, -35);
		 * celdaLogo.addElement(chunkLogo); } subTablaLogo.addCell(celdaLogo);
		 * PdfPCell celdaTablaLogo = new PdfPCell();
		 * celdaTablaLogo.addElement(subTablaLogo);
		 * celdaTablaLogo.disableBorderSide(PdfPCell.RIGHT);
		 * celdaTablaLogo.setBorderColor(BaseColor.GRAY);
		 * tablaEncabezado.addCell(celdaTablaLogo);
		 * 
		 * PdfPCell celdaDatosEmisor = new PdfPCell();
		 * celdaDatosEmisor.setHorizontalAlignment(Element.ALIGN_CENTER); Phrase
		 * fraseDatosEmisor = new Phrase(); Chunk chunkNombreEmisor = new
		 * Chunk(comprobante.getEmisor().getNombre(), font2); Chunk
		 * chunkRFCEmisor = new
		 * Chunk("R.F.C. ".concat(comprobante.getEmisor().getRfc()), font3);
		 * Chunk chunkDomicilioEmisor = new
		 * Chunk(comprobante.getEmisor().getDomicilioFiscal().toString(),
		 * font3); fraseDatosEmisor.add(chunkNombreEmisor);
		 * fraseDatosEmisor.add(Chunk.NEWLINE);
		 * fraseDatosEmisor.add(chunkRFCEmisor);
		 * fraseDatosEmisor.add(Chunk.NEWLINE);
		 * fraseDatosEmisor.add(chunkDomicilioEmisor);
		 * celdaDatosEmisor.setBorderWidth(1);
		 * celdaDatosEmisor.disableBorderSide(PdfPCell.LEFT);
		 * celdaDatosEmisor.addElement(fraseDatosEmisor);
		 * 
		 * celdaDatosEmisor.setBorderColor(BaseColor.GRAY);
		 * tablaEncabezado.addCell(celdaDatosEmisor);
		 * 
		 * PdfPCell celdaSubTablaEncabezado = new PdfPCell();
		 * celdaSubTablaEncabezado.setBorderWidth(1); PdfPTable
		 * subTablaEncabezado = new PdfPTable(1);
		 * agregarCeldaSinBorde("FACTURA", fontSerieYFolio, subTablaEncabezado,
		 * true); agregarCeldaSinBorde(getFolioYSerie(comprobante),
		 * fontSerieYFolio, subTablaEncabezado, true);
		 * celdaSubTablaEncabezado.addElement(subTablaEncabezado);
		 * celdaSubTablaEncabezado.setBorderColor(BaseColor.GRAY);
		 * tablaEncabezado.addCell(celdaSubTablaEncabezado);
		 * document.add(tablaEncabezado);
		 * 
		 * // INFORMACIÒN DEL RECEPTOR, LUGAR Y FECHA DE EMISIÓN / HORA DE //
		 * CERTIFICACIÓN PdfPTable tablaReceptorYHoraCert = new PdfPTable(3);
		 * tablaReceptorYHoraCert.setWidthPercentage(100);
		 * tablaReceptorYHoraCert.setWidths(new float[] { 40, 15, 45 });
		 * 
		 * agregarCeldaConFondo("Nombre o razón social", fontHead,
		 * tablaReceptorYHoraCert, false); agregarCeldaConFondo("R.F.C.",
		 * fontHead, tablaReceptorYHoraCert, false);
		 * agregarCeldaConFondo("Lugar y fecha de emisión / hora de certificación"
		 * , fontHead, tablaReceptorYHoraCert, false);
		 * 
		 * agregarCelda(comprobante.getReceptor().getNombre(), font3,
		 * tablaReceptorYHoraCert, false);
		 * agregarCelda(comprobante.getReceptor().getRfc(), font3,
		 * tablaReceptorYHoraCert, false); String lugarFechaEmiHoraCert =
		 * comprobante.getLugarExpedicion().concat(" a ")
		 * .concat(comprobante.getFecha().toString().concat(" / ").concat(tfd.
		 * getFechaTimbrado().toString())); agregarCelda(lugarFechaEmiHoraCert,
		 * font3, tablaReceptorYHoraCert, false);
		 * 
		 * document.add(tablaReceptorYHoraCert);
		 * 
		 * // DIRECCIÓN Y OTROS DATOS FISCALES PdfPTable tablaDirYOtrosDatosFis
		 * = new PdfPTable(2); tablaDirYOtrosDatosFis.setWidthPercentage(100);
		 * tablaDirYOtrosDatosFis.setWidths(new float[] { 40, 60 });
		 * 
		 * agregarCeldaConFondo("Dirección", fontHead, tablaDirYOtrosDatosFis,
		 * false); agregarCeldaConFondo("Otros datos fiscales", fontHead,
		 * tablaDirYOtrosDatosFis, false);
		 * 
		 * agregarCelda(comprobante.getReceptor().getDomicilio().toString(),
		 * font3, tablaDirYOtrosDatosFis, false);
		 * 
		 * Phrase fraseDatosFiscales = new Phrase();
		 * agregarChunkYNuevaLinea("Folio fiscal: ".concat(tfd.getUUID()),
		 * font3, fraseDatosFiscales);
		 * agregarChunkYNuevaLinea("Serie del certificado de emisor: ".concat(
		 * comprobante.getNoCertificado()), font3, fraseDatosFiscales);
		 * agregarChunkYNuevaLinea("Serie del certificado del SAT: ".concat(tfd.
		 * getNoCertificadoSAT()), font3, fraseDatosFiscales);
		 * agregarChunkYNuevaLinea(
		 * "Régimen fiscal: ".concat(comprobante.getEmisor().getRegimenFiscal().
		 * get(0).getRegimen()), font3, fraseDatosFiscales);
		 * 
		 * PdfPCell celdaDatosFiscales = new PdfPCell();
		 * celdaDatosFiscales.setMinimumHeight(45);
		 * celdaDatosFiscales.setPhrase(fraseDatosFiscales);
		 * celdaDatosFiscales.setBorderColor(BaseColor.GRAY);
		 * tablaDirYOtrosDatosFis.addCell(celdaDatosFiscales);
		 * document.add(tablaDirYOtrosDatosFis);
		 * 
		 * // TABLA CONCEPTOS PdfPTable tablaConceptos = new PdfPTable(6);
		 * tablaConceptos.setWidthPercentage(100); tablaConceptos.setWidths(new
		 * float[] { 10, 10, 10, 40, 15, 15 });
		 * 
		 * agregarCeldaConFondo("Clave", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Cantidad", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Unidad", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Descripción", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Valor unitario", fontHead, tablaConceptos,
		 * true);
		 * 
		 * agregarCeldaConFondo("Importe", fontHead, tablaConceptos, true);
		 * 
		 * List<Concepto> listaConceptos =
		 * comprobante.getConceptos().getConcepto(); for (Concepto concepto :
		 * listaConceptos) { agregarCelda(concepto.getNoIdentificacion(), font3,
		 * tablaConceptos, true);
		 * agregarCelda(concepto.getCantidad().toString(), font3,
		 * tablaConceptos, true); agregarCelda(concepto.getUnidad(), font3,
		 * tablaConceptos, true); agregarCelda(concepto.getDescripcion(), font3,
		 * tablaConceptos, false);
		 * agregarCelda(formatter.format(concepto.getValorUnitario().doubleValue
		 * ()), font3, tablaConceptos, true);
		 * agregarCelda(formatter.format(concepto.getImporte().doubleValue()),
		 * font3, tablaConceptos, true); }
		 * 
		 * tablaConceptos.setSpacingBefore(5);
		 * tablaConceptos.setSpacingAfter(5); document.add(tablaConceptos);
		 * 
		 * // IMPORTE CON LETRA PdfPTable tablaImporteConLetra = new
		 * PdfPTable(3); tablaImporteConLetra.setWidthPercentage(100);
		 * tablaImporteConLetra.setWidths(new int[] { 20, 65, 15 });
		 * agregarCeldaConFondo("Importe con letra ", fontHead,
		 * tablaImporteConLetra, true);
		 * 
		 * double importeTotal = Math.round(comprobante.getTotal().doubleValue()
		 * * 100.0) / 100.0; String importeConLetra =
		 * NumberToLetterConverter.convertNumberToLetter(importeTotal); Chunk
		 * chunkImporteConLetra = new Chunk(importeConLetra, font3); Phrase
		 * fraseImporteConLetra = new Phrase(chunkImporteConLetra); PdfPCell
		 * celdaImporteConLetra = new PdfPCell(); //
		 * celdaImporteConLetra.setVerticalAlignment(Element.ALIGN_CENTER);
		 * celdaImporteConLetra.setBorder(PdfPCell.NO_BORDER);
		 * celdaImporteConLetra.setPhrase(fraseImporteConLetra);
		 * tablaImporteConLetra.addCell(celdaImporteConLetra);
		 * 
		 * emptyCell.setBackgroundColor(BaseColor.GRAY);
		 * tablaImporteConLetra.addCell(emptyCell);
		 * document.add(tablaImporteConLetra);
		 * 
		 * // LEYENDA Y, SUBTOTAL, IVA Y TOTAL PdfPTable tablaLeyendaTotal = new
		 * PdfPTable(3); tablaLeyendaTotal.setWidthPercentage(100);
		 * tablaLeyendaTotal.setWidths(new float[] { 65, 20, 15 });
		 * 
		 * Phrase fraseLeyenda = new Phrase(); //
		 * fraseLeyenda.add(Chunk.NEWLINE); Chunk chunkLeyenda = new
		 * Chunk("Este documento es una representación impresa de un CFDI",
		 * fontTituloSellos); fraseLeyenda.add(Chunk.NEWLINE);
		 * fraseLeyenda.add(chunkLeyenda);
		 * 
		 * fraseLeyenda.add(Chunk.NEWLINE); String strMetodoPago =
		 * "Método de pago: ".concat(comprobante.getMetodoDePago())
		 * .concat("                 Moneda: ").concat(comprobante.getMoneda());
		 * Chunk chunkMetodoDePago = new Chunk(strMetodoPago,
		 * fontContenidoSellos); fraseLeyenda.add(chunkMetodoDePago);
		 * 
		 * // se agrega la leyenda 'Efectos fiscales al pago' String
		 * strFormaDePago =
		 * "Forma de pago: ".concat(comprobante.getFormaDePago())
		 * .concat("                 Efectos fiscales al pago");
		 * fraseLeyenda.add(Chunk.NEWLINE); Chunk chunkFormaDePago = new
		 * Chunk(strFormaDePago, fontContenidoSellos);
		 * fraseLeyenda.add(chunkFormaDePago); fraseLeyenda.add(Chunk.NEWLINE);
		 * 
		 * PdfPCell celdaLeyenda = new PdfPCell(fraseLeyenda);
		 * celdaLeyenda.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * tablaLeyendaTotal.addCell(celdaLeyenda);
		 * 
		 * PdfPTable subTablaEtqTotal = new PdfPTable(1);
		 * agregarCeldaConFondo("Subtotal", fontHead, subTablaEtqTotal, true);
		 * 
		 * List<Traslado> traslados =
		 * comprobante.getImpuestos().getTraslados().getTraslado(); boolean
		 * existeIVATraslado = false; double importe = 0.0; if (traslados.size()
		 * > 0) { if (traslados.get(0).getImpuesto().equals(IVA)) {
		 * existeIVATraslado = true; importe =
		 * traslados.get(0).getImporte().doubleValue();
		 * agregarCeldaConFondo("IVA 16%", fontHead, subTablaEtqTotal, true); }
		 * } else { subTablaEtqTotal.addCell(emptyCell); }
		 * 
		 * agregarCeldaConFondo("Total", fontHead, subTablaEtqTotal, true);
		 * PdfPCell celdaTablaEtqTotal = new PdfPCell(subTablaEtqTotal);
		 * celdaTablaEtqTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * tablaLeyendaTotal.addCell(celdaTablaEtqTotal);
		 * 
		 * PdfPTable subTablaValoresTotal = new PdfPTable(1);
		 * agregarCelda(formatter.format(comprobante.getSubTotal().doubleValue()
		 * ), font3, subTablaValoresTotal, true);
		 * 
		 * if (existeIVATraslado) agregarCelda(formatter.format(importe), font3,
		 * subTablaValoresTotal, true); else
		 * subTablaValoresTotal.addCell(emptyCell);
		 * 
		 * agregarCelda(formatter.format(comprobante.getTotal().doubleValue()),
		 * font3, subTablaValoresTotal, true); PdfPCell celdaTablaValoresTotal =
		 * new PdfPCell(subTablaValoresTotal);
		 * celdaTablaValoresTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * tablaLeyendaTotal.addCell(celdaTablaValoresTotal);
		 * 
		 * document.add(tablaLeyendaTotal);
		 */

		construirTimbre(selloDigital, bytesQRCode, tfd);
		// QRCode Y SELLOS DIGITALES
		/*
		 * PdfPTable mainTable = new PdfPTable(2);
		 * mainTable.setWidthPercentage(100.0f); mainTable.setWidths(new float[]
		 * { 25, 75 });
		 * 
		 * PdfPCell primeraCeldaTabla = new PdfPCell();
		 * primeraCeldaTabla.setBorderWidthTop(1);
		 * primeraCeldaTabla.setBorderWidthBottom(1);
		 * primeraCeldaTabla.setBorderWidthRight(1);
		 * 
		 * PdfPTable tablaQRCode = new PdfPTable(1); Image imgQRCode =
		 * Image.getInstance(bytesQRCode); // int dpi = imgQRCode.getDpiX(); //
		 * imgQRCode.scalePercent(100 * 72 / dpi - 20); // el tercer parámetro
		 * en el constructor de Chunk (offsetY) controla el // tamaño de la
		 * imagen Chunk chunkQRCode = new Chunk(imgQRCode, 0, -70); PdfPCell
		 * celdaQRCode = new PdfPCell();
		 * celdaQRCode.setBorder(PdfPCell.NO_BORDER);
		 * celdaQRCode.addElement(chunkQRCode);
		 * tablaQRCode.addCell(celdaQRCode);
		 * primeraCeldaTabla.addElement(tablaQRCode);
		 * mainTable.addCell(primeraCeldaTabla);
		 * 
		 * PdfPCell segundaCeldaTabla = new PdfPCell();
		 * segundaCeldaTabla.setBorderWidthTop(1);
		 * segundaCeldaTabla.setBorderWidthBottom(1);
		 * segundaCeldaTabla.setBorderWidthRight(1);
		 * segundaCeldaTabla.setBorderColor(BaseColor.GRAY);
		 * 
		 * PdfPTable tablaTimbre = new PdfPTable(1);
		 * tablaTimbre.setWidthPercentage(100);
		 * 
		 * // celdaQRCode = new PdfPCell(Image.getInstance(bytesQRCode)); //
		 * celdaQRCode.setBorderWidth(0);
		 * 
		 * PdfPCell cell1table7 = new PdfPCell(); cell1table7.setBorderWidth(0);
		 * 
		 * Phrase line3footer = new Phrase(); Chunk line3part1 = new
		 * Chunk("Sello digital del emisor ", fontTituloSellos); Chunk
		 * line3part2 = new Chunk(tfd.getSelloCFD(), fontContenidoSellos);
		 * line3footer.add(line3part1); line3footer.add(Chunk.NEWLINE);
		 * line3footer.add(line3part2);
		 * 
		 * PdfPCell cell4table7 = new PdfPCell(line3footer);
		 * cell4table7.setBorderWidth(0); //
		 * cell4table7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		 * 
		 * Phrase line4footer = new Phrase(); Chunk line4part1 = new
		 * Chunk("Sello digital del SAT ", fontTituloSellos); Chunk line4part2 =
		 * new Chunk(tfd.getSelloSAT(), fontContenidoSellos);
		 * line4footer.add(line4part1); line4footer.add(Chunk.NEWLINE);
		 * line4footer.add(line4part2);
		 * 
		 * PdfPCell cell5table7 = new PdfPCell(line4footer);
		 * cell5table7.setBorderWidth(0); //
		 * cell5table7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		 * 
		 * Phrase fraseCadenaOriginal = new Phrase(); Chunk
		 * chunkCadenaOriginalEtq = new
		 * Chunk("Cadena original del complemento de certificación digital del SAT "
		 * , fontTituloSellos); Chunk chunkCadenaOriginalValor = new
		 * Chunk(selloDigital, fontContenidoSellos);
		 * fraseCadenaOriginal.add(chunkCadenaOriginalEtq);
		 * fraseCadenaOriginal.add(Chunk.NEWLINE);
		 * fraseCadenaOriginal.add(chunkCadenaOriginalValor);
		 * 
		 * PdfPCell celdaCadenaOriginal = new PdfPCell(fraseCadenaOriginal);
		 * celdaCadenaOriginal.setBorderWidth(0);
		 * 
		 * tablaTimbre.addCell(cell4table7);
		 * 
		 * tablaTimbre.addCell(cell5table7);
		 * 
		 * tablaTimbre.addCell(celdaCadenaOriginal);
		 * 
		 * // tablaTimbre.addCell(cell6table7);
		 * 
		 * segundaCeldaTabla.addElement(tablaTimbre);
		 * mainTable.addCell(segundaCeldaTabla); mainTable.setSpacingBefore(2);
		 * 
		 * document.add(mainTable);
		 */
		return document;
	}

	public Document construirPdf(Comprobante comprobante, Estatus estatus, Imagen imagen, String dir, String con) throws DocumentException, MalformedURLException, IOException {

		construirBoceto(comprobante, null,0, estatus, imagen, dir, con);

		/*
		 * Font fontContenidoSellos = new Font(Font.FontFamily.HELVETICA, 7.5F,
		 * Font.NORMAL); Font font2 = new Font(Font.FontFamily.HELVETICA, 8.5F,
		 * Font.BOLD); Font font3 = new Font(Font.FontFamily.HELVETICA, 8.5F,
		 * Font.NORMAL); Font fontSerieYFolio = new
		 * Font(Font.FontFamily.HELVETICA, 9.5F, Font.BOLD); Font fontHead = new
		 * Font(Font.FontFamily.HELVETICA, 8.5F, Font.NORMAL);
		 * fontHead.setColor(BaseColor.WHITE);
		 * 
		 * PdfPCell emptyCell = new PdfPCell(); emptyCell.setBorderWidth(0);
		 * 
		 * // BaseColor gris = new BaseColor(153, 153, 102); // BaseColor
		 * otroGris = new BaseColor(235, 235, 224);
		 * 
		 * PdfPTable tablaEncabezado = new PdfPTable(3);
		 * tablaEncabezado.setWidthPercentage(100);
		 * tablaEncabezado.setWidths(new float[] { 30, 40, 30 });
		 * 
		 * // ENCABEZADO DEL COMPROBANTE PdfPTable subTablaLogo = new
		 * PdfPTable(1); PdfPCell celdaLogo = new PdfPCell();
		 * celdaLogo.setBorder(PdfPCell.NO_BORDER); if (imagen != null) { Image
		 * imgLogo = Image.getInstance(new URL(imagen.getImage()));
		 * 
		 * Chunk chunkLogo = new Chunk(imgLogo, 0, -35);
		 * celdaLogo.addElement(chunkLogo); } subTablaLogo.addCell(celdaLogo);
		 * PdfPCell celdaTablaLogo = new PdfPCell();
		 * celdaTablaLogo.addElement(subTablaLogo);
		 * celdaTablaLogo.disableBorderSide(PdfPCell.RIGHT);
		 * celdaTablaLogo.setBorderColor(BaseColor.GRAY);
		 * tablaEncabezado.addCell(celdaTablaLogo);
		 * 
		 * PdfPCell celdaDatosEmisor = new PdfPCell(); Phrase fraseDatosEmisor =
		 * new Phrase(); Chunk chunkNombreEmisor = new
		 * Chunk(comprobante.getEmisor().getNombre(), font2); Chunk
		 * chunkRFCEmisor = new
		 * Chunk("R.F.C. ".concat(comprobante.getEmisor().getRfc()), font3);
		 * Chunk chunkDomicilioEmisor = new
		 * Chunk(comprobante.getEmisor().getDomicilioFiscal().toString(),
		 * font3); fraseDatosEmisor.add(chunkNombreEmisor);
		 * fraseDatosEmisor.add(Chunk.NEWLINE);
		 * fraseDatosEmisor.add(chunkRFCEmisor);
		 * fraseDatosEmisor.add(Chunk.NEWLINE);
		 * fraseDatosEmisor.add(chunkDomicilioEmisor);
		 * celdaDatosEmisor.setBorderWidth(1);
		 * celdaDatosEmisor.disableBorderSide(PdfPCell.LEFT);
		 * celdaDatosEmisor.addElement(fraseDatosEmisor);
		 * celdaDatosEmisor.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * celdaDatosEmisor.setBorderColor(BaseColor.GRAY);
		 * tablaEncabezado.addCell(celdaDatosEmisor);
		 * 
		 * PdfPCell celdaSubTablaEncabezado = new PdfPCell();
		 * celdaSubTablaEncabezado.setBorderWidth(1); PdfPTable
		 * subTablaEncabezado = new PdfPTable(1);
		 * agregarCeldaSinBorde("FACTURA", fontSerieYFolio, subTablaEncabezado,
		 * true); agregarCeldaSinBorde(getFolioYSerie(comprobante),
		 * fontSerieYFolio, subTablaEncabezado, true);
		 * celdaSubTablaEncabezado.addElement(subTablaEncabezado);
		 * celdaSubTablaEncabezado.setBorderColor(BaseColor.GRAY);
		 * tablaEncabezado.addCell(celdaSubTablaEncabezado);
		 * document.add(tablaEncabezado);
		 * 
		 * // TODO continuar // INFORMACIÒN DEL RECEPTOR, LUGAR Y FECHA DE
		 * EMISIÓN / HORA DE // CERTIFICACIÓN PdfPTable tablaReceptorYHoraCert =
		 * new PdfPTable(3); tablaReceptorYHoraCert.setWidthPercentage(100);
		 * tablaReceptorYHoraCert.setWidths(new float[] { 40, 15, 45 });
		 * 
		 * agregarCeldaConFondo("Nombre o razón social", fontHead,
		 * tablaReceptorYHoraCert, false); agregarCeldaConFondo("R.F.C.",
		 * fontHead, tablaReceptorYHoraCert, false);
		 * agregarCeldaConFondo("Lugar y fecha de emisión / hora de certificación"
		 * , fontHead, tablaReceptorYHoraCert, false);
		 * 
		 * agregarCelda(comprobante.getReceptor().getNombre(), font3,
		 * tablaReceptorYHoraCert, false);
		 * agregarCelda(comprobante.getReceptor().getRfc(), font3,
		 * tablaReceptorYHoraCert, false); String lugarFechaEmiHoraCert =
		 * comprobante.getLugarExpedicion().concat(" a ")
		 * .concat(comprobante.getFecha().toString());
		 * agregarCelda(lugarFechaEmiHoraCert, font3, tablaReceptorYHoraCert,
		 * false);
		 * 
		 * document.add(tablaReceptorYHoraCert);
		 * 
		 * // DIRECCIÓN Y OTROS DATOS FISCALES PdfPTable tablaDirYOtrosDatosFis
		 * += new PdfPTable(2); tablaDirYOtrosDatosFis.setWidthPercentage(100);
		 * tablaDirYOtrosDatosFis.setWidths(new float[] { 40, 60 });
		 * 
		 * agregarCeldaConFondo("Dirección", fontHead, tablaDirYOtrosDatosFis,
		 * false); agregarCeldaConFondo("Otros datos fiscales", fontHead,
		 * tablaDirYOtrosDatosFis, false);
		 * 
		 * agregarCelda(comprobante.getReceptor().getDomicilio().toString(),
		 * font3, tablaDirYOtrosDatosFis, false);
		 * 
		 * Phrase fraseDatosFiscales = new Phrase(); //
		 * agregarChunkYNuevaLinea("Folio fiscal: ".concat(tfd.getUUID()), //
		 * font3, fraseDatosFiscales); // agregarChunkYNuevaLinea("Serie del
		 * certificado de emisor: // ".concat(comprobante.getNoCertificado()),
		 * font3, fraseDatosFiscales); // agregarChunkYNuevaLinea("Serie del
		 * certificado del SAT: // ".concat(tfd.getNoCertificadoSAT()), font3,
		 * fraseDatosFiscales); agregarChunkYNuevaLinea(
		 * "Régimen fiscal: ".concat(comprobante.getEmisor().getRegimenFiscal().
		 * get(0).getRegimen()), font3, fraseDatosFiscales);
		 * 
		 * PdfPCell celdaDatosFiscales = new PdfPCell();
		 * celdaDatosFiscales.setMinimumHeight(45);
		 * celdaDatosFiscales.setPhrase(fraseDatosFiscales);
		 * celdaDatosFiscales.setBorderColor(BaseColor.GRAY);
		 * tablaDirYOtrosDatosFis.addCell(celdaDatosFiscales);
		 * document.add(tablaDirYOtrosDatosFis);
		 * 
		 * // TABLA CONCEPTOS PdfPTable tablaConceptos = new PdfPTable(6);
		 * tablaConceptos.setWidthPercentage(100); tablaConceptos.setWidths(new
		 * float[] { 10, 10, 10, 40, 15, 15 });
		 * 
		 * agregarCeldaConFondo("Clave", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Cantidad", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Unidad", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Descripción", fontHead, tablaConceptos, true);
		 * 
		 * agregarCeldaConFondo("Valor unitario", fontHead, tablaConceptos,
		 * true);
		 * 
		 * agregarCeldaConFondo("Importe", fontHead, tablaConceptos, true);
		 * 
		 * List<Concepto> listaConceptos =
		 * comprobante.getConceptos().getConcepto(); for (Concepto concepto :
		 * listaConceptos) { agregarCelda(concepto.getNoIdentificacion(), font3,
		 * tablaConceptos, true);
		 * agregarCelda(concepto.getCantidad().toString(), font3,
		 * tablaConceptos, true); agregarCelda(concepto.getUnidad(), font3,
		 * tablaConceptos, true); agregarCelda(concepto.getDescripcion(), font3,
		 * tablaConceptos, false);
		 * agregarCelda(formatter.format(concepto.getValorUnitario().doubleValue
		 * ()), font3, tablaConceptos, true);
		 * agregarCelda(formatter.format(concepto.getImporte().doubleValue()),
		 * font3, tablaConceptos, true); }
		 * 
		 * tablaConceptos.setSpacingBefore(5);
		 * tablaConceptos.setSpacingAfter(5); document.add(tablaConceptos);
		 * 
		 * // IMPORTE CON LETRA PdfPTable tablaImporteConLetra = new
		 * PdfPTable(3); tablaImporteConLetra.setWidthPercentage(100);
		 * tablaImporteConLetra.setWidths(new int[] { 20, 65, 15 });
		 * agregarCeldaConFondo("Importe con letra ", fontHead,
		 * tablaImporteConLetra, true);
		 * 
		 * double importeTotal = Math.round(comprobante.getTotal().doubleValue()
		 * * 100.0) / 100.0; String importeConLetra =
		 * NumberToLetterConverter.convertNumberToLetter(importeTotal); Chunk
		 * chunkImporteConLetra = new Chunk(importeConLetra, font3); Phrase
		 * fraseImporteConLetra = new Phrase(chunkImporteConLetra); PdfPCell
		 * celdaImporteConLetra = new PdfPCell(); //
		 * celdaImporteConLetra.setVerticalAlignment(Element.ALIGN_CENTER);
		 * celdaImporteConLetra.setBorder(PdfPCell.NO_BORDER);
		 * celdaImporteConLetra.setPhrase(fraseImporteConLetra);
		 * tablaImporteConLetra.addCell(celdaImporteConLetra);
		 * 
		 * emptyCell.setBackgroundColor(BaseColor.GRAY);
		 * tablaImporteConLetra.addCell(emptyCell);
		 * document.add(tablaImporteConLetra);
		 * 
		 * // LEYENDA Y, SUBTOTAL, IVA Y TOTAL PdfPTable tablaLeyendaTotal = new
		 * PdfPTable(3); tablaLeyendaTotal.setWidthPercentage(100);
		 * tablaLeyendaTotal.setWidths(new float[] { 65, 20, 15 });
		 * 
		 * Phrase fraseLeyenda = new Phrase(); //
		 * fraseLeyenda.add(Chunk.NEWLINE);
		 * 
		 * fraseLeyenda.add(Chunk.NEWLINE); String strMetodoPago =
		 * "Método de pago: ".concat(comprobante.getMetodoDePago())
		 * .concat("                 Moneda: ").concat(comprobante.getMoneda());
		 * Chunk chunkMetodoDePago = new Chunk(strMetodoPago,
		 * fontContenidoSellos); fraseLeyenda.add(chunkMetodoDePago);
		 * 
		 * // se agrega la leyenda 'Efectos fiscales al pago' String
		 * strFormaDePago =
		 * "Forma de pago: ".concat(comprobante.getFormaDePago())
		 * .concat("                 Efectos fiscales al pago");
		 * fraseLeyenda.add(Chunk.NEWLINE); Chunk chunkFormaDePago = new
		 * Chunk(strFormaDePago, fontContenidoSellos);
		 * fraseLeyenda.add(chunkFormaDePago); fraseLeyenda.add(Chunk.NEWLINE);
		 * 
		 * PdfPCell celdaLeyenda = new PdfPCell(fraseLeyenda);
		 * celdaLeyenda.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * tablaLeyendaTotal.addCell(celdaLeyenda);
		 * 
		 * PdfPTable subTablaEtqTotal = new PdfPTable(1);
		 * agregarCeldaConFondo("Subtotal", fontHead, subTablaEtqTotal, true);
		 * 
		 * List<Traslado> traslados =
		 * comprobante.getImpuestos().getTraslados().getTraslado(); boolean
		 * existeIVATraslado = false; double importe = 0.0; if (traslados.size()
		 * > 0) { if (traslados.get(0).getImpuesto().equals(IVA)) {
		 * existeIVATraslado = true; importe =
		 * traslados.get(0).getImporte().doubleValue();
		 * agregarCeldaConFondo("IVA 16%", fontHead, subTablaEtqTotal, true); }
		 * } else { subTablaEtqTotal.addCell(emptyCell); }
		 * 
		 * agregarCeldaConFondo("Total", fontHead, subTablaEtqTotal, true);
		 * PdfPCell celdaTablaEtqTotal = new PdfPCell(subTablaEtqTotal);
		 * celdaTablaEtqTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * tablaLeyendaTotal.addCell(celdaTablaEtqTotal);
		 * 
		 * PdfPTable subTablaValoresTotal = new PdfPTable(1);
		 * agregarCelda(formatter.format(comprobante.getSubTotal().doubleValue()
		 * ), font3, subTablaValoresTotal, true);
		 * 
		 * if (existeIVATraslado) agregarCelda(formatter.format(importe), font3,
		 * subTablaValoresTotal, true); else
		 * subTablaValoresTotal.addCell(emptyCell);
		 * 
		 * agregarCelda(formatter.format(comprobante.getTotal().doubleValue()),
		 * font3, subTablaValoresTotal, true); PdfPCell celdaTablaValoresTotal =
		 * new PdfPCell(subTablaValoresTotal);
		 * celdaTablaValoresTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * tablaLeyendaTotal.addCell(celdaTablaValoresTotal);
		 * 
		 * document.add(tablaLeyendaTotal);
		 */

		/*
		 * //QRCode Y SELLOS DIGITALES PdfPTable mainTable = new PdfPTable(2);
		 * mainTable.setWidthPercentage(100.0f); mainTable.setWidths(new
		 * float[]{25,75});
		 * 
		 * PdfPCell primeraCeldaTabla = new PdfPCell();
		 * primeraCeldaTabla.setBorderWidthTop(1);
		 * primeraCeldaTabla.setBorderWidthBottom(1);
		 * primeraCeldaTabla.setBorderWidthRight(1);
		 * 
		 * PdfPTable tablaQRCode = new PdfPTable(1); Image imgQRCode =
		 * Image.getInstance(bytesQRCode); //int dpi = imgQRCode.getDpiX();
		 * //imgQRCode.scalePercent(100 * 72 / dpi - 20); // el tercer parámetro
		 * en el constructor de Chunk (offsetY) controla el tamaño de la imagen
		 * Chunk chunkQRCode = new Chunk(imgQRCode, 0, -70); PdfPCell
		 * celdaQRCode = new PdfPCell();
		 * celdaQRCode.setBorder(PdfPCell.NO_BORDER);
		 * celdaQRCode.addElement(chunkQRCode);
		 * tablaQRCode.addCell(celdaQRCode);
		 * primeraCeldaTabla.addElement(tablaQRCode);
		 * mainTable.addCell(primeraCeldaTabla);
		 * 
		 * PdfPCell segundaCeldaTabla = new PdfPCell();
		 * segundaCeldaTabla.setBorderWidthTop(1);
		 * segundaCeldaTabla.setBorderWidthBottom(1);
		 * segundaCeldaTabla.setBorderWidthRight(1);
		 * segundaCeldaTabla.setBorderColor(BaseColor.GRAY);
		 * 
		 * PdfPTable tablaTimbre = new PdfPTable(1);
		 * tablaTimbre.setWidthPercentage(100);
		 * 
		 * // celdaQRCode = new PdfPCell(Image.getInstance(bytesQRCode)); //
		 * celdaQRCode.setBorderWidth(0);
		 * 
		 * PdfPCell cell1table7 = new PdfPCell(); cell1table7.setBorderWidth(0);
		 * 
		 * Phrase line3footer = new Phrase(); Chunk line3part1 = new
		 * Chunk("Sello digital del emisor ", fontTituloSellos); Chunk
		 * line3part2 = new Chunk(tfd.getSelloCFD(), fontContenidoSellos);
		 * line3footer.add(line3part1); line3footer.add(Chunk.NEWLINE);
		 * line3footer.add(line3part2);
		 * 
		 * PdfPCell cell4table7 = new PdfPCell(line3footer);
		 * cell4table7.setBorderWidth(0);
		 * //cell4table7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		 * 
		 * Phrase line4footer = new Phrase(); Chunk line4part1 = new
		 * Chunk("Sello digital del SAT ", fontTituloSellos); Chunk line4part2 =
		 * new Chunk(tfd.getSelloSAT(), fontContenidoSellos);
		 * line4footer.add(line4part1); line4footer.add(Chunk.NEWLINE);
		 * line4footer.add(line4part2);
		 * 
		 * PdfPCell cell5table7 = new PdfPCell(line4footer);
		 * cell5table7.setBorderWidth(0);
		 * //cell5table7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		 * 
		 * Phrase fraseCadenaOriginal = new Phrase(); Chunk
		 * chunkCadenaOriginalEtq = new
		 * Chunk("Cadena original del complemento de certificaciòn digital del SAT "
		 * , fontTituloSellos); Chunk chunkCadenaOriginalValor = new
		 * Chunk(selloDigital, fontContenidoSellos);
		 * fraseCadenaOriginal.add(chunkCadenaOriginalEtq);
		 * fraseCadenaOriginal.add(Chunk.NEWLINE);
		 * fraseCadenaOriginal.add(chunkCadenaOriginalValor);
		 * 
		 * PdfPCell celdaCadenaOriginal = new PdfPCell(fraseCadenaOriginal);
		 * celdaCadenaOriginal.setBorderWidth(0);
		 * 
		 * tablaTimbre.addCell(cell4table7);
		 * 
		 * tablaTimbre.addCell(cell5table7);
		 * 
		 * tablaTimbre.addCell(celdaCadenaOriginal);
		 * 
		 * //tablaTimbre.addCell(cell6table7);
		 * 
		 * segundaCeldaTabla.addElement(tablaTimbre);
		 * mainTable.addCell(segundaCeldaTabla); mainTable.setSpacingBefore(2);
		 * 
		 * 
		 * document.add(mainTable);
		 */

		return document;
	}

	public Document construirPdfNota(Venta v) throws MalformedURLException, DocumentException, IOException {

		// Comprobante c=
		return document;
	}

	public Document construirPdfCancelado(Comprobante comprobante, String selloDigital, byte[] bytesQRCode,
			String selloCancelacion, Date fechaCancelacion,Imagen imagen, String dir, String con)
			throws MalformedURLException, DocumentException, IOException {
		// this.document = construirPdf(comprobante, selloDigital, bytesQRCode,
		// imagen, estatus);
		List<Object> complemento = comprobante.getComplemento().getAny();
		TimbreFiscalDigital tfd = null;
		if (complemento.size() > 0) {
			for (Object object : complemento) {
				if (object instanceof TimbreFiscalDigital) {
					tfd = (TimbreFiscalDigital) object;
				}
			}
		}

		construirBoceto(comprobante, tfd,0, Estatus.CANCELADO, imagen, dir, con);
		construirTimbre(selloDigital, bytesQRCode, tfd);

		/*
		 * PdfPTable tablaSelloCancelacion = new PdfPTable(1);
		 * 
		 * Phrase fraseSelloCancelacion = new Phrase(); Chunk
		 * chunkEtqSelloCancel = new Chunk("Sello digital SAT (Cancelación): ",
		 * fontTituloSellos); Chunk chunkSelloCancel = new
		 * Chunk(selloCancelacion, fontContenidoSellos);
		 * fraseSelloCancelacion.add(chunkEtqSelloCancel);
		 * fraseSelloCancelacion.add(chunkSelloCancel);
		 * 
		 * PdfPCell celdaSelloCancelacion = new PdfPCell(fraseSelloCancelacion);
		 * celdaSelloCancelacion.setBorder(PdfPCell.NO_BORDER);
		 * tablaSelloCancelacion.addCell(celdaSelloCancelacion);
		 * tablaSelloCancelacion.setSpacingBefore(5);
		 * document.add(tablaSelloCancelacion);
		 */

		return document;
	}

	private void agregarCelda(String contenidoCelda, Font fuente, PdfPTable tabla, boolean centrado) {
		PdfPCell celda = new PdfPCell(new Paragraph(contenidoCelda, fuente));
		celda.setBorderWidth(1);
		celda.setBorderColor(BaseColor.GRAY);
		celda.setPadding(5);

		if (centrado)
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tabla.addCell(celda);
	}

	private void agregarCeldaConFondo(String contenidoCelda, Font fuente, PdfPTable tabla, boolean centrado) {
		PdfPCell celda = new PdfPCell(new Paragraph(contenidoCelda, fuente));
		celda.setBorderWidth(1);
		celda.setBorderColor(new BaseColor(246,123,29));
		celda.setPadding(5);
		celda.setBackgroundColor(new BaseColor(246,123,29));

		if (centrado)
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tabla.addCell(celda);
	}

	private void agregarCeldaSinBorde(String contenidoCelda, Font fuente, PdfPTable tabla, boolean centrado) {
		PdfPCell celda = new PdfPCell(new Paragraph(contenidoCelda, fuente));
		celda.setBorder(PdfPCell.NO_BORDER);
		celda.setBorderColor(BaseColor.GRAY);
		celda.setPadding(5);

		if (centrado)
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tabla.addCell(celda);
	}

	private void agregarChunkYNuevaLinea(String contenido, Font fuente, Phrase frase) {
		Chunk chunk = new Chunk(contenido, fuente);
		frase.add(chunk);
		frase.add(Chunk.NEWLINE);
	}

	private List<Traslado> obtenerTraslados(Comprobante c) {
		if (c.getImpuestos() != null) {
			if (c.getImpuestos().getTraslados() != null) {
				List<Traslado> traslados = c.getImpuestos().getTraslados().getTraslado();
				if (traslados.size() > 0)
					return traslados;
				else
					return null;
			} else
				return null;
		} else
			return null;
	}

	private List<Retencion> obtenerRetenciones(Comprobante c) {
		if (c.getImpuestos() != null) {
			if (c.getImpuestos().getRetenciones() != null) {
				List<Retencion> retenciones = c.getImpuestos().getRetenciones().getRetencion();
				if (retenciones.size() > 0)
					return retenciones;
				else
					return null;
			} else
				return null;
		} else
			return null;
	}

	private void agregarDetalleImpuestosTraslados(List<Traslado> impTraslados, PdfPTable tabla, Font font) {
		if (impTraslados != null) {
			double importeIVA = 0.0;
			double tasaIVA = 0.0;

			for (Traslado traslado : impTraslados) {
				if (traslado.getImpuesto().equals(IVA)) {
					if (traslado.getTasa().doubleValue() > 0)
						tasaIVA = traslado.getTasa().doubleValue();
					importeIVA += traslado.getImporte().doubleValue();
				} else if (traslado.getImpuesto().equals(IEPS)) {
					agregarCelda(IEPS.concat("  ").concat(Double.toString(traslado.getTasa().doubleValue())), font,
							tabla, false);
					agregarCelda(formatter.format(traslado.getImporte().doubleValue()), font, tabla, false);
				}
			}
			if (importeIVA > 0.0) {
				agregarCelda(IVA.concat("  ").concat(String.valueOf(tasaIVA)), font, tabla, false);
				agregarCelda(formatter.format(importeIVA), font, tabla, false); // se
																				// quitaron
																				// dos
																				// espacios
																				// en
																				// blanco
																				// al
																				// inicio
																				// de
																				// la
																				// cadena
			}
		}
	}

	private void agregarDetalleImpuestosRetenciones(List<Retencion> impRetenidos, PdfPTable tabla, Font font) {
		if (impRetenidos != null) {

			for (Retencion retencion : impRetenidos) {
				if (retencion.getImpuesto().equals(IVA)) {
					agregarCelda(IVA.concat("  "), font, tabla, false);
					agregarCelda(formatter.format(retencion.getImporte().doubleValue()), font, tabla, false);
				} else if (retencion.getImpuesto().equals(ISR)) {
					agregarCelda(ISR.concat("  "), font, tabla, false);
					agregarCelda(formatter.format(retencion.getImporte().doubleValue()), font, tabla, false);
				}
			}

		}
	}

	private String getFolioYSerie(Comprobante c) {
		String folio = c.getFolio();
		String serie = c.getSerie();
		StringBuilder folioYSerie = new StringBuilder();
		if (serie != null)
			folioYSerie.append(serie);
		if (folio != null)
			folioYSerie.append(folio);

		return folioYSerie.toString();
	}

	public void crearMarcaDeAgua(String contenido, PdfWriter writer) {
		PdfContentByte fondo = writer.getDirectContent();
		Font fuente = new Font(FontFamily.HELVETICA, 45);
		Phrase frase = new Phrase(contenido, fuente);
		fondo.saveState();
		PdfGState gs1 = new PdfGState();
		gs1.setFillOpacity(0.5f);
		fondo.setGState(gs1);
		ColumnText.showTextAligned(fondo, Element.ALIGN_CENTER, frase, 297, 650, 45);
		fondo.restoreState();
	}
	
	public void crearNotaDoble(PdfPTable tablaPrincipal, boolean borde,float col1, float col2, float col3, PdfPTable tablaColumna) throws DocumentException{
		tablaPrincipal.setWidthPercentage(100);
		tablaPrincipal.setWidths(new float[]{col1,col2,col3});
		PdfPCell celdaPrincipal = new PdfPCell();
		if (borde == true){
			celdaPrincipal.setBorderColor(BaseColor.GRAY);
			celdaPrincipal.setBorderWidth(1);
		}else{
			celdaPrincipal.setBorder(PdfPCell.NO_BORDER);
		}
		
		celdaPrincipal.addElement(tablaColumna);
		tablaPrincipal.addCell(celdaPrincipal);
		emptyCell.setBackgroundColor(BaseColor.WHITE);
		tablaPrincipal.addCell(emptyCell);
		tablaPrincipal.addCell(celdaPrincipal);
		
	}

	private void construirBoceto(Comprobante comprobante, TimbreFiscalDigital tfd,int encabezado, Estatus estatus, Imagen imagen, String dir, String con)
			throws DocumentException, MalformedURLException, IOException {

		// Encabezado
		PdfPTable tablaEncabezado = new PdfPTable(3);
		tablaEncabezado.setWidthPercentage(100);
		tablaEncabezado.setWidths(new float[] { 35, 35,30 });
		PdfPCell celdaTablaLogo = new PdfPCell();
		PdfPCell celdaFechaHora = new PdfPCell();
		
		// celda Logo y fecha del encabezado
		PdfPTable subTablaLogo = new PdfPTable(1);
		PdfPCell celdaLogo = new PdfPCell();
		celdaLogo.setBorder(PdfPCell.NO_BORDER);
		
		Image imgLogo = Image.getInstance("WEB-INF/Images/sanLucas.jpg");
		 Chunk chunkLogo = new Chunk(imgLogo, 0, -35);
		 celdaLogo.addElement(chunkLogo);

		subTablaLogo.addCell(celdaLogo);
		celdaTablaLogo.addElement(subTablaLogo);
		celdaTablaLogo.disableBorderSide(PdfPCell.RIGHT);
		celdaTablaLogo.setBorder(PdfPCell.NO_BORDER);
		tablaEncabezado.addCell(celdaTablaLogo);
		
		
		
		PdfPTable subTabla22 = new PdfPTable(1);
		//PdfPCell celda22 = new PdfPCell();
		//celdaLogo.setBorder(PdfPCell.NO_BORDER);
		//celda datos y no. de nota del encabezado
		PdfPCell celdaDatosEmisor = new PdfPCell();
		celdaDatosEmisor.setBorder(PdfPCell.NO_BORDER);
		Phrase fraseDatosEmisor = new Phrase();
		font1.setColor(BaseColor.BLACK);
		String dom = "";
		if (comprobante.getEmisor().getDomicilioFiscal() != null) {
			dom = comprobante.getEmisor().getDomicilioFiscal().toString();
		}

	////	 agregarChunkYNuevaLinea("", font1, fraseDatosEmisor);
		 agregarChunkYNuevaLinea("", font1, fraseDatosEmisor);
		 agregarChunkYNuevaLinea("Sanatorio México", font2, fraseDatosEmisor);
	//	 agregarChunkYNuevaLinea("R.F.C. ".concat(comprobante.getEmisor().getRfc()),font3, fraseDatosEmisor);
	//	 agregarChunkYNuevaLinea(dom, font3, fraseDatosEmisor);
		 agregarChunkYNuevaLinea("Tel: (722) 271 0404", font3, fraseDatosEmisor);
		 agregarChunkYNuevaLinea("AV. MEXICO #800, COL AMERICAS,TOLUCA, MÉXICO, 52170", font3, fraseDatosEmisor);
		 agregarChunkYNuevaLinea("sanamex@gmail.com", font3, fraseDatosEmisor);
		
		 celdaDatosEmisor.setMinimumHeight(45);
		 celdaDatosEmisor.setPhrase(fraseDatosEmisor);
		celdaDatosEmisor.setHorizontalAlignment(Element.ALIGN_CENTER);
		subTabla22.addCell(celdaDatosEmisor);
		celdaTablaLogo.addElement(subTabla22);
		tablaEncabezado.addCell(celdaDatosEmisor);

		PdfPTable subTablaFecha = new PdfPTable(1);
		PdfPCell celdaSubTablaFecha = new PdfPCell();
		celdaSubTablaFecha.setBorder(PdfPCell.NO_BORDER);
		String lugarFechaEmiHoraCert = "";
		if(encabezado==1){
		 if (estatus.equals(Estatus.TIMBRADO) ||
		 estatus.equals(Estatus.CANCELADO)){
		 lugarFechaEmiHoraCert = ("Toluca, México a ").concat(comprobante.getFecha().toString().concat(" / ").concat(tfd.getFechaTimbrado().toString()));
		 }else if (estatus.equals(Estatus.GENERADO)|| estatus.equals(Estatus.VENDIDO)){
		 lugarFechaEmiHoraCert = ("Toluca, México a  ").concat(comprobante.getFecha().toString());
		 }
		}else{
			lugarFechaEmiHoraCert = "Toluca, México a ".concat(comprobante.getFecha().toString());
		}
		 agregarChunkYNuevaLinea("", font1, fraseDatosEmisor);
		agregarCeldaSinBorde(lugarFechaEmiHoraCert, font3, subTablaFecha, true);
	//	agregarCeldaSinBorde(" ", font1, subTablaFecha, true);
		if(estatus.equals(Estatus.CANCELADO)|| estatus.equals(Estatus.TIMBRADO)){
			agregarCeldaSinBorde("FACTURA", fontSerieYFolio, subTablaFecha, true);
		}else{
			if(estatus.equals(Estatus.GENERADO)){
				agregarCeldaSinBorde("PRESUPUESTO", fontSerieYFolio, subTablaFecha,true);
			}else{
				if(estatus.equals(Estatus.DEVOLUCION)){
					agregarCeldaSinBorde("DEVOLUCION", fontSerieYFolio, subTablaFecha, true);
				}else{
					agregarCeldaSinBorde("PEDIDO", fontSerieYFolio, subTablaFecha, true);
				}
			}
			
		}
		agregarCeldaSinBorde(getFolioYSerie(comprobante), fontSerieYFolio, subTablaFecha, true);
		
		
		
		celdaSubTablaFecha.addElement(subTablaFecha);
		celdaSubTablaFecha.setBorderColor(BaseColor.GRAY);
		tablaEncabezado.addCell(celdaSubTablaFecha);
		
		
		PdfPTable subTablaNota = new PdfPTable(1);
		PdfPCell celdaNota = new PdfPCell();
		celdaNota.setBorder(PdfPCell.NO_BORDER);
		if(estatus.equals(Estatus.CANCELADO)|| estatus.equals(Estatus.TIMBRADO)){
			agregarCeldaSinBorde("FACTURA", fontSerieYFolio, subTablaNota, true);
		}else{
			if(estatus.equals(Estatus.GENERADO)){
				agregarCeldaSinBorde("PRESUPUESTO", fontSerieYFolio, subTablaNota,true);
			}else{
				if(estatus.equals(Estatus.DEVOLUCION)){
					agregarCeldaSinBorde("DEVOLUCION", fontSerieYFolio, subTablaNota, true);
				}else{
					agregarCeldaSinBorde("PEDIDO", fontSerieYFolio, subTablaNota, true);
				}
			}
			
		}
		agregarCeldaSinBorde(getFolioYSerie(comprobante), fontSerieYFolio, subTablaNota, true);
		
		celdaNota.addElement(subTablaNota);
		//celdaNota.setBorderColor(BaseColor.GRAY);
		tablaEncabezado.addCell(celdaNota);
		
		PdfPTable tablaPrincipalEncabezado = new PdfPTable(3);
		crearNotaDoble(tablaPrincipalEncabezado,true,48,4,48,tablaEncabezado);
		document.add(tablaPrincipalEncabezado);

		// DIRECCIÓN 
		PdfPTable tablaDirYOtrosDatosFis = new PdfPTable(2);
		tablaDirYOtrosDatosFis.setWidthPercentage(100);
		tablaDirYOtrosDatosFis.setWidths(new float[] { 25,75});

		agregarCeldaConFondo("CONTACTO", fontHead, tablaDirYOtrosDatosFis, false);

//		String domr = "";
//		if (comprobante.getReceptor().getDomicilio() != null) {
//			domr = comprobante.getEmisor().getDomicilioFiscal().toString();
//		}
		agregarCeldaSinBorde(comprobante.getReceptor().getNombre(), font3, tablaDirYOtrosDatosFis, false);
		
		PdfPTable tablaPrincipalDireccion = new PdfPTable(3);
		crearNotaDoble(tablaPrincipalDireccion,true,48,4,48,tablaDirYOtrosDatosFis);
		document.add(tablaPrincipalDireccion);
		
		
		// TABLA CONCEPTOS
		PdfPTable tablaConceptos = new PdfPTable(5);
		tablaConceptos.setWidthPercentage(100);
		tablaConceptos.setWidths(new float[] { 12, 12, 40, 13, 13 });

		agregarCeldaConFondo("Cantidad", fontHead, tablaConceptos, true);

		agregarCeldaConFondo("Unidad", fontHead, tablaConceptos, true);

		agregarCeldaConFondo("Descripción", fontHead, tablaConceptos, true);

		agregarCeldaConFondo("Valor unitario", fontHead, tablaConceptos, true);

		agregarCeldaConFondo("Importe", fontHead, tablaConceptos, true);

		if (comprobante.getConceptos() != null) {
			List<Concepto> listaConceptos = comprobante.getConceptos().getConcepto();
			for (Concepto concepto : listaConceptos) {
				//agregarCelda(concepto.getNoIdentificacion(), font3, tablaConceptos, true);
				agregarCelda(concepto.getCantidad().toString(), font3, tablaConceptos, true);
				agregarCelda(concepto.getUnidad(), font3, tablaConceptos, true);
				agregarCelda(concepto.getDescripcion(), font3, tablaConceptos, false);
				//double aux=(concepto.getValorUnitario().doubleValue()*1.16 )*1;
				agregarCelda(formatter.format(concepto.getValorUnitario().doubleValue()), font3, tablaConceptos, true);
				double res=(concepto.getCantidad().doubleValue() * concepto.getValorUnitario().doubleValue());
				//total.setScale(2, RoundingMode.HALF_UP)
			//	BigDecimal b = new BigDecimal(res*1, MathContext.DECIMAL64);
//				String n=String.valueOf(res);
//				System.out.println("n:"+n);
//				System.out.println("long:"+n.length());
//				String x=n.substring(0, n.length()-2);
			
				//System.out.println("x:"+x);
				//double a=formatter.format(aux);
				 BigDecimal bigDecimal = BigDecimal.valueOf(res).setScale(2, RoundingMode.HALF_UP);
				agregarCelda(formatter.format(bigDecimal), font3, tablaConceptos, true);
			}
		}
		tablaConceptos.setSpacingBefore(4);
		tablaConceptos.setSpacingAfter(3);
		
		PdfPTable tablaPrincipalConceptos = new PdfPTable(3);
		crearNotaDoble(tablaPrincipalConceptos,false,48,4,48,tablaConceptos);
		document.add(tablaPrincipalConceptos);
		
		
		// IMPORTE CON LETRA
		PdfPTable tablaImporteConLetra = new PdfPTable(3);
		tablaImporteConLetra.setWidthPercentage(100);
		tablaImporteConLetra.setWidths(new int[] { 20, 65, 15 });
		agregarCeldaConFondo("Importe con letra ", fontHead, tablaImporteConLetra, true);

		double importeTotal = Math.round(comprobante.getTotal().doubleValue() * 100.0) / 100.0;
		String importeConLetra = NumberToLetterConverter.convertNumberToLetter(importeTotal);
		Chunk chunkImporteConLetra = new Chunk(importeConLetra, font3);
		Phrase fraseImporteConLetra = new Phrase(chunkImporteConLetra);
		PdfPCell celdaImporteConLetra = new PdfPCell();
		// celdaImporteConLetra.setVerticalAlignment(Element.ALIGN_CENTER);
		celdaImporteConLetra.setBorder(PdfPCell.NO_BORDER);
		celdaImporteConLetra.setPhrase(fraseImporteConLetra);
		tablaImporteConLetra.addCell(celdaImporteConLetra);

		emptyCell.setBackgroundColor(new BaseColor(246,123,29));
		tablaImporteConLetra.addCell(emptyCell);
		
		PdfPTable tablaPrincipalImporte = new PdfPTable(3);
		crearNotaDoble(tablaPrincipalImporte,false,48,4,48,tablaImporteConLetra);
		document.add(tablaPrincipalImporte);


		// LEYENDA Y, SUBTOTAL, IVA Y TOTAL
		PdfPTable tablaLeyendaTotal = new PdfPTable(3);
		tablaLeyendaTotal.setWidthPercentage(100);
		tablaLeyendaTotal.setWidths(new float[] { 65, 20, 15 });

		Phrase fraseLeyenda = new Phrase();
		// if (!estatus.equals(Estatus.GENERADO)) {
		Chunk chunkLeyenda = new Chunk("Todos los pedidos se entregan a pie de carro, cualquier maniobra adicional se cotiza extra.", fontTituloSellos);
		// fraseLeyenda.add(Chunk.NEWLINE);
		fraseLeyenda.add(chunkLeyenda);
		// }
		// fraseLeyenda.add(Chunk.NEWLINE);

		fraseLeyenda.add(Chunk.NEWLINE);
		String strMetodoPago = "Método de pago: ".concat(comprobante.getMetodoDePago())
				.concat("                 Moneda: ").concat(comprobante.getMoneda());
		Chunk chunkMetodoDePago = new Chunk(strMetodoPago, fontContenidoSellos);
		

		// se agrega la leyenda 'Efectos fiscales al pago'
		String strFormaDePago = "Forma de pago: ".concat(comprobante.getFormaDePago())
				.concat("                 Efectos fiscales al pago");
		
		Chunk chunkFormaDePago = new Chunk(strFormaDePago, fontContenidoSellos);
		if(tfd != null){
		fraseLeyenda.add(chunkMetodoDePago);
		fraseLeyenda.add(Chunk.NEWLINE);
		fraseLeyenda.add(chunkFormaDePago);
		fraseLeyenda.add(Chunk.NEWLINE);
		}
		String condicionesDePago = comprobante.getCondicionesDePago();
		if (condicionesDePago != null) {
			if (!condicionesDePago.contentEquals("")) {
				String strCondicionesDePago = "Condiciones de pago: ".concat(condicionesDePago).concat("      ");
				Chunk chunkCondicionesDePago = new Chunk(strCondicionesDePago, fontContenidoSellos);
				fraseLeyenda.add(chunkCondicionesDePago);
				fraseLeyenda.add(Chunk.NEWLINE);
			}
		}

		String numCtaPago = comprobante.getNumCtaPago();
		if (numCtaPago != null) {
			if (!numCtaPago.contentEquals("")) {
				String strNumCtaPago = "Número de cuenta de pago: ".concat(numCtaPago);
				Chunk chunkCondicionesDePago = new Chunk(strNumCtaPago, fontContenidoSellos);
				fraseLeyenda.add(chunkCondicionesDePago);
				fraseLeyenda.add(Chunk.NEWLINE);
			}
		}

		PdfPCell celdaLeyenda = new PdfPCell(fraseLeyenda);
		celdaLeyenda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tablaLeyendaTotal.addCell(celdaLeyenda);

		PdfPTable subTablaEtqTotal = new PdfPTable(1);
		agregarCeldaConFondo("", fontHead, subTablaEtqTotal, true);
		boolean existeIVATraslado = false;
		double importe = 0.0;
		if(comprobante.getImpuestos()!=null){
		List<Traslado> traslados = comprobante.getImpuestos().getTraslados().getTraslado();
		
		
		if (traslados.size() > 0) {
			if (traslados.get(0).getImpuesto().equals(IVA)) {
				existeIVATraslado = true;
				importe = traslados.get(0).getImporte().doubleValue();
				agregarCeldaConFondo("", fontHead, subTablaEtqTotal, true);
			}
		} else {
			subTablaEtqTotal.addCell(emptyCell);
		}
		}
		agregarCeldaConFondo("Total", fontHead, subTablaEtqTotal, true);
		PdfPCell celdaTablaEtqTotal = new PdfPCell(subTablaEtqTotal);
		celdaTablaEtqTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
		tablaLeyendaTotal.addCell(celdaTablaEtqTotal);
		PdfPTable subTablaValoresTotal = new PdfPTable(1);
		if(comprobante.getSubTotal()!=null){
			//agregarCelda(formatter.format(comprobante.getSubTotal().doubleValue()), font3, subTablaValoresTotal, true);
			agregarCelda("", font3, subTablaValoresTotal, true);
		}
		if (existeIVATraslado)
			//agregarCelda(formatter.format(importe), font3, subTablaValoresTotal, true);
			agregarCelda("", font3, subTablaValoresTotal,true);
		else
			subTablaValoresTotal.addCell(emptyCell);

		agregarCelda(formatter.format(comprobante.getTotal().doubleValue()), font3, subTablaValoresTotal, true);
		PdfPCell celdaTablaValoresTotal = new PdfPCell(subTablaValoresTotal);
		celdaTablaValoresTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
		tablaLeyendaTotal.addCell(celdaTablaValoresTotal);
		
		
		PdfPTable tablaPrincipalLeyendaTotal = new PdfPTable(3);
		crearNotaDoble(tablaPrincipalLeyendaTotal,false,48,4,48,tablaLeyendaTotal);
		document.add(tablaPrincipalLeyendaTotal);
		// DIRECCIÓN de entrega
				PdfPTable tablaDirs = new PdfPTable(2);
				tablaDirs.setWidthPercentage(100);
				tablaDirs.setWidths(new float[] { 25, 75 });

				agregarCeldaConFondo("Dirección de Entrega", fontHead, tablaDirs, false);
				agregarCeldaSinBorde(dir, font3, tablaDirs, false);
				
				PdfPTable tablaP = new PdfPTable(3);
				crearNotaDoble(tablaP,true,48,4,48,tablaDirs);
				document.add(tablaP);
				
				//////
		
		
				// Condiciones
				PdfPTable tablaC = new PdfPTable(2);
				tablaC.setWidthPercentage(100);
				tablaC.setWidths(new float[] { 25, 75 });

				agregarCeldaConFondo("Condiciones", fontHead, tablaC, false);
				agregarCeldaSinBorde(con, font3, tablaC, false);
				
				PdfPTable tablaP1 = new PdfPTable(3);
				crearNotaDoble(tablaP1,true,48,4,48,tablaC);
				document.add(tablaP1);
				
				//////
	
		
	}

	public void construirTimbre(String selloDigital, byte[] bytesQRCode, TimbreFiscalDigital tfd)
			throws DocumentException, MalformedURLException, IOException {
		// QRCode Y SELLOS DIGITALES
		PdfPTable mainTable = new PdfPTable(2);
		mainTable.setWidthPercentage(100.0f);
		mainTable.setWidths(new float[] { 25, 75 });

		PdfPCell primeraCeldaTabla = new PdfPCell();
		primeraCeldaTabla.setBorderWidthTop(1);
		primeraCeldaTabla.setBorderWidthBottom(1);
		primeraCeldaTabla.setBorderWidthRight(1);

		PdfPTable tablaQRCode = new PdfPTable(1);
		if(bytesQRCode!=null){
		Image imgQRCode = Image.getInstance(bytesQRCode);
		// int dpi = imgQRCode.getDpiX();
		// imgQRCode.scalePercent(100 * 72 / dpi - 20);
		// el tercer parámetro en el constructor de Chunk (offsetY) controla el
		// tamaño de la imagen
		Chunk chunkQRCode = new Chunk(imgQRCode, 0, -70);
		PdfPCell celdaQRCode = new PdfPCell();
		celdaQRCode.setBorder(PdfPCell.NO_BORDER);
		celdaQRCode.addElement(chunkQRCode);
		tablaQRCode.addCell(celdaQRCode);
		primeraCeldaTabla.addElement(tablaQRCode);
		mainTable.addCell(primeraCeldaTabla);
		}
		
		PdfPCell segundaCeldaTabla = new PdfPCell();
		segundaCeldaTabla.setBorderWidthTop(1);
		segundaCeldaTabla.setBorderWidthBottom(1);
		segundaCeldaTabla.setBorderWidthRight(1);
		segundaCeldaTabla.setBorderColor(BaseColor.GRAY);

		PdfPTable tablaTimbre = new PdfPTable(1);
		tablaTimbre.setWidthPercentage(100);

		// celdaQRCode = new PdfPCell(Image.getInstance(bytesQRCode));
		// celdaQRCode.setBorderWidth(0);

		PdfPCell cell1table7 = new PdfPCell();
		cell1table7.setBorderWidth(0);

		if(tfd!=null){
		Phrase line3footer = new Phrase();
		Chunk line3part1 = new Chunk("Sello digital del emisor ", fontTituloSellos);
		Chunk line3part2 = new Chunk(tfd.getSelloCFD(), fontContenidoSellos);
		line3footer.add(line3part1);
		line3footer.add(Chunk.NEWLINE);
		line3footer.add(line3part2);

		PdfPCell cell4table7 = new PdfPCell(line3footer);
		
		cell4table7.setBorderWidth(0);
		// cell4table7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

		Phrase line4footer = new Phrase();
		Chunk line4part1 = new Chunk("Sello digital del SAT ", fontTituloSellos);
		Chunk line4part2 = new Chunk(tfd.getSelloSAT(), fontContenidoSellos);
		line4footer.add(line4part1);
		line4footer.add(Chunk.NEWLINE);
		line4footer.add(line4part2);

		PdfPCell cell5table7 = new PdfPCell(line4footer);
		cell5table7.setBorderWidth(0);
		// cell5table7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

		Phrase fraseCadenaOriginal = new Phrase();
		Chunk chunkCadenaOriginalEtq = new Chunk("Cadena original del complemento de certificación digital del SAT ",
				fontTituloSellos);
		Chunk chunkCadenaOriginalValor = new Chunk(selloDigital, fontContenidoSellos);
		fraseCadenaOriginal.add(chunkCadenaOriginalEtq);
		fraseCadenaOriginal.add(Chunk.NEWLINE);
		fraseCadenaOriginal.add(chunkCadenaOriginalValor);

		PdfPCell celdaCadenaOriginal = new PdfPCell(fraseCadenaOriginal);
		celdaCadenaOriginal.setBorderWidth(0);

		tablaTimbre.addCell(cell4table7);

		tablaTimbre.addCell(cell5table7);

		tablaTimbre.addCell(celdaCadenaOriginal);

		// tablaTimbre.addCell(cell6table7);

		segundaCeldaTabla.addElement(tablaTimbre);
		}
		mainTable.addCell(segundaCeldaTabla);
		mainTable.setSpacingBefore(2);

		document.add(mainTable);
	}

	public static class MyFooter extends PdfPageEventHelper {
		Font ffont = new Font(Font.FontFamily.HELVETICA, 8.5F, Font.NORMAL);
		Font ffontBold = new Font(Font.FontFamily.HELVETICA, 8.5F, Font.BOLD);
		private String uuid;
		private Date fechaCancel;
		private String selloCancel;

		public MyFooter(String uuid) {
			this.uuid = uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public void setFechaCancel(Date fechaCancel) {
			this.fechaCancel = fechaCancel;
		}

		public void setSelloCancel(String selloCancel) {
			this.selloCancel = selloCancel;
		}

		public void onEndPage(PdfWriter writer, Document document) {
			PdfContentByte cb = writer.getDirectContent();
			Phrase footer = new Phrase();
			Phrase footerFecha = new Phrase();
			Phrase footerSello = new Phrase();
			/*
			 * Phrase footer = new
			 * Phrase("Hoja número ".concat(Integer.toString(document.
			 * getPageNumber())).concat(" de ")
			 * .concat(Integer.toString(writer.getPageNumber())).
			 * concat(" del CFDi con UUID:").concat(uuid), ffont);
			 */
			Chunk chunkHojaNum = new Chunk("Hoja número ".concat(Integer.toString(document.getPageNumber()))
					.concat(" de ").concat(Integer.toString(writer.getPageNumber())).concat(" del CFDi con UUID:")
					.concat(uuid), ffont);
			footer.add(chunkHojaNum);

			if (fechaCancel != null) {
				Chunk chunkFecha = new Chunk("Fecha de Cancelación: ".concat(fechaCancel.toString()), ffont);
				// footer.add(Chunk.NEWLINE);
				footerFecha.add(chunkFecha);

				ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footerFecha,
						(document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 30, 0);
			}

			if (selloCancel != null) {
				Chunk chunkEtqSelloCancel = new Chunk("Sello digital SAT (Cancelación): ", ffontBold);
				Chunk chunkSelloCancel = new Chunk(selloCancel, ffont);
				// footer.add(Chunk.NEWLINE);
				footerSello.add(chunkEtqSelloCancel);
				footerSello.add(chunkSelloCancel);

				ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footerSello,
						(document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 20, 0);
			}

			ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer,
					(document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);
		}
	}

}
