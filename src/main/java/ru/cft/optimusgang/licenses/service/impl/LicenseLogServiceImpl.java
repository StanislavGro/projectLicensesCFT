package ru.cft.optimusgang.licenses.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.cft.optimusgang.licenses.service.LicenseLogService;

import java.util.logging.Logger;

@Service
public class LicenseLogServiceImpl implements LicenseLogService {

    static final Logger licenseLogLogger = Logger.getLogger(LicenseServiceImpl.class.getName());

    @Scheduled(initialDelayString = "PT01", fixedDelayString = "PT01")
    @Async
    public void validityСheck() {

        licenseLogLogger.info("I'm checking licenses");

    }

}
