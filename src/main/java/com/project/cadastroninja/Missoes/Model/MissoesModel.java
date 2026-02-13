package com.project.cadastroninja.Missoes.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.cadastroninja.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor 
@Data

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
    @JsonIgnore
    private List<NinjaModel> ninja;
}
