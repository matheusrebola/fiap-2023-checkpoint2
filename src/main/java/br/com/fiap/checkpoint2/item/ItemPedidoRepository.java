package br.com.fiap.checkpoint2.item;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository  <ItemPedido, Long> {
    Page<ItemPedido> findAll(Pageable paginacao);
}
