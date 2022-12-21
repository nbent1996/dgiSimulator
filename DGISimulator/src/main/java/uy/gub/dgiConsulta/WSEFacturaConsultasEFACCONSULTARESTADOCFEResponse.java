
package uy.gub.dgiConsulta;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ackconsultaestadocfe" type="{http://dgi.gub.uy}ACKConsultaEstadoCFE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ackconsultaestadocfe"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARESTADOCFEResponse")
public class WSEFacturaConsultasEFACCONSULTARESTADOCFEResponse {

    @XmlElement(name = "Ackconsultaestadocfe", required = true)
    protected ACKConsultaEstadoCFE ackconsultaestadocfe;

    /**
     * Gets the value of the ackconsultaestadocfe property.
     * 
     * @return
     *     possible object is
     *     {@link ACKConsultaEstadoCFE }
     *     
     */
    public ACKConsultaEstadoCFE getAckconsultaestadocfe() {
        return ackconsultaestadocfe;
    }

    /**
     * Sets the value of the ackconsultaestadocfe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ACKConsultaEstadoCFE }
     *     
     */
    public void setAckconsultaestadocfe(ACKConsultaEstadoCFE value) {
        this.ackconsultaestadocfe = value;
    }

}
