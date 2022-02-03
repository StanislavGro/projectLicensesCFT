package ru.cft.optimusgang.licenses.repository;

import org.springframework.data.repository.CrudRepository;
import ru.cft.optimusgang.licenses.repository.model.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
}
