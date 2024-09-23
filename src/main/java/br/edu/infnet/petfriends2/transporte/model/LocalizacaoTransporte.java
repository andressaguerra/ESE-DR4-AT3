package br.edu.infnet.petfriends2.transporte.model;

import java.util.Objects;

public class LocalizacaoTransporte {

    private final String cidade;
    private final String estado;

    public LocalizacaoTransporte(String cidade, String estado) {
        this.cidade = Objects.requireNonNull(cidade, "Cidade não pode ser nula.");
        this.estado = Objects.requireNonNull(estado, "Estado não pode ser nulo.");
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalizacaoTransporte that = (LocalizacaoTransporte) o;
        return cidade.equals(that.cidade) && estado.equals(that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidade, estado);
    }

    @Override
    public String toString() {
        return cidade + ", " + estado;
    }
}