package com.project.cadastroninja.Ninjas.Model;
import com.project.cadastroninja.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cadastro")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // para os ninjas so teremos uma missão
    @ManyToOne
    @JoinColumn(name ="missoes_id")
    private MissoesModel missoes;


}
