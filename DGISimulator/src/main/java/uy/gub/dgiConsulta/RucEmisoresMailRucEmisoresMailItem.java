
package uy.gub.dgiConsulta;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RucEmisoresMail.RucEmisoresMailItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RucEmisoresMail.RucEmisoresMailItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="RUC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DENOMINACION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NOMBRE_FANTASIA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FECHA_INICIO" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="MAIL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RucEmisoresMail.RucEmisoresMailItem", propOrder = {

})
public class RucEmisoresMailRucEmisoresMailItem {

    @XmlElement(name = "RUC", required = true)
    protected String ruc;
    @XmlElement(name = "DENOMINACION", required = true)
    protected String denominacion;
    @XmlElement(name = "NOMBRE_FANTASIA", required = false)
    protected String nombrefantasia;
    @XmlElement(name = "FECHA_INICIO", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechainicio;
    @XmlElement(name = "MAIL", required = true)
    protected String mail;
    @XmlElement(name = "FECHA_FIN", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaFin;


    /**
     * Gets the value of the ruc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRUC() {
        return ruc;
    }

    /**
     * Sets the value of the ruc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRUC(String value) {
        this.ruc = value;
    }

    /**
     * Gets the value of the denominacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDENOMINACION() {
        return denominacion;
    }

    /**
     * Sets the value of the denominacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDENOMINACION(String value) {
        this.denominacion = value;
    }

    /**
     * Gets the value of the nombrefantasia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMBREFANTASIA() {
        return nombrefantasia;
    }

    /**
     * Sets the value of the nombrefantasia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMBREFANTASIA(String value) {
        this.nombrefantasia = value;
    }

    /**
     * Gets the value of the fechainicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFECHAINICIO() {
        return fechainicio;
    }

    /**
     * Sets the value of the fechainicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFECHAINICIO(XMLGregorianCalendar value) {
        this.fechainicio = value;
    }

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAIL() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAIL(String value) {
        this.mail = value;
    }

    public XMLGregorianCalendar getFECHAFIN() {
        return fechaFin;
    }

    public void setFECHAFIN(XMLGregorianCalendar fechaFin) {
        this.fechaFin = fechaFin;
    }
}
