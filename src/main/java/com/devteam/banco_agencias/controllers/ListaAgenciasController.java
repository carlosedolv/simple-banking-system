package com.devteam.banco_agencias.controllers;


import com.devteam.banco_agencias.entities.Agencia;
import com.devteam.banco_agencias.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ListaAgenciasController {

    @Autowired
    private AgenciaService service;


    @GetMapping("/agencia/listaAgencias")
    public String listaAgencias(
            @RequestParam(value = "id", required = false) Long id,
            Model model
    ) {
        List<Agencia> agencias = service.findAll();
        model.addAttribute("agencias", agencias);

        if (id != null) {
            Agencia agencia = service.findById(id);
            model.addAttribute("agenciaEncontrada", agencia);
        }

        return "/agencia/listaAgencias";
    }


}
