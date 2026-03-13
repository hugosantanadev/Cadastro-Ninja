package com.project.cadastroninja.Ninjas;

import com.project.cadastroninja.Missoes.MissoesDTO;
import com.project.cadastroninja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissoesDTO missoes;
    private String rank;
}
