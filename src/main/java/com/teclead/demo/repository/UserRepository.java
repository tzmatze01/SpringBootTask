package com.teclead.demo.repository;

import com.teclead.demo.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    List<CustomUser> findByName(String name);

    List<CustomUser> findAll();

    Optional<CustomUser> findById(Long id);
}
