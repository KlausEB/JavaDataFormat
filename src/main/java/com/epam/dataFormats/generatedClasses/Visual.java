package com.epam.dataFormats.generatedClasses;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Visual", propOrder = {
        "color",
        "transparency",
        "cuttingMethod"
})
public class Visual {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Color color;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected int transparency;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CuttingMethod cuttingMethod;

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color value) {
        this.color = value;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int value) {
        this.transparency = value;
    }

    public CuttingMethod getCuttingMethod() {
        return cuttingMethod;
    }

    public void setCuttingMethod(CuttingMethod value) {
        this.cuttingMethod = value;
    }
}
