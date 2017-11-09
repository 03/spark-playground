package au.com.sensis.bigdata.csv;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Created by orp on 18/07/17.
 */
@JsonPropertyOrder({"id", "name", "created", "quantity"})
public class Product implements Serializable {

    private String id;
    private String name;
    private String created;
    private Integer quantity;

    public Product() {
    }

    public Product(String id, String name, String created, Integer quantity) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.quantity = quantity;
    }

    public Product(String id, String name, String created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
