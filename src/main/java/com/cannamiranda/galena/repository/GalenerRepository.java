package com.cannamiranda.galena.repository;

import com.cannamiranda.galena.model.Galener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalenerRepository extends JpaRepository<Galener, String> {

    List<Galener> findByEmail(String email);
}
