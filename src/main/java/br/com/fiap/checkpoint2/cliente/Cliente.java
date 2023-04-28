package br.com.fiap.checkpoint2.cliente;

import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_cliente;
    private String nome;
    private String inscricao_federal;
    private String cep;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.inscricao_federal = dados.inscricao_federal();
        this.cep = dados.cep();
    }

}
