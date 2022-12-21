package impl;

import com.antel.dti.lib.logger.SatelitalesLogger;
import ejb.DatosMem;
import ejb.Util;
import exception.DGIException;
import uy.gub.dgiConsulta.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
@Stateless
public class ConsultasImpl implements WSEFacturaConsultasSoapPort {

    @Inject
    private SatelitalesLogger log;

    @EJB
    private DatosMem datos;

    @EJB
    private Util util;

    @Override
    @WebMethod(operationName="efacconsultarenvioscfe")
    public WSEFacturaConsultasEFACCONSULTARENVIOSCFEResponse efacconsultarenvioscfe(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARENVIOSCFE parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARENVIOSCFEResponse();
        var entrada = parameters.getCfeid();
        ACKConsultaEnviosCFE resultado = null;
        try {
            resultado = datos.getEnvioCFE(entrada);
        } catch (DGIException e) {
            log.error(e.getMessage());
        }
        respuesta.setAckconsultaenvioscfe(resultado);
        String logResultado = "RETORNO DE EFACCONSULTARENVIOSCFE\n";
        if(resultado!=null) {
            List<DatosSobre> retorno = resultado.getColeccionDatosSobres().getDatosSobre();
            if (!retorno.isEmpty()) {
                Date fecha = util.XMLGregorianCalendarToDate(retorno.get(0).getParamConsulta().getFechahora());
                String fechaParamConsulta = fecha.toString();
                for (DatosSobre item : retorno) {
                    logResultado += "ID Emisor: " + item.getIdEmisor() + " // ID Receptor: " + item.getIdReceptor() + " // EstadoSobre: " + item.getEstadoSobre() + " // Fecha Sobre: " + item.getFechaHoraSobre().toString() + "\n";
                }
                logResultado += "Primer sobre en el que aparecieron estos CFE: \n\t TOKEN: " + retorno.get(0).getParamConsulta().getToken() + "\n\t FECHA (no quedo ordenado por las fechas de primer aparicion.): " + fechaParamConsulta + "\n";
                log.info(logResultado);
            } else {
                logResultado = "NO HAY REGISTROS PARA ESTA CONSULTA.";
                log.info(logResultado);
            }
        }
        return respuesta;
    }

    @Override
    @WebMethod(operationName="efacconsultarestadocfe")
    public WSEFacturaConsultasEFACCONSULTARESTADOCFEResponse efacconsultarestadocfe(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARESTADOCFE parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARESTADOCFEResponse();
        var entrada = parameters.getCfeid();
        ACKConsultaEstadoCFE resultado = null;
        try {
            resultado = datos.getEstadoCFE(entrada);
        } catch (DGIException e) {
            log.error(e.getMessage());
        }
        respuesta.setAckconsultaestadocfe(resultado);
        String logResultado = "RETORNO DE EFACCONSULTARESTADOCFE\n";
        if(resultado!=null){
        Date fecha = util.XMLGregorianCalendarToDate(resultado.getParamConsulta().getFechahora());
        String fechaParamConsulta = fecha.toString();
        logResultado+="ID Emisor: " +resultado.getIdEmisor() + " // ID Receptor: " + resultado.getIdReceptor() + " // Estado CFE: " + resultado.getEstadoCFE()+  " //\n Primer sobre en el que apareció este CFE:\n\t TOKEN: " + resultado.getParamConsulta().getToken() + "\n\t FECHA: " + fechaParamConsulta;
        log.info(logResultado);
        }else{
            logResultado = "NO HAY REGISTROS PARA ESTA CONSULTA.";
            log.info(logResultado);
        }
        return respuesta;
    }

