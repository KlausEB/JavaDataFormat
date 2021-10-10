package com.epam.dataFormats.generatedClasses;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "gem"
})
@XmlRootElement(name = "gems")
public class Gems {

    @XmlElement(required = true)
    protected List<Gem> gem;

    public List<Gem> getGem() {
        if (gem == null) {
            gem = new ArrayList<Gem>();
        }
        return this.gem;
    }

}
