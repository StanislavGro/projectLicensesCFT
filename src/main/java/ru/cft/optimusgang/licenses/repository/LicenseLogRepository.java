package ru.cft.optimusgang.licenses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cft.optimusgang.licenses.repository.model.entities.LicenseLog;

import java.util.List;

@Repository
public interface LicenseLogRepository extends CrudRepository<LicenseLog, Long> {
}