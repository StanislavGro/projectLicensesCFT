package ru.cft.optimusgang.licenses.repository.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "License_Logs")
public class LicenseLog implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "license_id")
//    @JsonManagedReference
    private License license;

    @Column(name = "license_status")
    private LicenseStatus licenseStatus;

    public LicenseLog() {
    }

    public LicenseLog(License license, LicenseStatus licenseStatus) {
        this.license = license;
        this.licenseStatus = licenseStatus;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public void setLicenseStatus(LicenseStatus licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public License getLicense() {
        return license;
    }

    public LicenseStatus getLicenseStatus() {
        return licenseStatus;
    }
}
