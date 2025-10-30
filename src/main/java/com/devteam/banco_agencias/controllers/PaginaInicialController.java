package com.devteam.banco_agencias.controllers;


import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PaginaInicialController {

    @Autowired
    private BancoService service;


    @GetMapping("/")
    public String paginaInicial(Model model) {
        List<Banco> bancos = service.findAll();
        model.addAttribute("bancos", bancos);
        return "paginaInicial";
    }

    @GetMapping("/api/bancos/{id}")
    @ResponseBody
    public Banco exibirBanco(@PathVariable Long id) {
        return service.findById(id);

    }

}
