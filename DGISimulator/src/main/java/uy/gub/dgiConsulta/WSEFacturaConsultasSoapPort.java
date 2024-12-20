

package uy.gub.dgiConsulta;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-04/11/2011 03:11 PM(mockbuild)-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "WS_eFactura_ConsultasSoapPort", targetNamespace = "http://dgi.gub.uy")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSEFacturaConsultasSoapPort {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARCFERECIBIDOSResponse
     */
    @WebMethod(operationName = "EFACCONSULTARCFERECIBIDOS", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARCFERECIBIDOS")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARCFERECIBIDOSResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARCFERECIBIDOSResponse efacconsultarcferecibidos(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARCFERECIBIDOS", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
                WSEFacturaConsultasEFACCONSULTARCFERECIBIDOS parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARENVIOSCFEResponse
     */
    @WebMethod(operationName = "EFACCONSULTARENVIOSCFE", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARENVIOSCFE")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSCFEResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARENVIOSCFEResponse efacconsultarenvioscfe(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSCFE", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
                WSEFacturaConsultasEFACCONSULTARENVIOSCFE parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARENVIOSREPORTEResponse
     */
    @WebMethod(operationName = "EFACCONSULTARENVIOSREPORTE", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARENVIOSREPORTE")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSREPORTEResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARENVIOSREPORTEResponse efacconsultarenviosreporte(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSREPORTE", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
        WSEFacturaConsultasEFACCONSULTARENVIOSREPORTE parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARENVIOSSOBREResponse
     */
    @WebMethod(operationName = "EFACCONSULTARENVIOSSOBRE", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARENVIOSSOBRE")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSSOBREResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARENVIOSSOBREResponse efacconsultarenviossobre(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSSOBRE", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
        WSEFacturaConsultasEFACCONSULTARENVIOSSOBRE parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARESTADOCFEResponse
     */
    @WebMethod(operationName = "EFACCONSULTARESTADOCFE", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARESTADOCFE")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARESTADOCFEResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARESTADOCFEResponse efacconsultarestadocfe(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARESTADOCFE", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
        WSEFacturaConsultasEFACCONSULTARESTADOCFE parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTEResponse
     */
    @WebMethod(operationName = "EFACCONSULTARRESPUESTAREPORTE", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARRESPUESTAREPORTE")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARRESPUESTAREPORTEResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTEResponse efacconsultarrespuestareporte(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARRESPUESTAREPORTE", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
        WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTE parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.antel.factelect.wsDGIConsulta.WSEFacturaConsultasEFACCONSULTARRUCEMISORESResponse
     */
    @WebMethod(operationName = "EFACCONSULTARRUCEMISORES", action = "http://dgi.gub.uyaction/AWS_EFACTURA_CONSULTAS.EFACCONSULTARRUCEMISORES")
    @WebResult(name = "WS_eFactura_Consultas.EFACCONSULTARRUCEMISORESResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaConsultasEFACCONSULTARRUCEMISORESResponse efacconsultarrucemisores(
        @WebParam(name = "WS_eFactura_Consultas.EFACCONSULTARRUCEMISORES", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
                WSEFacturaConsultasEFACCONSULTARRUCEMISORES parameters);

}
