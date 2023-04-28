package br.com.fiap.checkpoint2.produto;

public record DadosListagemProduto(
        Long codigo_produto,
        String nome,
        double preco,
        String data_validade,
        String data_garantia,
        boolean em_estoque
)
{

    public DadosListagemProduto(Produto produto){
        this(produto.getCodigo_produto(), produto.getNome(), produto.getPreco(), produto.getData_validade(), produto.getData_garantia(), produto.isEm_estoque());
    }
}
