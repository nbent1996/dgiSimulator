
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
 *         &lt;element name="Cfeid" type="{http://dgi.gub.uy}CFEId"/>
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
    "cfeid"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARESTADOCFE")
public class WSEFacturaConsultasEFACCONSULTARESTADOCFE {

    @XmlElement(name = "Cfeid", required = true)
    protected CFEId cfeid;

    /**
     * Gets the value of the cfeid property.
     * 
     * @return
     *     possible object is
     *     {@link CFEId }
     *     
     */
    public CFEId getCfeid() {
        return cfeid;
    }

    /**
     * Sets the value of the cfeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFEId }
     *     
     */
    public void setCfeid(CFEId value) {
        this.cfeid = value;
    }

}
