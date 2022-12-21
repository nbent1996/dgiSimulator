
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
 *         &lt;element name="Ackconsultacferecibidos" type="{http://dgi.gub.uy}ACKConsultaCFERecibidos"/>
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
    "ackconsultacferecibidos"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARCFERECIBIDOSResponse")
public class WSEFacturaConsultasEFACCONSULTARCFERECIBIDOSResponse {

    @XmlElement(name = "Ackconsultacferecibidos", required = true)
    protected ACKConsultaCFERecibidos ackconsultacferecibidos;

    /**
     * Gets the value of the ackconsultacferecibidos property.
     * 
     * @return
     *     possible object is
     *     {@link ACKConsultaCFERecibidos }
     *     
     */
    public ACKConsultaCFERecibidos getAckconsultacferecibidos() {
        return ackconsultacferecibidos;
    }

    /**
     * Sets the value of the ackconsultacferecibidos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ACKConsultaCFERecibidos }
     *     
     */
    public void setAckconsultacferecibidos(ACKConsultaCFERecibidos value) {
        this.ackconsultacferecibidos = value;
    }

}
