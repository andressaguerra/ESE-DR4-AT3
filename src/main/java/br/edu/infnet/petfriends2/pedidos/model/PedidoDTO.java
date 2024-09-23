package br.edu.infnet.petfriends2.pedidos.model;

public class PedidoDTO {

    private String pedidoId;
    private String status;

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "pedidoId='" + pedidoId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}