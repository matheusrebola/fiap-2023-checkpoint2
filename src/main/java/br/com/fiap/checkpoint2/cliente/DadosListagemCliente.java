package br.com.fiap.checkpoint2.cliente;

public record DadosListagemCliente(Long codigo_cliente, String nome, String inscricao_federal, String cep){
        public DadosListagemCliente(Cliente cliente) {
                this(cliente.getCodigo_cliente(), cliente.getNome(), cliente.getInscricao_federal(), cliente.getCep());
        }
}
