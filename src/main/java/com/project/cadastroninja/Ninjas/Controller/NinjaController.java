package com.project.cadastroninja.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping("/teste")
    String tuamae(){
        return "funcionando";
    }

    //add ninja CREATE
        @PostMapping("/add")
    public String add(){
            return "funcionando";
    }
    // mostrar todos os ninjas CREATE
        @GetMapping("/todosid")
    public String AllId(){
        return "funcionando allid";
        }
    // mostrar ninja por id

        @GetMapping("/ninjaid")
    public String MostrarNinjaId(){
        return "mostrando ninjaid";
    }
    //alterar dados UPDATE
        @PutMapping("/alterarId")
    public String AlterarPorId(){
        return "alterar";
        }
    // deletar ninja DELETE
        @DeleteMapping("/apagar")
    public String ApagarId(){
        return "apagaid";
        }


}
