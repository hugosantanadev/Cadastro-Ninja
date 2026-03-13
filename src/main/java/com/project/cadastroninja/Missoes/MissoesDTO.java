package com.project.cadastroninja.Missoes;
import com.project.cadastroninja.Ninjas.NinjaDTO;
import com.project.cadastroninja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesDTO {

    private Long id;

    private String nome;

    private String rank;

    private List<NinjaDTO> ninja;
}
