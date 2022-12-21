
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
 *         &lt;element name="Consultaenviosreporte" type="{http://dgi.gub.uy}ConsultaEnviosReporte"/>
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
    "consultaenviosreporte"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSREPORTE")
public class WSEFacturaConsultasEFACCONSULTARENVIOSREPORTE {

    @XmlElement(name = "Consultaenviosreporte", required = true)
    protected ConsultaEnviosReporte consultaenviosreporte;

    /**
     * Gets the value of the consultaenviosreporte property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaEnviosReporte }
     *     
     */
    public ConsultaEnviosReporte getConsultaenviosreporte() {
        return consultaenviosreporte;
    }

    /**
     * Sets the value of the consultaenviosreporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaEnviosReporte }
     *     
     */
    public void setConsultaenviosreporte(ConsultaEnviosReporte value) {
        this.consultaenviosreporte = value;
    }

}
