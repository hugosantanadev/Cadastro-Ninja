package com.project.cadastroninja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

   private NinjaService ninjaService;
   public NinjaController(NinjaService ninjaService) {
       this.ninjaService = ninjaService;
   }

        //add ninja CREATE
        @PostMapping("/criar")
        public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){

        return ninjaService.criarNinja(ninja);
        }

        // mostrar todos os ninjas CREATE

        @GetMapping("/listar/{Id}")
        public NinjaModel listarId(@PathVariable Long id){

        return ninjaService.BuscarPorId(id);
        }

        //listar todos os ninjas
        @GetMapping("/listar")
        public List<NinjaModel> ListarNinjas(){

       return ninjaService.listarNinjas();
        }

        // mostrar ninja por id

        @GetMapping("/ninjaId")
        public String MostrarNinjaId(){
        return "mostrando ninjaid";
    }


        //alterar dados UPDATE

        @PutMapping("/alterar/{id}")
        public NinjaModel AlterarPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.Atualizar(id,ninjaAtualizado);
        }


        // deletar ninja DELETE
        @DeleteMapping("/apagar/{Id}")
    public void ApagarId(@PathVariable Long Id){
        ninjaService.deletarNinja(Id);
        }


        @DeleteMapping("/deletarTudo")
        public void deletarTudo(){
       ninjaService.deletarTudo();
        }








}
