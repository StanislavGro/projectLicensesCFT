package ru.cft.optimusgang.licenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.service.LicenseService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LicenseLogController {

    private final LicenseService licenseService;

    @Autowired
    public LicenseLogController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/license/all")
    public List<License> getAllUsers(){
        return licenseService.getAllLicenses();
    }

}
