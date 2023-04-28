package br.com.fiap.checkpoint2.produto;

public record DadosCadastroProduto(

        String nome,
        String preco,
        String data_validade,
        String data_garantia,
        String em_estoque
)
{

}
