package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.produto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;
    @PostMapping
    public void cadastrar (@RequestBody DadosCadastroProduto dados){
        repository.save(new Produto(dados));
    }
    @GetMapping
    public Page<DadosListagemProduto> listar(@PageableDefault(size = 10, sort = {"numero_pedido"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemProduto::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
        var cliente = repository.getReferenceById(dados.codigo_cliente());
        cliente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{numero_pedido}")
    @Transactional
    public void excluir(@PathVariable Long numero_pedido) {
        var cliente = repository.getReferenceById(numero_pedido);
        cliente.excluir();
    }
}
