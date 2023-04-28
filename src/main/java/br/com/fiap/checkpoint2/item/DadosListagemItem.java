package br.com.fiap.checkpoint2.item;

public record DadosListagemItem(
        Long numero_pedido,
        String codigo_produto,
        String quanidade
)
{

    public DadosListagemItem(ItemPedido itemPedido) {
        this(itemPedido.getNumero_pedido(), itemPedido.getQuanidade(),itemPedido.getValor_total());
    }
}
