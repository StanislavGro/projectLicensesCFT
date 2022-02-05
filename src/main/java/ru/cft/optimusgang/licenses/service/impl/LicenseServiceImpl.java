package ru.cft.optimusgang.licenses.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.optimusgang.licenses.repository.LicenseRepository;
import ru.cft.optimusgang.licenses.repository.UserRepository;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.repository.model.entities.UserEntity;
import ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus;
import ru.cft.optimusgang.licenses.repository.model.enums.ProductType;
import ru.cft.optimusgang.licenses.service.LicenseService;

import java.time.LocalDate;
import java.util.*;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;
    private final UserRepository userRepository;

    @Autowired
    public LicenseServiceImpl(LicenseRepository licenseRepository, UserRepository userRepository) {
        this.licenseRepository = licenseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public License getNewLicense(Long userId) {
        License newLicense = new License();
        UserEntity user = userRepository.findById(userId).get();
        newLicense.setUser(user);

        LocalDate startDate = LocalDate.now();
        int maxPeriodDates = 31;
        LocalDate endDate = startDate.plusDays(new Random().nextInt((int) maxPeriodDates + 1));
        newLicense.setStartDate(startDate);
        newLicense.setEndDate(endDate);

        newLicense.setProduct(ProductType.getRandomProduct());

        UUID randomUUID = UUID.randomUUID();
        String randomString = randomUUID.toString().replaceAll("-", "");

        newLicense.setOpenKey(randomString);
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

        Optional<License> licenseFromDb = licenseRepository.findById(license.getId());
        if (!licenseFromDb.isPresent()) {
            return LicenseStatus.LICENSE_NOT_EXIST;
        }
        else if(!licenseFromDb.get().equals(license)) {
            return LicenseStatus.LICENSE_INVALID;
        }
        if (licenseFromDb.get().getEndDate().isBefore(LocalDate.now())){
                return LicenseStatus.LICENSE_EXPIRED;
            }
        else {
            ///алгоритм проверки лицензии
            String openKey = licenseFromDb.get().getOpenKey();
            char lastChar = openKey.charAt(openKey.length() - 1);
            if(Character.isAlphabetic(lastChar)) {
                return LicenseStatus.LICENSE_VALID;
            }
        }
        return LicenseStatus.LICENSE_INVALID;
    }

    @Override
    public List<License> getAllLicenses() {
        return (List<License>) licenseRepository.findAll();
    }
}
