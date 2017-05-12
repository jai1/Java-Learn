package org.yahoo.temp;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryElement {

    private int order;
    private String id;
    private String displayName;
    private String property;
    private List<SummaryElement> subElements;
    private int maxlines;

    @XmlAttribute
    private String type;

    @Override
    public String toString() {
        return "SummaryElement [order=" + order + ", id=" + id + ", displayName=" + displayName + ", property="
                + property + ", subElements=" + subElements + ", maxlines=" + maxlines + ", type=" + type + "]";
    }
}