package br.com.fiap.checkpoint2.item;

import br.com.fiap.checkpoint2.produto.Produto;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "itens_pedidos")
@Entity(name = "ItemPedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "sequencia")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero_pedido;
    private Produto codigo_produto;
    private String quanidade;
    private String valor_total;
    private Boolean ativo;

    public ItemPedido(DadosCadastroItem dados) {
        this.quanidade = dados.quanidade();
        this.valor_total = dados.valor_total();
        this.ativo = true;
    }
    public void atualizarInformacoes(DadosAtualizacaoItem dados) {
        if (dados.quantidade() != null) {
            this.quanidade = dados.quantidade();
        }
        if (dados.valor_total() != null) {
            this.valor_total = dados.valor_total();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
