package com.project.cadastroninja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    // MODEL -> DTO (Para enviar dados para o usuário)
    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setRank(missoesModel.getRank());
        return missoesDTO;
    }

    // DTO -> MODEL (Para salvar dados enviados pelo usuário)
    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setRank(missoesDTO.getRank());
        return missoesModel;
    }
}