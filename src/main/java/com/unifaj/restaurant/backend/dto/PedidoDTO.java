package com.unifaj.restaurant.backend.dto;

import java.util.Date;
import java.util.List;

public record PedidoDTO(/*Boolean statusPago,*/ Date dataPedido, Integer idMesa, Integer idCliente,
                                                List<ItensPedidoDTO> itens) {
}
