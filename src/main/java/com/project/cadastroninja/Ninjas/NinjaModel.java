package com.project.cadastroninja.Ninjas;
import com.project.cadastroninja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    @Column (name = "rank")
    private String rank;

    // para os ninjas so teremos uma missão
    @ManyToOne
    @JoinColumn(name ="missoes_id") //foreing key ou chave estrangeira
    private MissoesModel missoes;


}
