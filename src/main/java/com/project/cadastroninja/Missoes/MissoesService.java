package com.project.cadastroninja.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper; // O Mapper precisa estar aqui!

    // Construtor atualizado com os dois parâmetros
    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map) // Transforma cada Model em DTO
                .collect(Collectors.toList());
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel model = missoesMapper.map(missoesDTO);
        model = missoesRepository.save(model);
        return missoesMapper.map(model);
    }

    public MissoesDTO buscarPorId(Long id) {
        return missoesRepository.findById(id)
                .map(missoesMapper::map) // Se achar, mapeia para DTO
                .orElse(null);
    }

    public MissoesDTO atualizar(Long id, MissoesDTO missoesDTO) {
        if (missoesRepository.existsById(id)) {
            MissoesModel model = missoesMapper.map(missoesDTO);
            model.setId(id);
            model = missoesRepository.save(model);
            return missoesMapper.map(model);
        }
        return null;
    }

    public void deletarMissoes(Long id) {
        missoesRepository.deleteById(id);
    }

    public void deletartudo() {
        missoesRepository.deleteAll();
    }
}