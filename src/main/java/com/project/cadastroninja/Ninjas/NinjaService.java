package com.project.cadastroninja.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {



    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar ninjas

    public List<NinjaDTO> listarNinjas(){
       List<NinjaModel> ninjas = ninjaRepository.findAll();
       return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    //buscar por id
    public NinjaDTO BuscarPorId(Long id){

    Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
    return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO Atualizar(Long Id, NinjaDTO ninjaDto){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(Id); //se o id existir
        if (ninjaPorId.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDto); // ninjaAtualizado é uma variavel que é atribuida oq no dto
            ninjaAtualizado.setId(Id); //muda oq esta no id
            NinjaModel ninja = ninjaRepository.save(ninjaAtualizado);//salva
            return ninjaMapper.map(ninja);

        }

        return null;

    }


}
