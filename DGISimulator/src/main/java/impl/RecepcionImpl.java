package impl;




import com.antel.dti.lib.logger.SatelitalesLogger;
import ejb.DatosMem;
import ejb.Util;
import exception.DGIException;
import uy.gub.dgi.cfe.*;
import uy.gub.dgiRecepcion.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@Stateless
public class RecepcionImpl implements WSEFacturaSoapPort {

    @Inject
    private SatelitalesLogger log;

    @EJB
    private DatosMem datos;

    @EJB
    private Util util;

    @Override
    @WebMethod(operationName="efacrecepcionreporte")
    public WSEFacturaEFACRECEPCIONREPORTEResponse efacrecepcionreporte(@WebParam(name="parameters")WSEFacturaEFACRECEPCIONREPORTE parameters) {
        var respuesta = new WSEFacturaEFACRECEPCIONREPORTEResponse();
        var entrada  = parameters.getDatain();
        Data dataOut = new Data();
        /*Logica*/
        ReporteDocument doc = null;
        try{
            doc = util.getObjectXMLBeans(entrada.getXmlData(), false, "ReporteDocument");
        }catch(DGIException e){
            log.error("Datos de entrada no fueron aceptados.");
            log.error(e.getMessage());
        }
        String salida = util.generarACKRepDiario(doc, false);
        dataOut.setXmlData(salida);
        /*Logica*/
        respuesta.setDataout(dataOut);
        return respuesta;
    }

    @Override
    @WebMethod(operationName="efacconsultarestadoenvio")
    public WSEFacturaEFACCONSULTARESTADOENVIOResponse efacconsultarestadoenvio(@WebParam(name="parameters")WSEFacturaEFACCONSULTARESTADOENVIO parameters) {
        var respuesta = new WSEFacturaEFACCONSULTARESTADOENVIOResponse();
        var entrada  = parameters.getDatain();
        Data dataOut = new Data();
        /*Logica*/
        String xmlEntrada = entrada.getXmlData();
        datatypes.ACKCFEDocument ack = null;

        /*Logica*/
        respuesta.setDataout(dataOut);
        try{
            ack = datos.getACKCfe(xmlEntrada);
            String salida = util.generarACKCFE(ack, false);
            dataOut.setXmlData(salida);
            respuesta.setDataout(dataOut);
            return respuesta;
        }catch(DGIException e){
            log.error("Datos de entrada no fueron aceptados.");
            log.error(e.getMessage());
        }
        var error = new WSEFacturaEFACCONSULTARESTADOENVIOResponse();
        var data = new Data();
        data.setXmlData("NO HAY REGISTROS PARA ESTA CONSULTA");
        error.setDataout(data);
        return error;
    }

    @Override
    @WebMethod(operationName="efacrecepcionsobre")
    public WSEFacturaEFACRECEPCIONSOBREResponse efacrecepcionsobre(@WebParam(name="parameters")WSEFacturaEFACRECEPCIONSOBRE parameters) {
        var respuesta = new WSEFacturaEFACRECEPCIONSOBREResponse();
        var entrada  = parameters;
        Data dataOut = new Data();
        /*Logica*/
        EnvioCFEDocument sobre = null;
        try{
            sobre = util.getObjectXMLBeans(entrada.getDatain().getXmlData(), false, "EnvioCFEDocument");
        }catch(DGIException e){
            log.error("Datos de entrada no fueron aceptados");
            log.error(e.getMessage());
        }
        /*Si no genera excepcion la creación del CFEDocument, entonces valida correctamente su formato*/
        /*Armar respuesta*/
        String salida = util.generarACKSobre(sobre, false);
        dataOut.setXmlData(salida);
        /*Logica*/
        respuesta.setDataout(dataOut);
        return respuesta;
    }
}
