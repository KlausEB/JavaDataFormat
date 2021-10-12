package com.epam.dataFormats.generatedClasses;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gem", propOrder = {
        "name",
        "preciousness",
        "origin",
        "visual"
})
public class Gem {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Preciousness preciousness;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(required = true)
    protected Visual visual;
    @XmlAttribute(name = "value", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected int value;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Preciousness getPreciousness() {
        return this.preciousness;
    }

    public void setPreciousness(Preciousness value) {
        this.preciousness = value;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String value) {
        this.origin = value;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual value) {
        this.visual = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", origin='" + origin + '\'' +
                ", visual=" + visual +
                ", value=" + value +
                '}';
    }
}
