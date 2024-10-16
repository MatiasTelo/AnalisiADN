package com.example.AnalisisADN.Repositories;

import com.example.AnalisisADN.Entities.Humano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanoRepository extends BaseRepository<Humano, Long> {
}
