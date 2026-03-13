package com.project.cadastroninja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
       this.ninjaService = ninjaService;
       this.ninjaRepository = ninjaRepository;
   }

        //add ninja CREATE
        //o ResponseEntity possiblita personalizar as respostas das requisições
        @PostMapping("/criar")
            public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
            NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("ninja criado com sucesso: " + novoNinja);
        }

        // mostrar todos os ninjas CREATE

        @GetMapping("/listar/{Id}")
            public ResponseEntity<?> listarId(@PathVariable Long id){

                NinjaDTO ninja = ninjaService.BuscarPorId(id);

                if(ninja == null){
                    return ResponseEntity.ok("ninja encontrado: "+ ninja);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ninja não encontrado");
                }


        }

        //listar todos os ninjas
        @GetMapping("/listar")
            public ResponseEntity<List<NinjaDTO>> ListarNinjas(){
            List<NinjaDTO> ninjas = ninjaService.listarNinjas();

            return ResponseEntity.ok(ninjas);
        }

        //alterar dados UPDATE

        @PutMapping("/alterar/{id}")
        public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
            NinjaDTO ninja = ninjaService.Atualizar(id, ninjaAtualizado);
            if (ninja != null) {
                return ResponseEntity.ok(ninja);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ninja com o id: " + id + " nao existe nos nossos registros");
            }
        }


        // deletar ninja DELETE
        @DeleteMapping("/apagar/{Id}")
            public ResponseEntity<String> ApagarId(@PathVariable Long Id){

            if (ninjaService.BuscarPorId(Id) == null) {
                ninjaService.deletarNinja(Id);
                return ResponseEntity.ok("ninja deletado com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("o ninja que voce digitou não existe");
            }

        }
        @DeleteMapping("/deletarTudo")
            public void deletarTudo(){
       ninjaService.deletarTudo();
        }








}
