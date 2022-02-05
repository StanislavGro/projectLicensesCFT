package ru.cft.optimusgang.licenses.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cft.optimusgang.licenses.repository.model.entities.License;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

    @Query("SELECT license FROM License license WHERE license.id = :licenseId" +
            " AND license.user.userId = :userId " +
            "ORDER BY license.startDate DESC")
   License getLicenseByUserId(@Param("licenseId")Long licenseId, @Param("userId")Long userId);

    @Query("SELECT license FROM License license WHERE license.user.userId = :companyId AND license.user.userType = '1'")
    List<License> getAllByCompanyId(@Param("companyId")Long companyId);

}
