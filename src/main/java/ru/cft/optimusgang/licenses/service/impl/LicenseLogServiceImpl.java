package ru.cft.optimusgang.licenses.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.cft.optimusgang.licenses.repository.LicenseLogRepository;
import ru.cft.optimusgang.licenses.repository.LicenseRepository;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.repository.model.entities.LicenseLog;
import ru.cft.optimusgang.licenses.service.LicenseLogService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus.LICENSE_EXPIRED;
import static ru.cft.optimusgang.licenses.repository.model.enums.LicenseStatus.LICENSE_VALID;

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
        List<LicenseLog> licenseLogs = new LinkedList<>();

        for(License license: licenseList){

            Period period = Period.between(license.getEndDate(), LocalDate.now());
            int diff = Math.abs(period.getDays());

            if(diff > 0 && diff <= 7){

                licenseLogLogger.info("I'm added into license_log table note" + license);
                licenseLogs.add(new LicenseLog(license, LICENSE_VALID));

            }
            else if(diff <= 0){

                licenseLogLogger.info("The license of " + license + " is already EXPIRED" );
                licenseLogs.add(new LicenseLog(license, LICENSE_EXPIRED));

            }
//            else {
//
//                System.out.println("I'm NOT added into license_log table note" + license);
//            }
        }
        licenseLogRepository.saveAll(licenseLogs);

//        licenseLogLogger.info("I'm working");

    }

}
