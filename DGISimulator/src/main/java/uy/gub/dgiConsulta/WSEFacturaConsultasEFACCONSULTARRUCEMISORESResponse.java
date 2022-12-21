
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
 *         &lt;element name="Rucemisoresmail" type="{http://dgi.gub.uy}RucEmisoresMail"/>
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
    "rucemisoresmail"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARRUCEMISORESResponse")
public class WSEFacturaConsultasEFACCONSULTARRUCEMISORESResponse {

    @XmlElement(name = "Rucemisoresmail", required = true)
    protected RucEmisoresMail rucemisoresmail;

    /**
     * Gets the value of the rucemisoresmail property.
     * 
     * @return
     *     possible object is
     *     {@link RucEmisoresMail }
     *     
     */
    public RucEmisoresMail getRucemisoresmail() {
        return rucemisoresmail;
    }

    /**
     * Sets the value of the rucemisoresmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link RucEmisoresMail }
     *     
     */
    public void setRucemisoresmail(RucEmisoresMail value) {
        this.rucemisoresmail = value;
    }

}
