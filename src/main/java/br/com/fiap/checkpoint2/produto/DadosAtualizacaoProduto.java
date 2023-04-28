package br.com.fiap.checkpoint2.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(

        @NotNull
        Long codigo_produto,
        String nome,
        double preco,
        String data_validade,
        String data_garantia,
        boolean em_estoque
)
{

}
