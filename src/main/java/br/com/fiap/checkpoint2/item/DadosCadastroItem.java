package br.com.fiap.checkpoint2.item;

public record DadosCadastroItem(
    Long numero_pedido,
    String codigo_produto,
    String quanidade,
    String valor_total
)
{

}
