package br.com.fiap.checkpoint2.item;

public record DadosRemocaoItem(
        Long numero_pedido,
        String codigo_produto,
        String quanidade,
        String valor_total,

        boolean ativo
) {

}
