package br.com.fiap.checkpoint2.pedido;

import br.com.fiap.checkpoint2.cliente.Cliente;

public record DadosListagemPedido(
        Long numero_pedido,
        String data_pedido
) {
    public DadosListagemPedido(Pedido pedido) {
        this(pedido.getNumero_pedido(), pedido.getData_pedido());
    }

}
