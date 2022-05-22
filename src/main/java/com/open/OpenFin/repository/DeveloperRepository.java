package com.open.OpenFin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.open.OpenFin.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
