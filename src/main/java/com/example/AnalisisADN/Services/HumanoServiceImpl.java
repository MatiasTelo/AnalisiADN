package com.example.AnalisisADN.Services;

import com.example.AnalisisADN.DTOs.CountDTO;
import com.example.AnalisisADN.DTOs.HumanoDTO;
import com.example.AnalisisADN.Entities.Humano;
import com.example.AnalisisADN.Repositories.BaseRepository;
import com.example.AnalisisADN.Repositories.HumanoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class HumanoServiceImpl extends BaseServiceImpl<Humano, Long> implements HumanoService{

    @Autowired
    private HumanoRepository humanoRepository;

    public HumanoServiceImpl(BaseRepository<Humano, Long> baseRepository) {
        super(baseRepository);
    }
    private int countMutantDna = 0;
    private int countHumanDna = 0;

    @Transactional
    @Override
    public boolean isMutant(HumanoDTO humanoDTO) throws Exception {
        try {
            Humano humano = new Humano();
            humano.setdna(humanoDTO.getDna());
            boolean isMutant = humano.isMutant();

            // Guardamos en la base de datos si es mutante o no
            humanoRepository.save(humano);

            // Actualizamos contadores
            if (isMutant) {
                countMutantDna++;
            } else {
                countHumanDna++;
            }
            return isMutant;







        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    public CountDTO getStats() {
        double ratio = countHumanDna > 0 ? (double) countMutantDna / ((double) countMutantDna + countHumanDna): 0;
        return new CountDTO(countMutantDna, countHumanDna, ratio);
    }
}
