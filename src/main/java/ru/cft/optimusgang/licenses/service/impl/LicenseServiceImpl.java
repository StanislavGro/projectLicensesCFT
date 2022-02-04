package ru.cft.optimusgang.licenses.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.optimusgang.licenses.repository.LicenseRepository;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus;
import ru.cft.optimusgang.licenses.service.LicenseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;

    @Autowired
    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public License getNewLicense() {
        License newLicense = new License();
        licenseRepository.save(newLicense);
        return newLicense;
    }

    @Override
    public License getLicenseByUserId(Long licenseId, Long userId) {
        return licenseRepository.getLicenseByUserId(licenseId, userId);
    }

    @Override
    public List<License> getAllLicensesByCompanyId(Long companyId) {
        return licenseRepository.getAllByCompanyId(companyId);
    }

    @Override
    public LicenseStatus checkLicense(License license) {

        //в теле запроса файл лицензии;
        //        возвращает 200 OK, если лицензия
        //        корректна и актуальна, иначе код
        //        418 с типом ошибки в теле ответа:
        //        LICENSE_NOT_EXIST,
        //                LICENSE_EXPIRED
        Optional<License> licenseToCheck = licenseRepository.findById(license.getId());
        if (!licenseToCheck.isPresent()) {
            return LicenseStatus.LICENSE_NOT_EXIST;
        }
        else if (licenseToCheck.get().getEndDate().isBefore(LocalDate.now())){
            return LicenseStatus.LICENSE_EXPIRED;
        }
        else {
            ///алгоритм проверки лицензии
            //return LicenseStatus.LICENSE_INVALID;
        }
        return LicenseStatus.LICENSE_VALID;
    }
}
