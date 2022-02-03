package ru.cft.optimusgang.licenses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cft.optimusgang.licenses.repository.model.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
