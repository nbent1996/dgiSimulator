package uy.gub.dgiRecepcion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2022-12-15T14:13:42.764-03:00
 * Generated source version: 3.5.3
 *
 */
@WebService(targetNamespace = "http://dgi.gub.uy", name = "WS_eFacturaSoapPort")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface WSEFacturaSoapPort {

    @WebMethod(operationName = "EFACRECEPCIONREPORTE", action = "http://dgi.gub.uyaction/AWS_EFACTURA.EFACRECEPCIONREPORTE")
    @WebResult(name = "WS_eFactura.EFACRECEPCIONREPORTEResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaEFACRECEPCIONREPORTEResponse efacrecepcionreporte(

        @WebParam(partName = "parameters", name = "WS_eFactura.EFACRECEPCIONREPORTE", targetNamespace = "http://dgi.gub.uy")
        WSEFacturaEFACRECEPCIONREPORTE parameters
    );

    @WebMethod(operationName = "EFACCONSULTARESTADOENVIO", action = "http://dgi.gub.uyaction/AWS_EFACTURA.EFACCONSULTARESTADOENVIO")
    @WebResult(name = "WS_eFactura.EFACCONSULTARESTADOENVIOResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaEFACCONSULTARESTADOENVIOResponse efacconsultarestadoenvio(

        @WebParam(partName = "parameters", name = "WS_eFactura.EFACCONSULTARESTADOENVIO", targetNamespace = "http://dgi.gub.uy")
        WSEFacturaEFACCONSULTARESTADOENVIO parameters
    );

    @WebMethod(operationName = "EFACRECEPCIONSOBRE", action = "http://dgi.gub.uyaction/AWS_EFACTURA.EFACRECEPCIONSOBRE")
    @WebResult(name = "WS_eFactura.EFACRECEPCIONSOBREResponse", targetNamespace = "http://dgi.gub.uy", partName = "parameters")
    public WSEFacturaEFACRECEPCIONSOBREResponse efacrecepcionsobre(

        @WebParam(partName = "parameters", name = "WS_eFactura.EFACRECEPCIONSOBRE", targetNamespace = "http://dgi.gub.uy")
        WSEFacturaEFACRECEPCIONSOBRE parameters
    );
}
