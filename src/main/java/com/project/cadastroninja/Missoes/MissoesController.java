package com.project.cadastroninja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {


    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listarTodos")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //pathvariable para mandar um id por meio da url
    @GetMapping("/listar/{id}")
    public MissoesModel listarID (@PathVariable long id){
        return missoesService.buscarPorId(id);
    }


    //mandar uma requisição para criar
    @PostMapping("/criar")
    public MissoesModel CriarMissoes(@RequestBody MissoesModel missoes)
    {

        return missoesService.criarMissoes(missoes);
    }

    // requisição para alterar
    @PutMapping("/alterar/{id}")
    public MissoesModel AlterarMissoes(@PathVariable Long id, @RequestBody MissoesModel missoesAtualizado)
    {

        return missoesService.atualizar(id, missoesAtualizado) ;
    }

    //rrrequisição para delatar
    @DeleteMapping("/deletar/{id}")

    public void deletarMissoes(Long id)
    {
        missoesService.deletarMissoes(id);
    }

    @DeleteMapping("/apagaTudo")
    public void deleteTudo()
    {
        missoesService.deletartudo();
    }
}
