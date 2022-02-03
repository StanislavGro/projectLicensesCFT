package ru.cft.optimusgang.licenses.repository.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import ru.cft.optimusgang.licenses.repository.model.enums.ProductType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "licenses")
public class License implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "key")
    private String openKey;

//    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private LocalDate startDate;

//    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @Column(name = "product")
    private ProductType product;

    public License() {
    }

    public License(String openKey, LocalDate startDate, LocalDate endDate, User user, ProductType product) {
        this.openKey = openKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return id;
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

    public void setUser(User user) {
        this.user = user;
    }

    public String getOpenKey() {
        return openKey;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public User getUser() {
        return user;
    }

    public ProductType getProduct() {
        return product;
    }

}