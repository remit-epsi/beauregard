package fr.acme.beauregardproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Le champ reference ne peut être vide")
    @Size(min = 6,max = 6)
    @Column(nullable = false)
    private String reference;

    @NotEmpty(message = "Le champ label ne peut être vide")
    @Column(nullable = false)
    private String label;

    @NotEmpty(message = "Le champ description ne peut être vide")
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float priceExclTax;
    private String picture;

    @PositiveOrZero
    @Column(nullable = false)
    private int stockQuantity;

    private boolean hasBeenOrdered;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "vat_id")
    private VAT vat;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    List<ProductHasOrder> orderLines = new ArrayList<>();

    public Product() {
    }

    public Product(String reference, String label, String description, float priceExclTax, String picture, int stockQuantity, boolean hasBeenOrdered, Category category, VAT vat, Brand brand) {
        this.reference = reference;
        this.label = label;
        this.description = description;
        this.priceExclTax = priceExclTax;
        this.picture = picture;
        this.stockQuantity = stockQuantity;
        this.hasBeenOrdered = hasBeenOrdered;
        this.category = category;
        this.vat = vat;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceExclTax() {
        return priceExclTax;
    }

    public void setPriceExclTax(float price) {
        this.priceExclTax = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean isHasBeenOrdered() {
        return hasBeenOrdered;
    }

    public void setHasBeenOrdered(boolean hasBeenOrdered) {
        this.hasBeenOrdered = hasBeenOrdered;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", price=" + priceExclTax +
                ", picture='" + picture + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", hasBeenOrdered=" + hasBeenOrdered +
                ", category=" + category +
                ", vat=" + vat +
                ", brand=" + brand +
                '}';
    }
}