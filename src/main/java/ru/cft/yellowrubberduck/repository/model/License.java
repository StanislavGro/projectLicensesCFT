package ru.cft.yellowrubberduck.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.cft.yellowrubberduck.repository.model.enums.ProductType;
import ru.cft.yellowrubberduck.repository.model.enums.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "License")
public class License implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "license_id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "user_type")
    private UserType userType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user")
    @JsonManagedReference
    private String user;

    @Column(name = "product")
    private ProductType product;

    public License() {}

    public License(LocalDate start_date, LocalDate end_date, UserType licenseType, String ownerID, ProductType product) {
        this.startDate = start_date;
        this.endDate = end_date;
        this.userType = licenseType;
        this.user = ownerID;
        this.product = product;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setOwnerID(String user) {
        this.user = user;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getStartDate() {
        return startDate;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getEndDate() {
        return endDate;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUser() {
        return user;
    }

    public ProductType getProduct() {
        return product;
    }

}
