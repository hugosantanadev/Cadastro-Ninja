package com.project.cadastroninja.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {



    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar ninjas

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //buscar por id
    public NinjaModel BuscarPorId(Long id){

    Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
    return ninjaPorId.orElse(null);
    }

    // criar ninjas
    public NinjaDTO criarNinja( NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //delete tem que ser void
    public void deletarNinja(Long Id){
       ninjaRepository.deleteById(Id);
        ;
    }

    public void deletarTudo (){
        ninjaRepository.deleteAll();
    }


    //vai buscar por id e depois descobrir se ele existe, vai buscar atravez do metodo do jpa
    public NinjaModel Atualizar(Long Id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(Id)) {
            ninjaAtualizado.setId(Id);

        }
        return ninjaRepository.save(ninjaAtualizado);
    }


}
