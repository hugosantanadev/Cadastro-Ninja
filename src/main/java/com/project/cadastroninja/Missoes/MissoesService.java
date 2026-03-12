package com.project.cadastroninja.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    public MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // cria um ArrayList para puxar todos as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //resquestbody para mandar algo para o banco de dados
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    //busca o id e caso não exista ele retorna nulo
    public MissoesModel buscarPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);

    }

    public void deletarMissoes(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizar (long id, MissoesModel missoesAtulizado){
        if(missoesRepository.existsById(id)){
            missoesAtulizado.setId(id);
        }
        return missoesRepository.save(missoesAtulizado);
    }

    public void deletartudo (){
        missoesRepository.deleteAll();
    }

}
