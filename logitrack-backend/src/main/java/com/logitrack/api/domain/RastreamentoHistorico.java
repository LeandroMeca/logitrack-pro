package com.logitrack.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rastreamento_historico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RastreamentoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento FK com Pedido
    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    // Relacionamento FK com Usuario (Entregador)
    @ManyToOne(optional = false)
    @JoinColumn(name = "entregador_id", nullable = false)
    private Usuario entregador;

    @Column(nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 11, scale = 8)
    private BigDecimal longitude;

    @Column(name = "data_hora", updatable = false)
    private LocalDateTime dataHora;

    @PrePersist
    protected void onCreate() {
        this.dataHora = LocalDateTime.now();
    }
}