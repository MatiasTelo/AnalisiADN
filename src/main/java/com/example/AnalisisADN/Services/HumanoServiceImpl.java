package com.example.AnalisisADN.Services;

import com.example.AnalisisADN.Entities.Humano;
import com.example.AnalisisADN.Repositories.BaseRepository;
import com.example.AnalisisADN.Repositories.HumanoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HumanoServiceImpl extends BaseServiceImpl<Humano, Long> implements HumanoService{

    @Autowired
    private HumanoRepository humanoRepository;

    public HumanoServiceImpl(BaseRepository<Humano, Long> baseRepository) {
        super(baseRepository);
    }
}
