package com.devteam.banco_agencias.controllers;



import com.devteam.banco_agencias.entities.Agencia;
import com.devteam.banco_agencias.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FormAgenciaController {
    @Autowired
    private AgenciaService service;


    @GetMapping("/agencia/formulario")
    public String exibirFormulario(Model model) {
        model.addAttribute("agencia", new Agencia());
        return "/agencia/formulario";
    }

    @PostMapping("/agencias/insert")
    public String cadastrarAgencia(@ModelAttribute Agencia agencia) {
        service.insert(agencia);
        return "redirect:/agencia/listaAgencias";
    }

}
