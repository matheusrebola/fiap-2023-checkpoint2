package br.com.fiap.checkpoint2.item;

import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "itens_pedidos")
@Entity(name = "ItemPedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "sequencia")
public class ItemPedido {
}
