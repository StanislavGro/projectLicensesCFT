package ru.cft.yellowrubberduck.repository;

import org.springframework.data.repository.CrudRepository;
import ru.cft.yellowrubberduck.repository.model.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
}
