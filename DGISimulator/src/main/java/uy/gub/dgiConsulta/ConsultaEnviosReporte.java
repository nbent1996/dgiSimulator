
package uy.gub.dgiConsulta;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ConsultaEnviosReporte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultaEnviosReporte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="FechaResumen" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Secuencia" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="IdEmisor" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaEnviosReporte", propOrder = {

})
public class ConsultaEnviosReporte {

    @XmlElement(name = "FechaResumen", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaResumen;
    @XmlElement(name = "Secuencia")
    protected byte secuencia;
    @XmlElement(name = "IdEmisor")
    protected long idEmisor;

    /**
     * Gets the value of the fechaResumen property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaResumen() {
        return fechaResumen;
    }

    /**
     * Sets the value of the fechaResumen property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaResumen(XMLGregorianCalendar value) {
        this.fechaResumen = value;
    }

    /**
     * Gets the value of the secuencia property.
     * 
     */
    public byte getSecuencia() {
        return secuencia;
    }

    /**
     * Sets the value of the secuencia property.
     * 
     */
    public void setSecuencia(byte value) {
        this.secuencia = value;
    }

    /**
     * Gets the value of the idEmisor property.
     * 
     */
    public long getIdEmisor() {
        return idEmisor;
    }

    /**
     * Sets the value of the idEmisor property.
     * 
     */
    public void setIdEmisor(long value) {
        this.idEmisor = value;
    }

}
