package ru.cft.optimusgang.licenses.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import ru.cft.optimusgang.licenses.repository.model.entities.LicenseLog;

import java.util.List;

public interface LicenseLogService{

    @Scheduled(initialDelay = 3000, fixedRate = 3000)
    @Async
    void validityСheck();
}
