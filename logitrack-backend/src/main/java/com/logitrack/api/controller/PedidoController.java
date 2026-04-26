package com.logitrack.api.controller;

import com.logitrack.api.domain.Pedido;
import com.logitrack.api.repository.PedidoRepository;
import com.logitrack.api.service.PedidoService; // <-- Importante
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final PedidoService pedidoService; // <-- Injetando o Serviço

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        // Agora quem cria é o Service, aplicando as regras de negócio!
        Pedido novoPedido = pedidoService.criar(pedido);
        return ResponseEntity.ok(novoPedido);
    }
}