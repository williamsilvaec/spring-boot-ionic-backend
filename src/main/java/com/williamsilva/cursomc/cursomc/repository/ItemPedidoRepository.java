package com.williamsilva.cursomc.cursomc.repository;

import com.williamsilva.cursomc.cursomc.model.ItemPedido;
import com.williamsilva.cursomc.cursomc.model.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
