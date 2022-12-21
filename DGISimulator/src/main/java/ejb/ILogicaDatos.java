package ejb;

import com.antel.dti.lib.logger.SatelitalesLogger;
import exception.DGIException;
import uy.gub.dgi.cfe.ACKCFEDocument;
import uy.gub.dgiConsulta.*;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ILogicaDatos {
    /*Contrato a cumplir si deseamos implementarlo con MongoDB*/
    /*Consultas*/
    String getConsultarRespuestaReporte(ConsultaRespuestaReporte entrada) throws DGIException; /*efacconsultarrespuestareporte*/
    List<DatosCFE> getConsultaCFERecibidos(ConsultaCFERecibidos entrada) throws DGIException; /*efacconsultarcferecibidos*/
    ArrayList<RucEmisoresMailRucEmisoresMailItem> getRucEmisoresMail(Date fchInicioFiltro) throws DGIException; /*efacconsultarrucemisores*/
    ACKCFEDocument getACKCfe(String xmlData) throws DGIException; /*efacconsultarestadoenvio*/
    ArrayList<DatosReporte> getDatosEnvioReporte(ConsultaEnviosReporte query) throws DGIException; /*efacconsultarenviosreporte*/
    ACKConsultaEnviosSobre getConsultaEnviosSobre(ConsultaEnviosSobre entrada) throws DGIException; /*efacconsultarenviossobre*/
    ACKConsultaEstadoCFE getEstadoCFE(CFEId filtro) throws DGIException; /*efacconsultarestadocfe*/
    ACKConsultaEnviosCFE getEnvioCFE(CFEId entrada) throws DGIException; /*efacconsultarenvioscfe*/
    /*Consultas*/

    /*Recepcion*/
    /*Respuestas hardcodeadas que no consultan datos, se esperan un conjunto de posibles invocaciones que dan su respectivo resultado*/
    /*Recepcion*/






}
