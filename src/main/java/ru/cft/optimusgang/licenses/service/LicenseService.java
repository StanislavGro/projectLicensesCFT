package ru.cft.optimusgang.licenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.cft.optimusgang.licenses.repository.LicenseRepository;
import ru.cft.optimusgang.licenses.repository.SampleRepository;
import ru.cft.optimusgang.licenses.repository.model.SampleEntity;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus;

import java.util.List;

public interface LicenseService {

    //GET /license/new
    public License getNewLicense();

    //GET /license/{licenseId}
    public License getLicenseByUserId();

    //GET /license/list
    public List<License> getAllLicensesByCompanyId();

    //POST /license/check
    public LicenseStatus checkLicense();
}
