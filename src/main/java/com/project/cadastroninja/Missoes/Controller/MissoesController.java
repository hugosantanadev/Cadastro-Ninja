package com.project.cadastroninja.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")

public class MissoesController {


    //mandar uma requisição
    @GetMapping("/listar")
    public String listar()
    {
        return "listar";
    }

    //mandar uma requisição para criar
    @PostMapping("/criar")
    public String CriarMissoes()
    {
        return "Criado com sucesso";
    }

    // requisição para alterar
    @PutMapping("/alterar")
    public String AlterarMissoes()
    {
        return "Alterado com sucesso";
    }

    //rrrequisição para delatar
    @DeleteMapping("/deletar")

    public String deletarMissoes()
    {
        return "Deletado com sucesso";
    }
}
