
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
 *         &lt;element name="Consultarespuestareporte" type="{http://dgi.gub.uy}ConsultaRespuestaReporte"/>
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
    "consultarespuestareporte"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARRESPUESTAREPORTE")
public class WSEFacturaConsultasEFACCONSULTARRESPUESTAREPORTE {

    @XmlElement(name = "Consultarespuestareporte", required = true)
    protected ConsultaRespuestaReporte consultarespuestareporte;

    /**
     * Gets the value of the consultarespuestareporte property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaRespuestaReporte }
     *     
     */
    public ConsultaRespuestaReporte getConsultarespuestareporte() {
        return consultarespuestareporte;
    }

    /**
     * Sets the value of the consultarespuestareporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaRespuestaReporte }
     *     
     */
    public void setConsultarespuestareporte(ConsultaRespuestaReporte value) {
        this.consultarespuestareporte = value;
    }

}
