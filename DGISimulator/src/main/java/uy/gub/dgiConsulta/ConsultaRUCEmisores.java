
package uy.gub.dgiConsulta;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ConsultaRUCEmisores complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultaRUCEmisores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Filtro_eFacDocNro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Filtro_eFacDenominacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Filtro_eFacRUCEmisorAudFchHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaRUCEmisores", propOrder = {

})
public class ConsultaRUCEmisores {

    @XmlElement(name = "Filtro_eFacDocNro", required = true)
    protected String filtroEFacDocNro;
    @XmlElement(name = "Filtro_eFacDenominacion", required = true)
    protected String filtroEFacDenominacion;
    @XmlElement(name = "Filtro_eFacRUCEmisorAudFchHora", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar filtroEFacRUCEmisorAudFchHora;

    /**
     * Gets the value of the filtroEFacDocNro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiltroEFacDocNro() {
        return filtroEFacDocNro;
    }

    /**
     * Sets the value of the filtroEFacDocNro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiltroEFacDocNro(String value) {
        this.filtroEFacDocNro = value;
    }

    /**
     * Gets the value of the filtroEFacDenominacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiltroEFacDenominacion() {
        return filtroEFacDenominacion;
    }

    /**
     * Sets the value of the filtroEFacDenominacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiltroEFacDenominacion(String value) {
        this.filtroEFacDenominacion = value;
    }

    /**
     * Gets the value of the filtroEFacRUCEmisorAudFchHora property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFiltroEFacRUCEmisorAudFchHora() {
        return filtroEFacRUCEmisorAudFchHora;
    }

    /**
     * Sets the value of the filtroEFacRUCEmisorAudFchHora property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFiltroEFacRUCEmisorAudFchHora(XMLGregorianCalendar value) {
        this.filtroEFacRUCEmisorAudFchHora = value;
    }

}
