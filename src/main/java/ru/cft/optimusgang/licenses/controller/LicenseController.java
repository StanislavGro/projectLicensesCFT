package ru.cft.optimusgang.licenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.optimusgang.licenses.repository.model.entities.License;
import ru.cft.optimusgang.licenses.repository.model.entities.User;
import ru.cft.optimusgang.licenses.service.LicenseService;
import ru.cft.optimusgang.licenses.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class LicenseController {
    private final LicenseService licenseService;

    @Autowired
    public LicenseController(LicenseService licenseService){
        this.licenseService= licenseService;
    }

    /*GET /license/new в теле запроса userId
    или companyId; возвращает файл
    новой сгенерированной лицензии.*/

    @GetMapping("/license/new/{userId}")
    public License getNewLicense(@PathVariable long userId){
        return licenseService.getNewLicense(userId);
    }


  /*  GET /license/{licenseId} в теле запроса userId
    или companyId; возвращает файл
    уже выданной лицензии, если
    userId или companyId для данной
    лицензии совпадает. Пользователь
    может иметь одну актуальную
    лицензию, кампания - множество.
    При запросе для компании
    возвращать последнюю выданную
            лицензию*/
   /* @GetMapping("/license/{licenseId}")
    public License getLicenseById(@PathVariable Long licenseId, @RequestBody Long userId)
    {
        return licenseService.getLicenseByUserId(licenseId, userId);
    }

   *//* GET /license/list в теле
    запроса companyId; возвращает
    список ID лицензий для
    полученной companyId.*//*
    @PostMapping
    public List<License> getAllLicensesByCompanyId(@RequestBody Long companyId){
        return licenseService.getAllLicensesByCompanyId(companyId);
    }*/

    /*POST /license/check в теле запроса файл лицензии;
    возвращает 200 OK, если лицензия
    корректна и актуальна, иначе код
418 с типом ошибки в теле ответа:
    LICENSE_NOT_EXIST,
    LICENSE_EXPIRED*/
}
