package br.com.fiap.checkpoint2.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
public interface ClienteRepository extends JpaRepository <Cliente,Long> {
    Page<Cliente> findAll(Pageable paginacao);
}
