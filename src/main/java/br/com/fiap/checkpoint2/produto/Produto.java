package br.com.fiap.checkpoint2.produto;

import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_produto;
    private String nome;
    private double preco;
    private String data_validade;
    private String data_garantia;
    private boolean em_estoque;
    private boolean ativo;


    public Produto (DadosCadastroProduto dados){
        this.codigo_produto = dados.codigo_produto();
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.data_validade = dados.data_validade();
        this.em_estoque = dados.em_estoque();
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.preco() != 0){
            this.preco = dados.preco();
        }
        if(dados.data_validade() != null){
            this.data_validade = dados.data_validade();
        }
        if(dados.em_estoque() != ativo){
            this.em_estoque = dados.em_estoque();
        }

    }

    public void excluir(){
        this.ativo = false;
    }

}
