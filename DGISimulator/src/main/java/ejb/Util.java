package ejb;

import com.antel.dti.lib.logger.SatelitalesLogger;
import datatypes.ACKCFEDet;
import datatypes.ACKCFEDocument;
import exception.DGIException;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import uy.com.antel.eFact.consulta.ConsultaDocument;
import uy.gub.dgi.cfe.*;
import uy.gub.dgi.cfe.impl.ACKSobreDocumentImpl;
import uy.gub.dgiConsulta.ConsultaCFERecibidos;
import uy.gub.dgiConsulta.ConsultaEnviosSobre;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

@Stateless
public class Util {

    /*Juego de datos de prueba para retornos de los ws*/
    private SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    private SatelitalesLogger log;

    @PostConstruct
    private void init(){

    }

    public XMLGregorianCalendar DateToXMLGregorianCalendar(Date date){
        try {
            GregorianCalendar gCal = new GregorianCalendar();
            gCal.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gCal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Date XMLGregorianCalendarToDate(XMLGregorianCalendar date){
        return date.toGregorianCalendar().getTime();
    }
    public String dateToString(Date fecha, String formato){
        int day = fecha.getDate();
        int month = fecha.getMonth()+1;
        int year = fecha.getYear()+1900;
        switch(formato){
            case "yyyy-MM-dd":
                return year+"-"+month+"-"+day;
            case "dd-MM-yyyy":
                return day+"-"+month+"-"+year;
            case "dd-MM-yyyyThh:mm:ss":
                return day+"-"+month+"-"+year+"T"+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds();
        }
        return "ERROR en dateToString()";
    }
    public boolean validarFiltros(XMLGregorianCalendar fechaDesdeXMLG, XMLGregorianCalendar fechaHastaXMLG) throws DGIException {
        XMLGregorianCalendar XMLGfechaDesde = fechaDesdeXMLG;
        XMLGregorianCalendar XMLGfechaHasta = fechaHastaXMLG;
        Date fechaDesde = XMLGfechaDesde.toGregorianCalendar().getTime();
        Date fechaHasta = XMLGfechaHasta.toGregorianCalendar().getTime();
        String fechaDesdeLimiteStr = "01-10-2011";
        String fechaHastaLimiteStr = "31-12-2050";
        Date fechaDesdeLimite = new Date();
        Date fechaHastaLimite = new Date();
        try {
            fechaDesdeLimite = formato.parse(fechaDesdeLimiteStr);
            fechaHastaLimite= formato.parse(fechaHastaLimiteStr);
        } catch (ParseException e) {
            throw new DGIException("ERROR: Excepcion en el parseo de una fecha");
        }
        if(fechaDesde.after(fechaHasta) || fechaDesde.equals(fechaHasta)) { /*FechaDesde debe ser menor que fecha hasta*/
            String error = "ERROR: FechaDesde debe ser menor que FechaHasta";
            throw new DGIException(error);
        }
        Duration duration = Duration.between(fechaDesde.toInstant(), fechaHasta.toInstant());
        Long seconds = duration.getSeconds();
        Long dias = ((seconds/60)/60)/24;
        if(dias>31) {
            String error = "ERROR: Entre FechaDesde y FechaHasta no puede haber más de 31 días de diferencia.";
            throw new DGIException(error);
        }

        if(!(fechaDesde.after(fechaDesdeLimite) && fechaHasta.before(fechaHastaLimite))){
            String error = "ERROR: el rango de fechas debe estar entre 01-10-2011 y 31-12-2050";
            throw new DGIException(error);
        }
        return true;
    }

    public String generarACKSobre(EnvioCFEDocument envioCfe, boolean cdata){
        String retorno = "";
        if(envioCfe!=null){
        EnvioCFEDocument.EnvioCFE.Caratula caratula = envioCfe.getEnvioCFE().getCaratula();
        retorno +="<ACKSobre xmlns=\"http://cfe.dgi.gub.uy\">\n";
        retorno+="<Caratula>\n";
        retorno+="<RUCReceptor>"+caratula.getRutReceptor()+"</RUCReceptor>\n";
        retorno+="<RUCEmisor>"+caratula.getRUCEmisor()+"</RUCEmisor>\n";
        retorno+="<IDRespuesta>"+Math.abs(this.getRandomLong())+"</IDRespuesta>\n";
        retorno+="<NomArch/>\n";
        retorno+="<FecHRecibido>"+caratula.getFecha().getTime().toString()+"</FecHRecibido>\n";
        retorno+="<IDEmisor>"+caratula.getIdemisor()+"</IDEmisor>\n";
        retorno+="<IDReceptor>1513</IDReceptor>\n"; /*ID RECEPTOR Y RUC RECEPTOR ES LO MISMO???*/
        retorno+="<CantidadCFE>"+caratula.getCantCFE()+"</CantidadCFE>\n";
        retorno+="<Tmst>"+Date.from(Instant.now())+"</Tmst>\n";
        retorno+="</Caratula>\n";
        retorno+="<Detalle>\n";
        retorno+="<Estado>AE</Estado>\n";
        retorno+="<ParamConsulta>\n";
        retorno+="<Token>"+ UUID.randomUUID().toString()+"</Token>\n";
        retorno+="<Fechahora>"+Date.from(Instant.now())+"</Fechahora>\n";
        retorno+="</ParamConsulta>\n";
        retorno+="</Detalle>\n";
        retorno+="</ACKSobre>\n";
        if(cdata){
            retorno="<![CDATA["+retorno;
            retorno=retorno+"]]>";
        }
        }
        return retorno;
    }
    public String generarACKRepDiario(ReporteDocument reporte, boolean cdata){
        String retorno = "";
        ReporteDefType.Caratula caratula = reporte.getReporte().getCaratula();
        retorno+="<ACKRepDiario xmlns=\"http://cfe.dgi.gub.uy\">\n";
        retorno+="<Caratula>\n";
        retorno+="<RUCReceptor>214844360018</RUCReceptor>\n"; /*No se encuentra en el el objeto, hardcodeo*/
        retorno+="<RUCEmisor>"+caratula.getRUCEmisor()+"</RUCEmisor>\n";
        retorno+="<NomArch>Rep_219999820013_20120119_01_CasiOKNV.xml</NomArch>\n"; /*No se encuentra en el objeto, hardcodeo*/
        retorno+="<FecHRecibido>"+caratula.getFechaResumen()+"</FecHRecibido>\n";
        retorno+="<IDEmisor>"+caratula.getIDEmisor()+"</IDEmisor>\n";
        retorno+="<IDReceptor>1513</IDReceptor>\n";
        retorno+="<Tmst>"+caratula.getTmstFirmaEnv()+"</Tmst>\n";
        retorno+="</Caratula>\n";
        retorno+="<Detalle>\n";
        retorno+="<Estado>AE</Estado>\n";
        retorno+="</Detalle>\n";
        retorno+="</ACKRepDiario>\n";
        if(cdata){
            retorno="<![CDATA["+retorno;
            retorno=retorno+"]]>";
        }
        return retorno;
    }
    public String generarACKCFE(ACKCFEDocument ack, boolean cdata) throws DGIException {
        String retorno = "";
        if(ack!=null){
        var caratula = ack.getCaratula();
        var detACKCFE = ack.getListaDet();
        retorno+="<ACKCFE xmlns=\"http://cfe.dgi.gub.uy\">\n";
        retorno+="<Caratula>\n";
        retorno+="<RUCReceptor>"+caratula.getRUCReceptor()+"</RUCReceptor>\n";
        retorno+="<RUCEmisor>"+caratula.getRUCEmisor()+"</RUCEmisor>\n";
        retorno+="<IDRespuesta>"+caratula.getIDRespuesta()+"</IDRespuesta>\n";
        retorno+="<NomArch>"+caratula.getNomArch()+"</NomArch>\n";
        retorno+="<FecHRecibido>"+caratula.getFecHRecibido().getTime()+"</FecHRecibido>\n";
        retorno+="<IDEmisor>"+caratula.getIdEmisor()+"</IDEmisor>\n";
        retorno+="<IDReceptor>"+caratula.getIdReceptor()+"</IDReceptor>\n";
        retorno+="<CantenSobre>"+caratula.getCantenSobre()+"</CantenSobre>\n";
        retorno+="<CantResponden>"+caratula.getCantResponden()+"</CantResponden>\n";
        retorno+="<CantCFEAceptados>"+caratula.getCantCFEAceptados()+"</CantCFEAceptados>\n";
        retorno+="<CantCFERechazados>"+caratula.getCantCFERechazados()+"</CantCFERechazados>\n";
        retorno+="<CantCFCAceptados>"+caratula.getCantCFCAceptados()+"</CantCFCAceptados>\n";
        retorno+="<CantCFCObservados>"+caratula.getCantCFCObservados()+"</CantCFCObservados>\n";
        retorno+="<CantOtrosRechazados>"+caratula.getCantOtrosRechazados()+"</CantOtrosRechazados>\n";
        retorno+="<Tmst>"+caratula.getTmst().getTime()+"</Tmst>\n";
        retorno+="</Caratula>\n";
        for(ACKCFEDet item : detACKCFE){

            retorno+="<ACKCFE_Det>\n";
            retorno+="<Nro_ordinal>"+item.getNroOrdinal()+"</Nro_ordinal>\n";
            retorno+="<TipoCFE>"+item.getTipoCFE()+"</TipoCFE>\n";
            retorno+="<Serie>"+item.getSerie()+"</Serie>\n";
            retorno+="<NroCFE>"+item.getNroCFE()+"</NroCFE>\n";
            retorno+="<FechaCFE>"+item.getFechaCFE().getTime()+"</FechaCFE>\n";
            retorno+="<TmstCFE>"+item.getTmstCFE()+"</TmstCFE>\n";
            retorno+="<Estado>"+item.getEstado()+"</Estado>\n";
            retorno+="</ACKCFE_Det>\n";
        }
        retorno+="</ACKCFE>\n";
        }else{
            throw new DGIException("NO HAY REGISTROS PARA ESTA CONSULTA.");
        }
        if(cdata){
            retorno="<![CDATA["+retorno;
            retorno=retorno+"]]>";
        }
        return retorno;
    }

    public Long getRandomLong(){
        return new Random(1561231465156L).nextLong();
    }
    public <T> T  getObjectXMLBeans(String xml, boolean fromResources, String objeto) throws DGIException{
        /*Si fromResources es true entonces xml debe ser una ruta a ese resource*/
        /*Si fromResources es false entonces xml debe ser el CFE en String, que se convertirá a CFEDocument*/
        T doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            CharsetEncoder encoder1252 = Charset.forName("Windows-1252").newEncoder();
            System.out.println(encoder1252.getClass().getCanonicalName());
            if(fromResources) {
                BufferedReader br = new BufferedReader(new FileReader(xml));
                StringWriter sw = new StringWriter();
                while (br.ready()) {
                    sw.write(br.readLine() + "\n");
                }
                encoder1252.onUnmappableCharacter(CodingErrorAction.REPLACE);
                System.out.println(encoder1252.replacement()[0]);
                ByteBuffer bb1252 = encoder1252.encode(CharBuffer.wrap(sw.getBuffer()));
                String s1252 = new String(bb1252.array(), Charset.forName("Windows-1252"));
                switch(objeto){
                    case "ReporteDocument":
                        doc = (T) ReporteDocument.Factory.parse(s1252);
                    break;
                    case "EnvioCFEDocument":
                        doc = (T) EnvioCFEDocument.Factory.parse(s1252);
                        break;
                    case "ConsultaCFEDocument":
                        doc = (T) ConsultaDocument.Factory.parse(s1252);
                        break;
                }
                log.info(s1252);
            }else{
                /*Si tomamos el XML de la entrada del webservice, es necesario eliminar la etiqueta CDATA, si la hubiera*/
                xml.replace("<![CDATA][", "");
                xml.replace("]]>", "");
                switch(objeto){
                    case "ReporteDocument":
                        doc = (T) ReporteDocument.Factory.parse(xml);
                        break;
                    case "EnvioCFEDocument":
                        doc = (T) EnvioCFEDocument.Factory.parse(xml);
                        break;
                    case "ConsultaCFEDocument":
                        //doc = (T) .Factory.parse(xml).getConsulta();

                        break;
                }            }
        } catch (FileNotFoundException e) {
            throw new DGIException("ERROR: No se encontro el archivo en la ruta indicada.");
        } catch (XmlException e) {
            throw new DGIException("ERROR: " + e.getMessage());
        } catch (CharacterCodingException e) {
            throw new DGIException("ERROR: " + e.getMessage());
        } catch (IOException e) {
            throw new DGIException("ERROR: " + e.getMessage());
        }
        return doc;
    }
    public String getValorFromTag(String xmlData, String initialTag, String finalTag){
        String value = "";
        String temp = xmlData;
        String parts[] = temp.split(initialTag);
        temp = parts[1];
        String parts2[] = temp.split(finalTag);
        temp = parts2[0];
        value = temp;
        return value;
    }

}



