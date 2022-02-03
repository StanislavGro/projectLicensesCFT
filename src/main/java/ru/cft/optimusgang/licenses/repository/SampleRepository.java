package ru.cft.optimusgang.licenses.repository;

import ru.cft.optimusgang.licenses.repository.model.SampleEntity;

import java.util.List;

public interface SampleRepository {

    public List<SampleEntity> selectAll();

}
