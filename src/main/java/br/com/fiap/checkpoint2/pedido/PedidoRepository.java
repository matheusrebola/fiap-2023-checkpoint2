package br.com.fiap.checkpoint2.pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {
    Page<Pedido> findAllByAtivoTrue(Pageable paginacao);
}
