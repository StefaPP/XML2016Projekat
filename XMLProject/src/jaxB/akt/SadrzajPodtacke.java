//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.03 at 06:21:59 PM CEST 
//


package jaxB.akt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;


/**
 * <p>Java class for SadrzajPodtacke complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SadrzajPodtacke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Alineja" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Status">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="status_izmene" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ref">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="id_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="oznaka" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="opis" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;anyAttribute/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.parlament.gov.rs/propisi}ref" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SadrzajPodtacke", propOrder = {
    "content"
})
public class SadrzajPodtacke {

    @XmlElementRefs({
        @XmlElementRef(name = "Alineja", namespace = "http://www.parlament.gov.rs/propisi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ref", namespace = "http://www.parlament.gov.rs/propisi", type = jaxB.akt.Ref.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SadrzajPodtacke.Alineja }{@code >}
     * {@link jaxB.akt.Ref }
     * {@link String }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }


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
     *         &lt;element name="Sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Status">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="status_izmene" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ref">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="id_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="oznaka" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="opis" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;anyAttribute/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sadrzaj",
        "status"
    })
    public static class Alineja {

        @XmlElement(name = "Sadrzaj", required = true)
        protected String sadrzaj;
        @XmlElement(name = "Status", required = true)
        protected SadrzajPodtacke.Alineja.Status status;
        @XmlAttribute(name = "oznaka")
        protected String oznaka;
        @XmlAttribute(name = "naziv")
        protected String naziv;
        @XmlAttribute(name = "opis")
        protected String opis;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the sadrzaj property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSadrzaj() {
            return sadrzaj;
        }

        /**
         * Sets the value of the sadrzaj property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSadrzaj(String value) {
            this.sadrzaj = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link SadrzajPodtacke.Alineja.Status }
         *     
         */
        public SadrzajPodtacke.Alineja.Status getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link SadrzajPodtacke.Alineja.Status }
         *     
         */
        public void setStatus(SadrzajPodtacke.Alineja.Status value) {
            this.status = value;
        }

        /**
         * Gets the value of the oznaka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOznaka() {
            return oznaka;
        }

        /**
         * Sets the value of the oznaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOznaka(String value) {
            this.oznaka = value;
        }

        /**
         * Gets the value of the naziv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

        /**
         * Gets the value of the opis property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpis() {
            return opis;
        }

        /**
         * Sets the value of the opis property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpis(String value) {
            this.opis = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="status_izmene" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ref">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="id_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class Status {

            @XmlElement(name = "status_izmene", required = true)
            protected String statusIzmene;
            @XmlElement(required = true)
            protected SadrzajPodtacke.Alineja.Status.Ref ref;

            /**
             * Gets the value of the statusIzmene property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatusIzmene() {
                return statusIzmene;
            }

            /**
             * Sets the value of the statusIzmene property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatusIzmene(String value) {
                this.statusIzmene = value;
            }

            /**
             * Gets the value of the ref property.
             * 
             * @return
             *     possible object is
             *     {@link SadrzajPodtacke.Alineja.Status.Ref }
             *     
             */
            public SadrzajPodtacke.Alineja.Status.Ref getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             * 
             * @param value
             *     allowed object is
             *     {@link SadrzajPodtacke.Alineja.Status.Ref }
             *     
             */
            public void setRef(SadrzajPodtacke.Alineja.Status.Ref value) {
                this.ref = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="id_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Ref {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "id_ref")
                protected String idRef;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the idRef property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIdRef() {
                    return idRef;
                }

                /**
                 * Sets the value of the idRef property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIdRef(String value) {
                    this.idRef = value;
                }

            }

        }

    }

}
