package ru.cft.yellowrubberduck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cft.yellowrubberduck.repository.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
