package com.devteam.banco_agencias.controllers;



import com.devteam.banco_agencias.entities.Agencia;
import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.services.AgenciaService;
import com.devteam.banco_agencias.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class FormAgenciaController {
    @Autowired
    private AgenciaService service;

    @Autowired
    private BancoService bancoService;


    @GetMapping("/agencia/formulario")
    public String exibirFormulario(Model model) {
        model.addAttribute("agencia", new Agencia());


        List<Banco> bancos = bancoService.findAll();
        model.addAttribute("bancos", bancos);

        return "/agencia/formulario";
    }



    @PostMapping("/agencias/insert")
    public String cadastrarAgencia(@ModelAttribute Agencia agencia) {
        service.insert(agencia);
        return "redirect:/agencia/listaAgencias";
    }

}
