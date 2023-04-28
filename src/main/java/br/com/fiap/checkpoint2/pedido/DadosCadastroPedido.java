package br.com.fiap.checkpoint2.pedido;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroPedido(

        @NotNull
        Long numero_pedido,
        @NotNull
        String codigo_cliente,
        @NotNull
        String data_pedido
)
{

}
