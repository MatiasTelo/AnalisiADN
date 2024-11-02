package com.example.AnalisisADN.Controllers;

import com.example.AnalisisADN.DTOs.CountDTO;
import com.example.AnalisisADN.DTOs.HumanoDTO;
import com.example.AnalisisADN.Entities.Humano;
import com.example.AnalisisADN.Services.BaseServiceImpl;
import com.example.AnalisisADN.Services.HumanoService;
import com.example.AnalisisADN.Services.HumanoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/humanos/mutant")
public class HumanoController extends BaseControllerImpl<Humano, HumanoServiceImpl>{
    @Autowired
    private HumanoServiceImpl humanoService;

    @PostMapping("")
    public ResponseEntity<String> checkMutant(@RequestBody HumanoDTO humanoDTO) {
        try {
            boolean isMutant = humanoService.isMutant(humanoDTO);
            return isMutant
                    ? ResponseEntity.status(HttpStatus.OK).body("Mutant detected.")
                    : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not a mutant.");
        } catch (IllegalArgumentException e) {
            // Devuelve un 400 si ocurre una excepción de validación
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // En caso de errores inesperados, devuelve un 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
    @GetMapping("/stats") // Nuevo endpoint para estadísticas
    public ResponseEntity<CountDTO> getStats() {
        CountDTO stats = humanoService.getStats();
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }


}
