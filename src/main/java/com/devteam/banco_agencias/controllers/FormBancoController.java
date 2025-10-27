package com.devteam.banco_agencias.controllers;

import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.services.BancoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class FormBancoController {
    @Autowired
    private BancoService service;

    @GetMapping("/formulario")
    public String exibirFormulario(Model model) {
        model.addAttribute("banco", new Banco());
        return "formulario";
    }

    @PostMapping("/insert")
    public String cadastrarBanco(@ModelAttribute Banco banco) {
        service.insert(banco);
        return "redirect:/";
    }

}
