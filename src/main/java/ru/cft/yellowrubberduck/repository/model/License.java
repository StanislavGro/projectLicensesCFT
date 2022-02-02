package ru.cft.yellowrubberduck.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.cft.yellowrubberduck.repository.model.enums.ProductType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "License")
public class License implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "key")
    private String openKey;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private String user;

    @Column(name = "product")
    private ProductType product;

    public License() {
    }

    public License(String openKey, LocalDate startDate, LocalDate endDate, String user, ProductType product) {
        this.openKey = openKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.product = product;
    }

    public void setOpenKey(String openKey) {
        this.openKey = openKey;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOpenKey() {
        return openKey;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getStartDate() {
        return startDate;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getEndDate() {
        return endDate;
    }

    public String getUser() {
        return user;
    }

    public ProductType getProduct() {
        return product;
    }

}
