package com.example.AnalisisADN.Controllers;

import com.example.AnalisisADN.Entities.Humano;
import com.example.AnalisisADN.Services.BaseServiceImpl;
import com.example.AnalisisADN.Services.HumanoService;
import com.example.AnalisisADN.Services.HumanoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/humanos")
public class HumanoController extends BaseControllerImpl<Humano, HumanoServiceImpl>{
    @Autowired
    private HumanoServiceImpl humanoService;


}
