package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.item.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;
    @PostMapping
    public void cadastrar (@RequestBody DadosCadastroItem dados){
        repository.save(new ItemPedido(dados));
    }
    @GetMapping
    public Page<DadosListagemItem> listar(@PageableDefault(size = 10, sort = {"sequencia"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemItem::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoItem dados) {
        var pedido = repository.getReferenceById(dados.numero_pedido());
        pedido.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{sequencia}")
    @Transactional
    public void excluir(@PathVariable Long sequencia) {
        var pedido = repository.getReferenceById(sequencia);
        pedido.excluir();
    }
}
