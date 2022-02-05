package ru.cft.optimusgang.licenses.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import ru.cft.optimusgang.licenses.repository.model.entities.LicenseLog;

import java.util.List;

public interface LicenseLogService{

    @Scheduled(initialDelay = 60000, fixedRate = 60000)
    @Async
    void validityСheck();
}
