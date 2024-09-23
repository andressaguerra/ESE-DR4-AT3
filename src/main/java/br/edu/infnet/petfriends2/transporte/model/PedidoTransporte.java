package br.edu.infnet.petfriends2.transporte.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class PedidoTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusTransporte status;
    private String transportadora;
    private String codigoRastreamento;

    @Embedded
    private LocalizacaoTransporte localizacao;

    protected PedidoTransporte() {}

    public PedidoTransporte(String pedidoId, String transportadora, String codigoRastreamento, LocalizacaoTransporte localizacao) {
        this.pedidoId = Objects.requireNonNull(pedidoId);
        this.transportadora = Objects.requireNonNull(transportadora);
        this.codigoRastreamento = codigoRastreamento;
        this.status = StatusTransporte.EM_TRANSITO;
        this.localizacao = localizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public StatusTransporte getStatus() {
        return status;
    }

    public void setStatus(StatusTransporte status) {
        this.status = status;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public LocalizacaoTransporte getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoTransporte localizacao) {
        this.localizacao = localizacao;
    }

    public void atualizarStatus(StatusTransporte novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoTransporte that = (PedidoTransporte) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(pedidoId, that.pedidoId) &&
               Objects.equals(codigoRastreamento, that.codigoRastreamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedidoId, codigoRastreamento);
    }
}