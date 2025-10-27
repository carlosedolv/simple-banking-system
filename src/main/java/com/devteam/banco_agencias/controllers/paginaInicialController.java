package com.devteam.banco_agencias.controllers;


import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class  paginaInicialController {

    @Autowired
    private BancoService service;


    @GetMapping("/")
    public String paginaInicial(Model model) {
        List<Banco> bancos = service.findAll();
        model.addAttribute("bancos", bancos);
        return "paginaInicial";
    }
}
