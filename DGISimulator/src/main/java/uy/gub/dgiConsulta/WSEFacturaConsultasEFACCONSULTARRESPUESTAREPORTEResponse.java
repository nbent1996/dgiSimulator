
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
 *         &lt;element name="Ackrepdiario" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "ackrepdiario"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARRESPUESTAREPORTEResponse")
public class WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTEResponse {

    @XmlElement(name = "Ackrepdiario", required = true)
    protected String ackrepdiario;

    /**
     * Gets the value of the ackrepdiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAckrepdiario() {
        return ackrepdiario;
    }

    /**
     * Sets the value of the ackrepdiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAckrepdiario(String value) {
        this.ackrepdiario = value;
    }

}
