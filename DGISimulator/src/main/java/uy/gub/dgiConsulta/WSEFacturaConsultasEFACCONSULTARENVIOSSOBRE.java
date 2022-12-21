
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
 *         &lt;element name="Consultaenviossobre" type="{http://dgi.gub.uy}ConsultaEnviosSobre"/>
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
    "consultaenviossobre"
})
@XmlRootElement(name = "WS_eFactura_Consultas.EFACCONSULTARENVIOSSOBRE")
public class WSEFacturaConsultasEFACCONSULTARENVIOSSOBRE {

    @XmlElement(name = "Consultaenviossobre", required = true)
    protected ConsultaEnviosSobre consultaenviossobre;

    /**
     * Gets the value of the consultaenviossobre property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaEnviosSobre }
     *     
     */
    public ConsultaEnviosSobre getConsultaenviossobre() {
        return consultaenviossobre;
    }

    /**
     * Sets the value of the consultaenviossobre property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaEnviosSobre }
     *     
     */
    public void setConsultaenviossobre(ConsultaEnviosSobre value) {
        this.consultaenviossobre = value;
    }

}
