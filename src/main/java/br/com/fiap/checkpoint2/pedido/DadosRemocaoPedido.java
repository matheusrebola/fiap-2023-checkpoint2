package br.com.fiap.checkpoint2.pedido;

public record DadosRemocaoPedido(
        Long numero_pedido,
        String codigo_cliente,
        String data_pedido
) {

}
