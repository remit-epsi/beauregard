package fr.acme.beauregard_project.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class VAT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float rate;

    @OneToMany(mappedBy = "product")
    private Set<Product> products;

    {
        products = new HashSet<Product>();
    }

    public VAT() {

    }

    public VAT(String name, float rate) {
        this.name = name;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "VAT{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", products=" + products +
                '}';
    }
}