
package uy.gub.dgiRecepcion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Datain" type="{http://dgi.gub.uy}Data"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datain"
})
@XmlRootElement(name = "WS_eFactura.EFACCONSULTARESTADOENVIO")
public class WSEFacturaEFACCONSULTARESTADOENVIO {

    @XmlElement(name = "Datain", required = true)
    protected Data datain;

    /**
     * Obtiene el valor de la propiedad datain.
     * 
     * @return
     *     possible object is
     *     {@link Data }
     *     
     */
    public Data getDatain() {
        return datain;
    }

    /**
     * Define el valor de la propiedad datain.
     * 
     * @param value
     *     allowed object is
     *     {@link Data }
     *     
     */
    public void setDatain(Data value) {
        this.datain = value;
    }

}
