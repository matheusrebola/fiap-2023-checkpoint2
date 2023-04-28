package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.produto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

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
    public Page<DadosListagemProduto> listar(@PageableDefault(size = 10, sort = {"codigo_produto"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemProduto::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
        var produto = repository.getReferenceById(dados.codigo_produto());
        produto.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{codigo_produto}")
    @Transactional
    public void excluir(@PathVariable Long codigo_produto) {
        var cliente = repository.getReferenceById(codigo_produto);
        cliente.excluir();
    }
}
