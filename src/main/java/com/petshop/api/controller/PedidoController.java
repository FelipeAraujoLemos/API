package com.petshop.api.controller;

import com.petshop.api.model.Pedido;
import com.petshop.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return service.criarPedido(pedido);
    }
}