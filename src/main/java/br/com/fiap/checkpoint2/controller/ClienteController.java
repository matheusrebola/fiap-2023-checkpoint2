package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @PostMapping
    public void cadastrar (@RequestBody DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }
    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"codigo_cliente"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCliente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.codigo_cliente());
        cliente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{codigo_cliente}")
    @Transactional
    public void excluir(@PathVariable Long codigo_cliente) {
        var cliente = repository.getReferenceById(codigo_cliente);
        cliente.excluir();
    }
}
