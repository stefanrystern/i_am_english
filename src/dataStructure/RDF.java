package dataStructure;

/**
 * Created by Yevhenii on 02.11.2015.
 */
public class RDF {
    private String entity;
    private String attribute;
    private String value;

    public RDF(String entity, String attribute, String value) {
        this.entity = entity;
        this.attribute = attribute;
        this.value = value;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEntity() {
        return entity;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RDF{" +
                "entity='" + entity + '\'' +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
