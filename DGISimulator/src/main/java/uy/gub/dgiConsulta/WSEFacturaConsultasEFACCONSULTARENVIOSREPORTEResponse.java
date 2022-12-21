
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
 *         &lt;element name="Ackconsultaenviosreporte" type="{http://dgi.gub.uy}ACKConsultaEnviosReporte"/>
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
    "ackconsultaenviosreporte"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSREPORTEResponse")
public class WSEFacturaConsultasEFACCONSULTARENVIOSREPORTEResponse {

    @XmlElement(name = "Ackconsultaenviosreporte", required = true)
    protected ACKConsultaEnviosReporte ackconsultaenviosreporte;

    /**
     * Gets the value of the ackconsultaenviosreporte property.
     * 
     * @return
     *     possible object is
     *     {@link ACKConsultaEnviosReporte }
     *     
     */
    public ACKConsultaEnviosReporte getAckconsultaenviosreporte() {
        return ackconsultaenviosreporte;
    }

    /**
     * Sets the value of the ackconsultaenviosreporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link ACKConsultaEnviosReporte }
     *     
     */
    public void setAckconsultaenviosreporte(ACKConsultaEnviosReporte value) {
        this.ackconsultaenviosreporte = value;
    }

}
