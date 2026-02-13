package com.project.cadastroninja.Ninjas.Controller;

import com.project.cadastroninja.Ninjas.Model.NinjaModel;
import com.project.cadastroninja.Ninjas.NinjaService;
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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){

       return ninjaService.criarNinja(ninja);
    }

    // mostrar todos os ninjas CREATE

    @GetMapping("/listar/{id}")
    public NinjaModel listarId(@PathVariable Long id){

       return ninjaService.BuscarPorId(id);
    }

    //listar todos os ninjas

        @GetMapping("/listar")
    public List<NinjaModel> AllId(){

       return ninjaService.listarNinjas();
        }

        // mostrar ninja por id

        @GetMapping("/ninjaId")
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