    @Override
    @WebMethod(operationName="efacconsultarenviossobre")
    public WSEFacturaConsultasEFACCONSULTARENVIOSSOBREResponse efacconsultarenviossobre(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARENVIOSSOBRE parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARENVIOSSOBREResponse();
        var entrada = parameters.getConsultaenviossobre();
        ACKConsultaEnviosSobre resultado = null;
        try{
            resultado = datos.getConsultaEnviosSobre(entrada);
        }catch(DGIException e){
            log.error(e.getMessage());
        }
        String logResultado = "RETORNO DE EFACCONSULTARENVIOSSOBRE\n";
        if(resultado!=null){
            respuesta.setAckconsultaenviossobre(resultado);
            logResultado+="SE OBTIENEN LOS SIGUIENTES SOBRES DENTRO DEL RANGO DE FECHAS Y CON EL IDEMISOR, IDRECEPTOR ESPECIFICADOS:\n ";
            ArrayOfDatosSobre array = resultado.getColeccionDatosSobre();
            List<DatosSobre> lista = array.getDatosSobre();
            if(!lista.isEmpty()){
            Date fecha = util.XMLGregorianCalendarToDate(lista.get(0).getParamConsulta().getFechahora());
            String fechaParamConsulta = fecha.toString();
            for(DatosSobre item: lista){
                    logResultado+="ID Emisor: " + item.getIdEmisor() + " // ID Receptor: " + item.getIdReceptor() + " // EstadoSobre: " + item.getEstadoSobre() + " // Fecha Sobre: " + item.getFechaHoraSobre().toString() +  "\n";
            logResultado+="Primer sobre en el que aparecieron estos CFE: \n\t TOKEN: " + lista.get(0).getParamConsulta().getToken() + "\n\t FECHA (no quedo ordenado por las fechas de primer aparicion.): " + fechaParamConsulta+"\n";
            }
            }else{
                logResultado = "NO HAY REGISTROS PARA ESTA CONSULTA.";
                log.info(logResultado);
                return respuesta;
            }
            log.info(logResultado);
    }else{
            logResultado = "NO HAY REGISTROS PARA ESTA CONSULTA.";
            log.info(logResultado);
        }
        return respuesta;
    }
    @Override
    @WebMethod(operationName="efacconsultarenviosreporte")
    public WSEFacturaConsultasEFACCONSULTARENVIOSREPORTEResponse efacconsultarenviosreporte(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARENVIOSREPORTE parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARENVIOSREPORTEResponse();
        var entrada = parameters.getConsultaenviosreporte();
        ArrayList<DatosReporte> datosReporte = new ArrayList();
        try{
        datosReporte = datos.getDatosEnvioReporte(entrada);
        }catch(DGIException ex){
            log.error(ex.getMessage());
        }

        var ack = new ACKConsultaEnviosReporte();
        var coleccion = new ArrayOfDatosReporte();
        coleccion.setDatosReporte(datosReporte);
        ack.setColeccionDatosReporte(coleccion);
        respuesta.setAckconsultaenviosreporte(ack);
        String retorno = "RETORNO DE EFACCONSULTARENVIOSREPORTE\n";
        if(!datosReporte.isEmpty()){
        for(DatosReporte datos : datosReporte){
            retorno +="ID Emisor: " + datos.getIdEmisor() + " // ID Receptor: " + datos.getIdReceptor() + " // Estado: " + datos.getEstado() + " // FechaHoraRecepcion: " + datos.getFechaHoraRecepcion().toString()+ "\n" ;
        }
        }else{
            retorno = "NO HAY REGISTROS EN ESTA CONSULTA.";
        }
        log.info(retorno);
        return respuesta;
    }

