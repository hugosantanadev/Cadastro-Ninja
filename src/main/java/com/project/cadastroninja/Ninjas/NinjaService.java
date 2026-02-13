package com.project.cadastroninja.Ninjas;


import com.project.cadastroninja.Ninjas.Model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
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

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

}
