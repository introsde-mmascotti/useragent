
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import healthprofile.storage.service.Person;


/**
 * <p>Java-Klasse f�r savePersonResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="savePersonResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.storage.healthprofile/}person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonResponse", propOrder = {
    "_return"
})
public class SavePersonResponse {

    @XmlElement(name = "return")
    protected Person _return;

    /**
     * Ruft den Wert der return-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getReturn() {
        return _return;
    }

    /**
     * Legt den Wert der return-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setReturn(Person value) {
        this._return = value;
    }

}
