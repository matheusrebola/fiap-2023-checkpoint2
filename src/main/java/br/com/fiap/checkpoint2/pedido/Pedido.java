package br.com.fiap.checkpoint2.pedido;

import br.com.fiap.checkpoint2.cliente.Cliente;
import br.com.fiap.checkpoint2.cliente.DadosAtualizacaoCliente;
import br.com.fiap.checkpoint2.cliente.DadosCadastroCliente;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "pedidos")
@Entity(name = "Pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "numero_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero_pedido;
    private Cliente codigo_cliente;
    private String data_pedido;
    private boolean ativo;

    public Pedido(DadosCadastroPedido dados) {

        this.data_pedido = dados.data_pedido();
        this.ativo = true;
    }
    public void atualizarInformacoes(DadosAtualizacaoPedido dados) {
        if (dados.data_pedido() != null) {
            this.data_pedido = dados.data_pedido();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
