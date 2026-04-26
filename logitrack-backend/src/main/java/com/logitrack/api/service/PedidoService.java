package com.logitrack.api.service;

import com.logitrack.api.domain.Pedido;
import com.logitrack.api.domain.StatusPedido;
import com.logitrack.api.domain.Usuario;
import com.logitrack.api.repository.PedidoRepository;
import com.logitrack.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public Pedido criar(Pedido pedido) {

        Usuario entregadorCompleto = usuarioRepository.findById(pedido.getEntregador().getId())
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado no sistema!"));

        pedido.setEntregador(entregadorCompleto);

        // Agora usamos o Enum para travar o status inicial!
        pedido.setStatus(StatusPedido.PENDENTE);

        return pedidoRepository.save(pedido);
    }
}