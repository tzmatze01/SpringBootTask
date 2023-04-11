package com.teclead.demo.repositories;

import com.teclead.demo.models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    List<CustomUser> findByName(String name);

}