    @Override
    @WebMethod(operationName="efacconsultarrucemisores")
    public WSEFacturaConsultasEFACCONSULTARRUCEMISORESResponse efacconsultarrucemisores(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARRUCEMISORES parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARRUCEMISORESResponse();
        try{
        /*String denominacion = parameters.getConsultarucemisores().getFiltroEFacDenominacion();
        String docNro = parameters.getConsultarucemisores().getFiltroEFacDocNro();
        estos dos parametros son opcionales, y en la logica del MDB de getEclientesDGI no se usan, por lo tanto no son necesarios
        */
        XMLGregorianCalendar FCHEmisorInicioFiltro = parameters.getConsultarucemisores().getFiltroEFacRUCEmisorAudFchHora();
        Date fchInicioFiltro = FCHEmisorInicioFiltro.toGregorianCalendar().getTime();
        RucEmisoresMail rucEmisoresMail = new RucEmisoresMail();
        rucEmisoresMail.setRucEmisoresMailRucEmisoresMailItem(datos.getRucEmisoresMail(fchInicioFiltro));
        respuesta.setRucemisoresmail(rucEmisoresMail);

        var listaRucEmisores = respuesta.getRucemisoresmail().getRucEmisoresMailRucEmisoresMailItem();
        String listado = "LISTADO\n";
        if(!listaRucEmisores.isEmpty()){
        log.info("Ejecución exitosa, se obtiene el siguiente listado:");
        for(RucEmisoresMailRucEmisoresMailItem l : respuesta.getRucemisoresmail().getRucEmisoresMailRucEmisoresMailItem()){
            listado += "RUC: " + l.getRUC() +
                    " // DENOMINACION: " + l.getDENOMINACION() +
                    " // MAIL: " + l.getMAIL() +
                    " // NOMBRE FANTASIA: " + l.getNOMBREFANTASIA() +
                    " // FECHA INICIO: " + l.getFECHAINICIO().toString() + "\n";
        }
        }else{
            listado = "NO HAY REGISTROS EN ESTA CONSULTA.";
        }
        log.info(listado);
        }catch(Exception ex){
            log.error("Error en la ejecución del ws efacconsultarrucemisores: " + ex.getMessage());
        }
        return respuesta;
    }

    @Override
    @WebMethod(operationName="efacconsultarcferecibidos")
    public WSEFacturaConsultasEFACCONSULTARCFERECIBIDOSResponse efacconsultarcferecibidos(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARCFERECIBIDOS parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARCFERECIBIDOSResponse();
        var entrada = parameters.getConsultacferecibidos();
        List<DatosCFE> listaRetorno = new ArrayList();
        try {
            listaRetorno = datos.getConsultaCFERecibidos(entrada);
        } catch (DGIException e) {
            log.error(e.getMessage());
        }
        var ack = new ACKConsultaCFERecibidos();
        var coleccion = new ArrayOfDatosCFE();
        coleccion.setDatosCFE(listaRetorno);
        ack.setColeccionDatosCFE(coleccion);
        respuesta.setAckconsultacferecibidos(ack);
        String retorno = "RETORNO DE EFACCONSULTARCFERECIBIDOS\n";
        if(!listaRetorno.isEmpty()){
        for(DatosCFE item : listaRetorno){
            retorno+="RUC Emisor // NroCFE // Serie // TipoCFE // FechaEmision // Estado // Moneda // TotalNeto // TotalIVA // MontoTotal // TotalRetenido\n";
            retorno+= entrada.getRUCEmisor() + " // " + item.getNro() + " // " + item.getSerie() + " // " + item.getTipoCFE() + " // " + item.getFechaHora().toString() + " // " + item.getEstado() + " // " + item.getMoneda() + " // " + item.getTotalNeto()  + " // " + item.getTotalIva() + " // " + item.getTotalNeto() + " // " + item.getTotalIva() + " // " + item.getMontoTotal() + " // " + 0 + "\n";
        }
        }else{
            retorno = "NO HAY REGISTROS EN ESTA CONSULTA.";
        }
        log.info(retorno);

        return respuesta;
    }

    @Override
    @WebMethod(operationName="efacconsultarrespuestareporte")
    public WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTEResponse efacconsultarrespuestareporte(@WebParam(name="parameters")WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTE parameters) {
        var respuesta = new WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTEResponse();
        var entrada = parameters.getConsultarespuestareporte();
        String resultado = null;
        try {
            resultado = datos.getConsultarRespuestaReporte(entrada);
        } catch (DGIException e) {
            log.error(e.getMessage());
        }
        String retorno = "RETORNO DE EFACCONSULTARRESPUESTAREPORTE\n";
        if(!resultado.equals("")){
            retorno += resultado;
        }else{
            retorno = "LA RESPUESTA DE ESTA CONSULTA FUE NULA.";
        }
        log.info(retorno);
        return respuesta;
    }

}
