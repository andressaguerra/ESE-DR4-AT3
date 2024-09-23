package br.edu.infnet.petfriends2.almoxarifado.model;

import java.util.Objects;

public class Localizacao {

    private final String setor;
    private final String prateleira;
    private final String posicao;

    public Localizacao(String setor, String prateleira, String posicao) {
        this.setor = Objects.requireNonNull(setor, "Setor não pode ser nulo.");
        this.prateleira = Objects.requireNonNull(prateleira, "Prateleira não pode ser nula.");
        this.posicao = Objects.requireNonNull(posicao, "Posição não pode ser nula.");
    }

    public String getSetor() {
        return setor;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public String getPosicao() {
        return posicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return setor.equals(that.setor) &&
               prateleira.equals(that.prateleira) &&
               posicao.equals(that.posicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setor, prateleira, posicao);
    }

    @Override
    public String toString() {
        return "Localização: " + setor + ", Prateleira: " + prateleira + ", Posição: " + posicao;
    }
}