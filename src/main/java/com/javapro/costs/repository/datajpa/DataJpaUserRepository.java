package com.javapro.costs.repository.datajpa;

import com.javapro.costs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaUserRepository extends JpaRepository<User, Long> {


}
