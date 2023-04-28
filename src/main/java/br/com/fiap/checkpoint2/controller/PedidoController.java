package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.cliente.Cliente;
import br.com.fiap.checkpoint2.cliente.DadosAtualizacaoCliente;
import br.com.fiap.checkpoint2.cliente.DadosListagemCliente;
import br.com.fiap.checkpoint2.pedido.DadosCadastroPedido;
import br.com.fiap.checkpoint2.pedido.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public void cadastrar (@RequestBody DadosCadastroPedido dados){
        repository.save(new Cliente(dados));
    }
    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"codigo_produto"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCliente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.codigo_produto());
        cliente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{codigo_produto}")
    @Transactional
    public void excluir(@PathVariable Long codigo_produto) {
        var cliente = repository.getReferenceById(codigo_produto);
        cliente.excluir();
    }
}
