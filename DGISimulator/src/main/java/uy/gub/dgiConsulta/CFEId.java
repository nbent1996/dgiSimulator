
package uy.gub.dgiConsulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFEId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFEId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="TipoCFE" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Serie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFEId", propOrder = {

})
public class CFEId {

    @XmlElement(name = "TipoCFE")
    protected short tipoCFE;
    @XmlElement(name = "Serie", required = true)
    protected String serie;
    @XmlElement(name = "Nro")
    protected int nro;

    /**
     * Gets the value of the tipoCFE property.
     * 
     */
    public short getTipoCFE() {
        return tipoCFE;
    }

    /**
     * Sets the value of the tipoCFE property.
     * 
     */
    public void setTipoCFE(short value) {
        this.tipoCFE = value;
    }

    /**
     * Gets the value of the serie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the value of the serie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Gets the value of the nro property.
     * 
     */
    public int getNro() {
        return nro;
    }

    /**
     * Sets the value of the nro property.
     * 
     */
    public void setNro(int value) {
        this.nro = value;
    }

}
