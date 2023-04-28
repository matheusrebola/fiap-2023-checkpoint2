package br.com.fiap.checkpoint2.produto;

public record DadosCadastroProduto(

        Long codigo_produto,
        String nome,
        double preco,
        String data_validade,
        String data_garantia,
        boolean em_estoque
)
{

}
