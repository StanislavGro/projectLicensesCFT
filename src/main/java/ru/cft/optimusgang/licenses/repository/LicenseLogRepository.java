package ru.cft.optimusgang.licenses.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.cft.optimusgang.licenses.repository.model.entities.LicenseLog;

public interface LicenseLogRepository extends CrudRepository<LicenseLog, Long> {


    LicenseLog getAllLicenses();

}
