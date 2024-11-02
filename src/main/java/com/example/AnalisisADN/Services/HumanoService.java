package com.example.AnalisisADN.Services;

import com.example.AnalisisADN.DTOs.HumanoDTO;
import com.example.AnalisisADN.Entities.Humano;

public interface HumanoService extends BaseService<Humano, Long>{
    public boolean isMutant(HumanoDTO humanoDTO) throws Exception;
}
