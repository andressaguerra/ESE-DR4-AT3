package br.edu.infnet.petfriends2.almoxarifado.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class PedidoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEstoque status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEstoque> itens;

    @Embedded
    private Localizacao localizacao;

    protected PedidoEstoque() {
    }

    public PedidoEstoque(String pedidoId, List<ItemEstoque> itens, Localizacao localizacao) {
        this.pedidoId = pedidoId;
        this.itens = itens;
        this.status = StatusPedidoEstoque.PREPARANDO;
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

    public StatusPedidoEstoque getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEstoque status) {
        this.status = status;
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }

    public void setItens(List<ItemEstoque> itens) {
        this.itens = itens;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public void prepararPedido() {
        if (status == StatusPedidoEstoque.PREPARANDO) {
            this.status = StatusPedidoEstoque.PRONTO_PARA_ENVIO;
        }
    }

    public void cancelarPedido() {
        if (status == StatusPedidoEstoque.PREPARANDO) {
            this.status = StatusPedidoEstoque.CANCELADO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoEstoque that = (PedidoEstoque) o;
        return Objects.equals(id, that.id) && Objects.equals(pedidoId, that.pedidoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedidoId);
    }
}