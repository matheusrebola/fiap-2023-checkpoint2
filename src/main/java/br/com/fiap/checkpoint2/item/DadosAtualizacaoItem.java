package br.com.fiap.checkpoint2.item;

import br.com.fiap.checkpoint2.produto.Produto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoItem(
        @NotNull
        Long numero_pedido,
        Produto codigo_produto,
        String quantidade,
        String valor_total
)
{


}
