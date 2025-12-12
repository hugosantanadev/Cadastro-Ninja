package com.project.cadastroninja.Missoes.Model;


import com.project.cadastroninja.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String rank;

    // uma missao para varios ninjas

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;
}
