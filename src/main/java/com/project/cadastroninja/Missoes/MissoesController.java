package com.project.cadastroninja.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    // Injeção de dependência via construtor
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // CREATE: Criar uma nova missão
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID: " + novaMissao.getId() + ")");
    }

    // READ: Listar todas as missões
    @GetMapping("/listarTodos")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // READ: Buscar uma missão específica por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarID(@PathVariable Long id) {
        MissoesDTO missao = missoesService.buscarPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID " + id + " não encontrada no sistema.");
        }
    }

    // UPDATE: Alterar dados de uma missão existente
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        MissoesDTO atualizada = missoesService.atualizar(id, missoesDTO);
        if (atualizada != null) {
            return ResponseEntity.ok(atualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Não foi possível atualizar. ID " + id + " não existe.");
        }
    }

    // DELETE: Apagar uma missão por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id) {
        // Verificamos se existe antes de deletar para retornar a resposta correta
        if (missoesService.buscarPorId(id) != null) {
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok("Missão deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Missão com ID " + id + " não encontrada.");
        }
    }

    // DELETE ALL: Limpar o banco de missões
    @DeleteMapping("/apagaTudo")
    public ResponseEntity<String> deleteTudo() {
        missoesService.deletartudo();
        return ResponseEntity.ok("O banco de dados de missões foi limpo com sucesso.");
    }
}