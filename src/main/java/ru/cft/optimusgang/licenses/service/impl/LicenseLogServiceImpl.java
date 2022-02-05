package ru.cft.optimusgang.licenses.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.cft.optimusgang.licenses.repository.LicenseLogRepository;
import ru.cft.optimusgang.licenses.repository.LicenseRepository;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.service.LicenseLogService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;

@Service
public class LicenseLogServiceImpl implements LicenseLogService {

    private final LicenseRepository licenseRepository;
    private final LicenseLogRepository licenseLogRepository;

    static final Logger licenseLogLogger = Logger.getLogger(LicenseServiceImpl.class.getName());

    @Autowired
    public LicenseLogServiceImpl(LicenseRepository licenseRepository, LicenseLogRepository licenseLogRepository) {
        this.licenseLogRepository = licenseLogRepository;
        this.licenseRepository = licenseRepository;
    }

    @Override
    @Scheduled(initialDelay = 3000, fixedRate = 3000)
    @Async
    public void validityСheck() {

        List<License> licenseList = (List<License>) licenseRepository.findAll();

        for(License license: licenseList){

            Period period = Period.between(license.getEndDate(), license.getStartDate());
            int diff = Math.abs(period.getDays());

            if(diff <= 7){

                licenseLogLogger.info("I'm added into license_log table note" + license);

            }
            else {
                System.out.println("I'm NOT added into license_log table note" + license);
            }
        }

        licenseLogLogger.info("I'm working");

    }

}
