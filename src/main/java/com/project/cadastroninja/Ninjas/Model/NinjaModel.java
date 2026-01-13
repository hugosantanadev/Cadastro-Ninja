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
    @Column (name = "id")
    Long id;

    @Column (name = "name")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    // para os ninjas so teremos uma missão
    @ManyToOne
    @JoinColumn(name ="missoes_id") //foreing key ou chave estrangeira
    private MissoesModel missoes;


}
