package ru.cft.optimusgang.licenses.service;

import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus;

import java.util.List;

public interface LicenseService {

    //GET /license/new
    public License getNewLicense(Long userId);

    //GET /license/{licenseId}
    public License getLicenseByUserId(Long licenseId, Long userId);

    //GET /license/list
    public List<License> getAllLicensesByCompanyId(Long companyId);

    //POST /license/check
    public LicenseStatus checkLicense(License license);
}
