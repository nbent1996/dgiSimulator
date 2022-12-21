
package uy.gub.dgiConsulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfDatosSobre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDatosSobre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatosSobre" type="{http://dgi.gub.uy}DatosSobre" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDatosSobre", propOrder = {
    "datosSobre"
})
public class ArrayOfDatosSobre {

    @XmlElement(name = "DatosSobre")
    protected List<DatosSobre> datosSobre;

    /**
     * Gets the value of the datosSobre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datosSobre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatosSobre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatosSobre }
     * 
     * 
     */
    public List<DatosSobre> getDatosSobre() {
        if (datosSobre == null) {
            datosSobre = new ArrayList<DatosSobre>();
        }
        return this.datosSobre;
    }

    public void setDatosSobre(List<DatosSobre> datosSobre) {
        this.datosSobre = datosSobre;
    }
}
