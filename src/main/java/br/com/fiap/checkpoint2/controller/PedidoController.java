package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.pedido.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public void cadastrar (@RequestBody DadosCadastroPedido dados){
        repository.save(new Pedido(dados));
    }
    @GetMapping
    public Page<DadosListagemPedido> listar(@PageableDefault(size = 10, sort = {"codigo_produto"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPedido::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPedido dados) {
        var pedido = repository.getReferenceById(dados.numero_pedido());
        pedido.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{numero_pedido}")
    @Transactional
    public void excluir(@PathVariable Long numero_pedido) {
        var cliente = repository.getReferenceById(numero_pedido);
        cliente.excluir();
    }
}
