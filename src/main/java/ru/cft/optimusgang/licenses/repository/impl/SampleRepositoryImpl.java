package ru.cft.optimusgang.licenses.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.optimusgang.licenses.repository.model.SampleEntity;
import ru.cft.optimusgang.licenses.repository.SampleRepository;

import java.util.List;

@Repository
public class SampleRepositoryImpl implements SampleRepository {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<SampleEntity> rowMapper;

    @Autowired
    public SampleRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<SampleEntity> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<SampleEntity> selectAll() {
        return jdbcTemplate.query("Select * from sample;", rowMapper);
    }
}
